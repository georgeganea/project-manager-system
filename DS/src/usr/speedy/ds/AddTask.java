package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
			String result = (String)request.getAttribute("addTaskMessage");
			if (result == null){
				util.printFromFile(out, "tasks/addTask.html");
				request.setAttribute("addTaskMessage", null);
			}
			else {
				util.printReplacedText(out, "tasks/printMessage.html", "templateMessage", result);
				request.setAttribute("addTaskMessage", null);
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
			message("Task name cannot be empty", request);
		}
		String noOfProgrammers = request.getParameter("noProg");
		if (noOfProgrammers == null || noOfProgrammers.trim().equals("")){
			message("Number of programmers cannot be empty", request);
		}
		try{
			int noOfProg = Integer.parseInt(noOfProgrammers);
			if (noOfProg <= 0)
				message("Invalid number of programmers", request);
			boolean result = addToDataBase(taskName, noOfProg, request);
			if (result)
				message("Task "+taskName+" succesfully added", request);
		}
		catch(NumberFormatException e){
			message("Invalid number format", request);
		}
		doGet(request, response);
	}


	private boolean addToDataBase(String taskName, int noOfProg, HttpServletRequest request) {
		List<String> allNames = new ArrayList<String>();
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT COUNT(*) AS cnt FROM programmers WHERE status='available'");
				recordCnt.next();
				int count = recordCnt.getInt("cnt");
				if (count < noOfProg){
					message("The requested number of programmers is not available", request);
					return false;
				}
				else{
					ResultSet duplicateName = stmt.executeQuery("SELECT COUNT(*) AS duplCnt FROM tasks WHERE name='"+taskName+"'");
					duplicateName.next();
					int duplicate = duplicateName.getInt("duplCnt");
					if (duplicate != 0){
						message("Task name already exists", request);
						return false;
					}
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
			}
			catch (Exception e) {
				message("Error inserting data", request);
				e.printStackTrace();
			}
		}
		return false;
	}

	private void message(String string, HttpServletRequest request) {
		request.setAttribute("addTaskMessage", string);
	}

}
