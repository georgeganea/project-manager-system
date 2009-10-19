package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			message("Please insert Programmer name. It cannot be empty", request);
		}
		try{
			boolean result = deleteFromDataBase(progName,request);
			if (result)
				message("Programmer "+progName+" succesfully fired", request);
		}
		catch(NumberFormatException e){
			message("Invalid number format", request);
		}
		doGet(request, response);
	}

	private boolean deleteFromDataBase(String progName,HttpServletRequest request) {
		HttpServletRequest session = request;

		if (connection != null)
		{
			try{
				Statement stmt = connection.createStatement();
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

	private void message(String string, HttpServletRequest session) {
		session.setAttribute("fireProgrammerMessage", string);
	}

}
