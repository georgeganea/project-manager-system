package usr.speedy.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;


@WebService
public class FoundTask {
	private Connection connection;
	public FoundTask(){
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/programmers";
			connection = DriverManager.getConnection(url,"speedy", "speedy");
			connection.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public String foundTask(int modified,String taskName,String noOfProgrammers){

        if (taskName == null || taskName.trim().equals("")){
                return "Task name cannot be empty";
        }
        if (noOfProgrammers == null || noOfProgrammers.trim().equals("")){
               return "Number of programmers cannot be empty";
        }
                int noOfProg = Integer.parseInt(noOfProgrammers);
                if (noOfProg <= 0)
                        return "Invalid number of programmers";
        return addToDataBase(modified,taskName, noOfProg);
        
	}
	private String addToDataBase(int id,String taskName, int noOfProg) {
        List<String> allNames = new ArrayList<String>();
        Statement stmt;
        try {
                stmt = connection.createStatement();
                ResultSet noPCnt = stmt.executeQuery("SELECT noPeople AS noP FROM tasks WHERE id="+id);
                noPCnt.next();
                int noP = noPCnt.getInt("noP");
                if (noP < noOfProg){
                        //add some programmers
                        ResultSet recordCnt = stmt.executeQuery("SELECT COUNT(*) AS cnt FROM programmers WHERE status='available'");
                        recordCnt.next();
                        int count = recordCnt.getInt("cnt");
                        int toAdd = noOfProg - noP;
                        if (count >= toAdd){
                                stmt.execute("UPDATE tasks SET name='"+taskName+"', noPeople="+noOfProg+" WHERE id="+id+";");
                                int cnt = 0;
                                ResultSet records = stmt.executeQuery("SELECT * FROM programmers WHERE status='available'");
                                while(records.next()){
                                        String str = records.getString("id");
                                        allNames.add(str);
                                        cnt++;
                                        if (cnt == toAdd)
                                                break;
                                }//end while loop
                                for (String name : allNames) {
                                        stmt.execute("UPDATE programmers SET status='busy' WHERE id="+name);
                                }
                                for (String string : allNames) {
                                        stmt.execute("INSERT INTO assingments(prgID, tskID) VALUES ("+string+","+id+")");
                                }
                                //      connection.commit();
                                return "Operation successful 1";
                        }
                        else
                                return "The requested number of programmers is not available";
                }
                else if (noP > noOfProg){
                        stmt.execute("UPDATE tasks SET name='"+taskName+"', noPeople="+noOfProg+" WHERE id="+id+";");
                        int i  = noP - noOfProg;
                        ResultSet records = stmt.executeQuery("SELECT * FROM assingments WHERE tskID="+id+" limit "+i+";");
                        while(records.next()){
                                String str = records.getString("prgID");
                                allNames.add(str);
                        }
                        for (String idName : allNames) {
                                stmt.execute("UPDATE programmers SET status='available' WHERE id="+idName);
                                stmt.execute("DELETE from assingments where prgID="+idName+";");
                        }
                        return "Operation successful 2";
                }
                else
                        if (noP == noOfProg){
                                stmt.execute("UPDATE tasks SET name='"+taskName+"', noPeople="+noOfProg+" WHERE id="+id+";");
                                return "Operation successful 3";
                        }
        } catch (SQLException e) {
                e.printStackTrace();
                return "eroare modificare task";
        }
		return "done";
       }
}
