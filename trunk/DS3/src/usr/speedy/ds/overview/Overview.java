package usr.speedy.ds.overview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService
public class Overview {

	private Connection connection;

	public Overview() {
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

	public List<String> getTasks(){
		ArrayList<String> result = new ArrayList<String>();
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT name n FROM tasks;");
				while (recordCnt.next()) {
					String name = recordCnt.getString("n");
					result.add(name);
				}

			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<String> getOpenTasks(){
		ArrayList<String> result = new ArrayList<String>();
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT name nm FROM tasks WHERE status='open';");
				while (recordCnt.next()) {
					String name = recordCnt.getString("nm");
					result.add(name);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<String> getClosedTaks(){
		ArrayList<String> result = new ArrayList<String>();
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT name nm FROM tasks WHERE status='closed';");
				while (recordCnt.next()) {
					String name = recordCnt.getString("nm");
					result.add(name);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


	public List<String> getAvailableProgrammers() {
		ArrayList<String> result = new ArrayList<String>();
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT * FROM programmers WHERE status='available';");
				while (recordCnt.next()) {
					String name = recordCnt.getString(1);
					result.add(name);
				}

			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}	

	public List<String> getBusyProgrammers() {
		ArrayList<String> result = new ArrayList<String>();
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT * FROM programmers WHERE status='busy';");
				while (recordCnt.next()) {
					String name = recordCnt.getString(1);
					result.add(name);
				}

			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<String> getProgrammersForTask(String taskName){
		List<String> allProgrammers = new ArrayList<String>();
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet records = stmt.executeQuery("SELECT * FROM assingments WHERE tskID = (SELECT id FROM tasks WHERE name='"+taskName+"')");
				List<String> allProg = new ArrayList<String>();
				while(records.next()){
					allProg.add(records.getString("prgID"));
				}
				for (String prog : allProg) {
					ResultSet executeQuery = stmt.executeQuery("SELECT name nm FROM programmers WHERE id="+prog);
					while (executeQuery.next()) {
						String name = executeQuery.getString(1);
						allProgrammers.add(name);
					}
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return allProgrammers;
	}
}
