package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddProgrammer
 */
public class AddProgrammer extends Programmers {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Programmers#Programmers()
	 */
	public AddProgrammer() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String progName = request.getParameter("prgname");
		if (progName == null || progName.trim().equals("")){
			message("Please insert Programmer name. It cannot be empty", request);
		}
		try{
			boolean result = addToDataBase(progName,request);
			if (result)
				message("Programmer "+progName+" succesfully added", request);
		}
		catch(NumberFormatException e){
			message("Invalid number format", request);
		}
		doGet(request, response);
	}

	private boolean addToDataBase(String progName, HttpServletRequest request) {

		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet duplicateName = stmt.executeQuery("SELECT COUNT(*) AS duplCnt FROM programmers WHERE name='"+progName+"'");
				duplicateName.next();
				int duplicate = duplicateName.getInt("duplCnt");
				if (duplicate != 0){
					message("Programmer name already exists", request);
					return false;
				}

				stmt.execute("INSERT INTO programmers(name)VALUES ('"+progName+"')");
				//connection.commit();
				return true;
			}
			catch (Exception e) {
				message("Error inserting data", request);
				e.printStackTrace();
			}
		}
		else
			message("Connection expired", request);

		return false;
	}

	protected void printContent(PrintWriter out, HttpServletRequest request) {
		try {
			HttpServletRequest session = request;
			String result = (String)session.getAttribute("addProgrammerMessage");
			if (result == null){
				util.printFromFile(out, "programmers/addProgrammer.html");
				session.setAttribute("addProgrammerMessage", null);
			}
			else {
				util.printReplacedText(out, "tasks/printMessage.html", "templateMessage", result);
				session.setAttribute("addProgrammerMessage", null);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void message(String string, HttpServletRequest session) {
		session.setAttribute("addProgrammerMessage", string);
	}

}
