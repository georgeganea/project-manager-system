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
public class CloseTask {

	private Connection connection;

	public CloseTask() {
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
	

	public String closeTask(String taskName){
		
		if (taskName == null || taskName.trim().equals("")){
			return "Task name cannot be empty";
		}
	
		return deleteFromDataBase(taskName);
	}

	private String deleteFromDataBase(String taskName) {
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet duplicateName = stmt.executeQuery("SELECT COUNT(*) AS exista FROM tasks WHERE name='"+taskName+"' and status='open'");
				duplicateName.next();
				int exists = duplicateName.getInt("exista");
				if (exists != 1){
					if (exists == 0)
						return "Task name does not exist or is closed";
					else
						return "The database is malformed: duplicate task names";
				}
				else{
					stmt.execute("UPDATE tasks SET status='closed' WHERE name='"+taskName+"'");
					List<String> allAssignments = new ArrayList<String>();
					List<String> allProg = new ArrayList<String>();
					ResultSet records = stmt.executeQuery("SELECT * FROM assingments WHERE tskID = (SELECT id FROM tasks WHERE name='"+taskName+"')");
					while(records.next()){
						allAssignments.add(records.getString("assID"));
						allProg.add(records.getString("prgID"));
					}
					for (String prog : allProg) {
						stmt.execute("UPDATE programmers SET status='available' WHERE id="+prog);
					}
					for (String assign : allAssignments) {
						stmt.execute("DELETE FROM assingments WHERE assID = "+assign);
					}
				}
				return "Task "+ taskName+" successfully closed";
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
