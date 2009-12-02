package usr.speedy.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.jws.WebService;


@WebService
public class FireProgrammer {

	private Connection connection;
	public FireProgrammer(){
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
	
	
	public String fireProgrammer(String progName){
		if (progName == null || progName.trim().equals("")){
			return "Please insert Programmer name. It cannot be empty";
		}
                   return deleteFromDataBase(progName);
    }
	
	private String deleteFromDataBase(String progName) {

        if (connection != null)
        {
                try{
                        Statement stmt = connection.createStatement();
                        ResultSet duplicateName = stmt.executeQuery("Select count(*) as exista from programmers where name='"+progName+"'");
                        duplicateName.next();
                        int exista = duplicateName.getInt("exista");
                        if( exista == 0)
                                return "No programmer with this name";
                        else
                        {
                                ResultSet busyProg = stmt.executeQuery("Select id as prgid, status as prgstatus from programmers where name='"+progName+"'");
                                busyProg.next();
                                String status = busyProg.getString("prgstatus");
                                if (status.contains("busy"))
                                {
                                        int prgid = busyProg.getInt("prgid");
                                        stmt.execute("Update tasks set nopeople = nopeople-1 where id = (Select tskID from assingments where prgID='" + prgid +"' )");
                                }
                                stmt.execute("Delete from programmers where name='"+progName+"'");
                               return "Programmer successfully fired";
                        }
                }
                catch (Exception e) {
                        e.printStackTrace();
        				return "Error deleting data";
                }
        }
        else
          return "connection expired";

}

}
