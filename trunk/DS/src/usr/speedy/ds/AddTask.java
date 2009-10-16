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
			boolean result = addToDataBase(taskName, noOfProg, request);
			if (result)
				message("Task "+taskName+" succesfully added", request.getSession());
		}
		catch(NumberFormatException e){
			message("Invalid number format", request.getSession());
		}
		doGet(request, response);
	}


	private boolean addToDataBase(String taskName, int noOfProg, HttpServletRequest request) {
		List<String> allNames = new ArrayList<String>();
		HttpSession session = request.getSession(true);
		Connection connection = (Connection) session.getAttribute("connection");
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT COUNT(*) AS cnt FROM programmers WHERE status='available'");
				recordCnt.next();
				int count = recordCnt.getInt("cnt");
				if (count < noOfProg){
					message("The requested number of programmers is not available", session);
					return false;
				}
				else{
					ResultSet records = stmt.executeQuery("SELECT * FROM programmers WHERE status='available'");
					int cnt = 0;
					while(records.next()){
						String str = records.getString("id");
						allNames.add(str);
						cnt++;
						if (cnt == noOfProg)
							break;
					}//end while loop
					for (String name : allNames) {
						stmt.execute("UPDATE programmers SET status='busy' WHERE id="+name);
					}
					stmt.execute("INSERT INTO tasks(name, status, nopeople) VALUES ('"+taskName+"'"+",'open',"+noOfProg+")");
					ResultSet lastInsertedTask = stmt.executeQuery("SELECT * FROM tasks WHERE id = (SELECT MAX(id) FROM tasks)");
					lastInsertedTask.next();
					int lastInserted = lastInsertedTask.getInt("id");
					for (String string : allNames) {
						stmt.execute("INSERT INTO assingments(prgID, tskID) VALUES ("+string+","+lastInserted+")");
					}
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				message("Error inserting data", session);
			}
		}
		return false;
	}

	private void message(String string, HttpSession session) {
		session.setAttribute("addTaskMessage", string);
	}

}
