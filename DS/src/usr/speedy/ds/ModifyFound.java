package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyFound
 */
public class ModifyFound extends Tasks {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyFound() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void printContent(PrintWriter out, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer modified = (Integer)session.getAttribute("modifyTaskid");
		try {
			util.printReplacedText(out, "tasks/printMessage.html", "templateMessage", "modified task with id"+modified);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		session.setAttribute("modifyTaskMessage", null);
		session.setAttribute("modifyTaskid", null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
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
			boolean result = addToDataBase((Integer)session.getAttribute("modifyTaskid"),taskName, noOfProg, request);
			if (result)
				message("Task "+taskName+" succesfully added", request.getSession());
		}
		catch(NumberFormatException e){
			message("Invalid number format", request.getSession());
		}
		doGet(request, response);
	}

	private boolean addToDataBase(int id,String taskName, int noOfProg,	HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Connection connection = (Connection) session.getAttribute("connection");
		Statement stmt;
		try {
			stmt = connection.createStatement();
			System.out.println("UPDATE tasks SET name='"+taskName+"', noPeople="+noOfProg+" WHERE id="+id+";");
			stmt.execute("UPDATE tasks SET name='"+taskName+"', noPeople="+noOfProg+" WHERE id="+id+";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void message(String string, HttpSession session) {
		session.setAttribute("modifyTaskMessage", string);
	}

}
