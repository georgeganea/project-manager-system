package usr.speedy.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerServlet
 */
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/programmers";
			connection = DriverManager.getConnection(url,"speedy", "speedy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<HTML><HEAD><TITLE>Task Manager</TITLE></HEAD>");
		out.print("</UL><HR><FORM METHOD=POST>");
		out.print("<BODY>Add task:<HR>");
		out.print("Task name: <INPUT TYPE=TEXT NAME=taskName><BR>");
		out.print("No of programmers: <INPUT TYPE=TEXT NAME=numberOfProgrammers><BR>");
		out.print("<INPUT TYPE=SUBMIT NAME=action VALUE=Ok>");
		out.print("<INPUT TYPE=SUBMIT NAME=action VALUE=Cancel>");
		out.print("</FORM></BODY></HTML>");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");

	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
