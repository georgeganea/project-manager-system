package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

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
			String result = (String)session.getAttribute("addTaskMessage");
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
		message("Task was closed successfully", request.getSession());
	}
	
	private void message(String string, HttpSession session) {
		session.setAttribute("closeTaskMessage", string);
	}
}
