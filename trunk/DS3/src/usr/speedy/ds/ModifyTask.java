package usr.speedy.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebService;


@WebService
public class ModifyTask {
	private Connection connection;
	public ModifyTask(){
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
	
	public String modifyTask(String taskName){
        if (taskName == null || taskName.trim().equals("")){
                return "Task name cannot be empty";
        }
        //int taskID = findTask(taskName);
        //return Integer.toString(taskID);
        return findTask(taskName);
	}
	
	 private String findTask(String taskName) {
         if (connection != null){
                 Statement stmt;
                 try {
                         stmt = connection.createStatement();
                         ResultSet duplicateName = stmt.executeQuery("SELECT COUNT(*) AS exista FROM tasks WHERE name='"+taskName+"' and status='open'");
                         duplicateName.next();
                         int exists = duplicateName.getInt("exista");
                         if (exists != 1){
                                 if (exists == 0)
                                         return "Task "+taskName+" does not exist or is closed";
                                 else
                                         return "The database is malformed: duplicate task names";
                                 
                         }
                         else{
                                 ResultSet records = stmt.executeQuery("SELECT * FROM tasks WHERE name ='"+taskName+"'");// = (SELECT id FROM tasks WHERE name='"+taskName+"')");
                                 while(records.next()){
                                         return records.getString("id");// Integer.parseInt(records.getString("id"));
                                 }
                         }
                         return Integer.toString(-3);
                 }
                 catch (SQLException e) {
                         e.printStackTrace();
                         return "Error inserting data";
                 }
         }
         return Integer.toString(-4);
 }
}
