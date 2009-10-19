package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ModifyFound
 */
public class ModifyFound extends Tasks {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyFound() {
		super();
	}

	@Override
	protected void printContent(PrintWriter out, HttpServletRequest request) {
		Integer modified = (Integer)request.getAttribute("modifyTaskid");
		try {
			String result = (String)request.getAttribute("modifyTaskFoundMessage");
			if (result != null){
				util.printReplacedText(out, "tasks/printMessage.html", "templateMessage",result);
				request.setAttribute("modifyTaskFoundMessage", null);
			}
			else 
				util.printReplacedText(out, "tasks/printMessage.html", "templateMessage", "modified task with id "+modified);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("modifyTaskMessage", null);
		request.setAttribute("modifyTaskid", null);
		request.setAttribute("modifyTaskFoundMessage", null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
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
			boolean result = addToDataBase((Integer)session.getAttribute("modifyTaskid"),taskName, noOfProg, request);
			if (result)
				message("Task "+taskName+" succesfully added", request);
		}
		catch(NumberFormatException e){
			message("Invalid number format", request);
		}
		doGet(request, response);
	}

	private boolean addToDataBase(int id,String taskName, int noOfProg,	HttpServletRequest request) {
		List<String> allNames = new ArrayList<String>();
		Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet noPCnt = stmt.executeQuery("SELECT noPeople AS noP FROM tasks WHERE id="+id);
			noPCnt.next();
			int noP = noPCnt.getInt("noP");
			if (noP < noOfProg){
				//add some programmers
				ResultSet recordCnt = stmt.executeQuery("SELECT COUNT(*) AS cnt FROM programmers WHERE status='available'");
				recordCnt.next();
				int count = recordCnt.getInt("cnt");
				int toAdd = noOfProg - noP;
				if (count >= toAdd){
					stmt.execute("UPDATE tasks SET name='"+taskName+"', noPeople="+noOfProg+" WHERE id="+id+";");
					int cnt = 0;
					ResultSet records = stmt.executeQuery("SELECT * FROM programmers WHERE status='available'");
					while(records.next()){
						String str = records.getString("id");
						allNames.add(str);
						cnt++;
						if (cnt == toAdd)
							break;
					}//end while loop
					for (String name : allNames) {
						stmt.execute("UPDATE programmers SET status='busy' WHERE id="+name);
					}
					for (String string : allNames) {
						stmt.execute("INSERT INTO assingments(prgID, tskID) VALUES ("+string+","+id+")");
					}
				//	connection.commit();
				}
				else
					message("The requested number of programmers is not available", request);
			}
			else if (noP > noOfProg){
				stmt.execute("UPDATE tasks SET name='"+taskName+"', noPeople="+noOfProg+" WHERE id="+id+";");
				int i  = noP - noOfProg;
				ResultSet records = stmt.executeQuery("SELECT * FROM assingments WHERE tskID="+id+" limit "+i+";");
				while(records.next()){
					String str = records.getString("prgID");
					allNames.add(str);
				}
				for (String idName : allNames) {
					stmt.execute("UPDATE programmers SET status='available' WHERE id="+idName);
					stmt.execute("DELETE from assingments where prgID="+idName+";");
				}
			}
			else
				if (noP == noOfProg){
					stmt.execute("UPDATE tasks SET name='"+taskName+"', noPeople="+noOfProg+" WHERE id="+id+";");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	private void message(String string, HttpServletRequest request) {
		request.setAttribute("modifyTaskFoundMessage", string);
	}
}
