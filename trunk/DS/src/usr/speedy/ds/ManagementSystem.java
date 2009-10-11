package usr.speedy.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagementSystem
 */
public class ManagementSystem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public ManagementSystem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<BIG>Hello World</BIG>");
		out.println("</BODY></HTML>");

		connect();


	}

	private void connect() {
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");


			String url =
				"jdbc:mysql://localhost:3306/mydb";

			Connection con =
				DriverManager.getConnection(
						url,"root", "");
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);

			Statement stmt = con.createStatement();
			ResultSet rs;

			rs = stmt.executeQuery("SELECT * " +
			"from programmers");

			System.out.println("Display all results: "+rs);
			while(rs.next()){
				
				String str = rs.getString("id");
				System.out.println("\t id= " 
						 + str);
			}//end while loop



			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
