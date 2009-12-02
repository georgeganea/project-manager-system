package usr.speedy.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.jws.WebService;


/**
 * add a programmer to the database
 */

@WebService
public class AddProgrammer {

	private Connection connection;

	public AddProgrammer() {
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

	public String addProgrammer(String progName){
		if (progName == null || progName.trim().equals("")){
			return "Please insert Programmer name. It cannot be empty";
		}
		return addToDataBase(progName);
	}

	private String addToDataBase(String progName) {

		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet duplicateName = stmt.executeQuery("SELECT COUNT(*) AS duplCnt FROM programmers WHERE name='"+progName+"'");
				duplicateName.next();
				int duplicate = duplicateName.getInt("duplCnt");
				if (duplicate != 0){
					return "Programmer name already exists";
				}
				stmt.execute("INSERT INTO programmers(name)VALUES ('"+progName+"')");
				return "Successfully hired "+progName; 
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
