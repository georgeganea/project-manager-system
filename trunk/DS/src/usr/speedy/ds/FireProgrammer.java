package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;

import java.sql.Statement;

/**
 * Servlet implementation class FireProgrammer
 */
public class FireProgrammer extends Programmers {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Programmers#Programmers()
	 */
	public FireProgrammer() {
		super();
	}

	protected void printContent(PrintWriter out, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(true);
			String result = (String)session.getAttribute("fireProgrammerMessage");
			if (result == null){
				util.printFromFile(out, "programmers/fireProgrammer.html");
				session.setAttribute("fireProgrammerMessage", null);
			}
			else {
				util.printReplacedText(out, "tasks/printMessage.html", "templateMessage", result);
				session.setAttribute("fireProgrammerMessage", null);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String progName = request.getParameter("prgname");
		if (progName == null || progName.trim().equals("")){
			message("Please insert Programmer name. It cannot be empty", request.getSession());
		}
		try{
			boolean result = deleteFromDataBase(progName,request);
			if (result)
				message("Programmer "+progName+" succesfully fired", request.getSession());
		}
		catch(NumberFormatException e){
			message("Invalid number format", request.getSession());
		}
		doGet(request, response);
	}

	private boolean deleteFromDataBase(String progName,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Connection conn = (Connection)session.getAttribute("connection");

		if (conn != null)
		{
			try{
				Statement stmt = conn.createStatement();
				ResultSet duplicateName = stmt.executeQuery("Select count(*) as exista from programmers where name='"+progName+"'");
				duplicateName.next();
				int exista = duplicateName.getInt("exista");
				if( exista == 0)
					message("No programmer with this name",session);
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
					message("Programmer successfully fired",session);
				}
			}
			catch (Exception e) {
				message("Error inserting data", session);
				e.printStackTrace();
			}
		}
		else
			message("connection expired",session);

		return false;
	}

	private void message(String string, HttpSession session) {
		session.setAttribute("fireProgrammerMessage", string);
	}

}
