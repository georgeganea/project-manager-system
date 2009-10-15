package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class AddTask
 */
public class AddTask extends Tasks {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTask() {
		super();
	}

	protected void printContent(PrintWriter out, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(true);
			String result = (String)session.getAttribute("addTaskMessage");
			if (result == null){
				util.printFromFile(out, "tasks/addTask.html");
				session.setAttribute("addTaskMessage", null);
			}
			else {
				util.printReplacedText(out, "tasks/printMessage.html", "templateMessage", result);
				session.setAttribute("addTaskMessage", null);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String taskName = request.getParameter("taskname");
		if (taskName == null || taskName.trim().equals("")){
			message("Task name cannot be empty", request.getSession());
		}
		String noOfProgrammers = request.getParameter("noProg");
		if (noOfProgrammers == null || noOfProgrammers.trim().equals("")){
			message("Number of programmers cannot be empty", request.getSession());
		}
		try{
			int noOfProg = Integer.parseInt(noOfProgrammers);
			if (noOfProg <= 0)
				message("Invalid number of programmers", request.getSession());
			addToDataBase(taskName, noOfProg, request);
			message("Task "+taskName+" succesfully added", request.getSession());
		}
		catch(NumberFormatException e){
			message("Invalid number format", request.getSession());
		}
		doGet(request, response);
	}


	private void addToDataBase(String taskName, int noOfProg, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Connection connection = (Connection) session.getAttribute("connection");
		if (connection != null){
			//connection.createStatement("INSERT INTO programmers(name) VALUES ('"+taskName+"');")
		}
	}

	private void message(String string, HttpSession session) {
		session.setAttribute("addTaskMessage", string);
	}

}
