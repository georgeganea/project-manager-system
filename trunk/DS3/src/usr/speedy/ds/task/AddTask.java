package usr.speedy.ds.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.jws.WebService;


/**
 * add a task to the database
 */

@WebService
public class AddTask {

	private Connection connection;

	public AddTask() {
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
	

	public String addTask(String taskName, String noOfProgrammers){
		
		if (taskName == null || taskName.trim().equals("")){
			return "Task name cannot be empty";
		}
		if (noOfProgrammers == null || noOfProgrammers.trim().equals("")){
			return "Number of programmers cannot be empty";
		}
		try{
			int noOfProg = Integer.parseInt(noOfProgrammers);
			if (noOfProg <= 0)
				return "Invalid number of programmers";
			return addToDataBase(taskName, noOfProg);
		}
		catch(NumberFormatException e){
			return "Invalid number format";
		}
	}

	private String addToDataBase(String taskName, int noOfProg) {
		
		List<String> allNames = new ArrayList<String>();
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT COUNT(*) AS cnt FROM programmers WHERE status='available'");
				recordCnt.next();
				int count = recordCnt.getInt("cnt");
				if (count < noOfProg){
					return "The requested number of programmers is not available";
				}
				else{
					ResultSet duplicateName = stmt.executeQuery("SELECT COUNT(*) AS duplCnt FROM tasks WHERE name='"+taskName+"'");
					duplicateName.next();
					int duplicate = duplicateName.getInt("duplCnt");
					if (duplicate != 0){
						return "Task name already exists";
					}
					ResultSet records = stmt.executeQuery("SELECT * FROM programmers WHERE status='available'");
					int cnt = 0;
					while(records.next()){
						String str = records.getString("id");
						allNames.add(str);
						cnt++;
						if (cnt == noOfProg)
							break;
					}//end while loop
					for (String name : allNames) {
						stmt.execute("UPDATE programmers SET status='busy' WHERE id="+name);
					}
					stmt.execute("INSERT INTO tasks(name, status, nopeople) VALUES ('"+taskName+"'"+",'open',"+noOfProg+")");
					ResultSet lastInsertedTask = stmt.executeQuery("SELECT * FROM tasks WHERE id = (SELECT MAX(id) FROM tasks)");
					lastInsertedTask.next();
					int lastInserted = lastInsertedTask.getInt("id");
					for (String string : allNames) {
						stmt.execute("INSERT INTO assingments(prgID, tskID) VALUES ("+string+","+lastInserted+")");
					}
					return "Task "+ taskName+" successfully added";
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				return "Error inserting data";
			}
		}
			
		else
			return "Connection expired";
			
		
	}

}
