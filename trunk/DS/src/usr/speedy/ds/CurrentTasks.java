package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CurrentTasks
 */
public class CurrentTasks extends Overview {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see Overview#Overview()
     */
    public CurrentTasks() {
        super();
    }

    
    protected void printContent(PrintWriter out, HttpServletRequest request) {
    	try {
    		String message="\n";
    		int i = 0;
    		ArrayList <String> tasks = getListOfTasks(request);
    	while (i < tasks.size()){
    		message = message + tasks.get(i)+"<BR>";
    		i++;
    	}
    	if (tasks.size()>0)
    		util.printReplacedText(out, "overview/currenttasks.html", "templateMessage", message);
    	else
    		util.printReplacedText(out, "overview/printMessage.html", "templateMessage", "Right now, there are no tasks.");
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		
	}
    
    private ArrayList<String> getListOfTasks(HttpServletRequest request) {
    	ArrayList<String> result = new ArrayList<String>();
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT * FROM tasks;");
				while (recordCnt.next()) {
				      String name = recordCnt.getString(2);
				      String status = recordCnt.getString(3);
				      String programmers = recordCnt.getString(4);
				      result.add(name+"	"+status+"	"+programmers);
				}
				
			}
			 catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	//	Object taskName = request.getParameter("taskname");
		
	}

}
