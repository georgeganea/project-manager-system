package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModifyTask
 */
public class ModifyTask extends Tasks {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Tasks#Tasks()
	 */
	public ModifyTask() {
		super();
	}


	protected void printContent(PrintWriter out, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(true);
			Integer modified = (Integer)session.getAttribute("modifyTaskid");
			String result = (String)session.getAttribute("modifyTaskMessage");
			if (result != null) {
				util.printReplacedText(out, "tasks/printMessage.html", "templateMessage", result);
				session.setAttribute("modifyTaskMessage", null);
				session.setAttribute("modifyTaskid", null);
			}
			else
				if (modified == null)
					util.printFromFile(out, "tasks/modifyTaskFind.html");
				else{
					if (modified < 1){
						util.printReplacedText(out, "tasks/printMessage.html", "templateMessage", "task not found");
						session.setAttribute("modifyTaskMessage", null);
						session.setAttribute("modifyTaskid", null);
					}
					else{
						util.printFromFile(out, "tasks/modifyFoundTask.html");
						session.setAttribute("modifyTaskMessage", null);
					}
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String taskName = request.getParameter("taskname");
		if (taskName == null || taskName.trim().equals("")){
			message("Task name cannot be empty", request.getSession());
		}
		int taskID = findTask(taskName, request);
		//if (taskID < 1) message("task not found", request.getSession());
		session.setAttribute("modifyTaskid", taskID);
		System.out.println("found task "+taskID);
		doGet(request, response);
	}

	private int findTask(String taskName, HttpServletRequest request) {
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
						message("Task "+taskName+" does not exist or is closed", request.getSession());
					else
						message("The database is malformed: duplicate task names", request.getSession());
					return -2;
				}
				else{
					ResultSet records = stmt.executeQuery("SELECT * FROM tasks WHERE name ='"+taskName+"'");// = (SELECT id FROM tasks WHERE name='"+taskName+"')");
					while(records.next()){
						return Integer.parseInt(records.getString("id"));
					}
				}
				return -3;
			}
			catch (SQLException e) {
				e.printStackTrace();
				message("Error inserting data", session);
			}
		}
		return -4;
	}





	private void message(String string, HttpSession session) {
		session.setAttribute("modifyTaskMessage", string);
	}
}

