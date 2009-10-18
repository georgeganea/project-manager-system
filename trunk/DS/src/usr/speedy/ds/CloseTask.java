package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CloseTask
 */
public class CloseTask extends Tasks {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CloseTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void printContent(PrintWriter out, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(true);
			String result = (String)session.getAttribute("closeTaskMessage");
			if (result == null){
				util.printFromFile(out, "tasks/closeTask.html");
				session.setAttribute("closeTaskMessage", null);
			}
			else {
				util.printReplacedText(out, "tasks/printMessage.html", "templateMessage", result);
				session.setAttribute("closeTaskMessage", null);
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
		if (closeTask(taskName, request))
			message("Task was closed successfully", request.getSession());
		doGet(request, response);
	}

	private boolean closeTask(String taskName, HttpServletRequest request){
		HttpSession session = request.getSession(true);
		Connection connection = (Connection) session.getAttribute("connection");
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet duplicateName = stmt.executeQuery("SELECT COUNT(*) AS exista FROM tasks WHERE name='"+taskName+"' and status='open'");
				duplicateName.next();
				int exists = duplicateName.getInt("exista");
				if (exists != 1){
					if (exists == 0)
						message("Task name does not exist or is closed", request.getSession());
					else
						message("The database is malformed: duplicate task names", request.getSession());
					return false;
				}
				else{
					stmt.execute("UPDATE tasks SET status='closed' WHERE name='"+taskName+"'");
					List<String> allAssignments = new ArrayList<String>();
					List<String> allProg = new ArrayList<String>();
					ResultSet records = stmt.executeQuery("SELECT * FROM assingments WHERE tskID = (SELECT id FROM tasks WHERE name='"+taskName+"')");
					while(records.next()){
						allAssignments.add(records.getString("assID"));
						allProg.add(records.getString("prgID"));
					}
					for (String prog : allProg) {
						stmt.execute("UPDATE programmers SET status='available' WHERE id="+prog);
					}
					for (String assign : allAssignments) {
						stmt.execute("DELETE FROM assingments WHERE assID = "+assign);
					}
				}
				connection.commit();
				return true;
			}
			catch (Exception e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
					message("Error inserting data", session);
				}
				e.printStackTrace();
			}
		}
		return false;
	}

	private void message(String string, HttpSession session) {
		session.setAttribute("closeTaskMessage", string);
	}
}
