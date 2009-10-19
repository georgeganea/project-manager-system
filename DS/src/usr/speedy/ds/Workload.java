package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Workload
 */
public class Workload extends Overview {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see TemplateServlet#TemplateServlet()
     */
    public Workload() {
        super();
    }

    protected void printContent(PrintWriter out, HttpServletRequest request) {
    	try {
    		int cnt1,cnt2;
    		String message;
    		
    		cnt1 = getNoOfProgrammers(request);
    		cnt2 = getNoOfAvailableProgrammers(request);
    		if (cnt1!=0)
    			message = new String("<p>The current workload is "+ (((float)(cnt1-cnt2)/cnt1))*100+"% </p>");
    		else 
    			message = new String("Workload information not available.");
    		util.printReplacedText(out, "overview/printMessage.html", "templateMessage", message);
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		
	}
  
	private int getNoOfProgrammers(HttpServletRequest request) {
		int count = 0;
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT COUNT(*) AS cnt FROM programmers");
				recordCnt.next();
				count = recordCnt.getInt("cnt");
				
			}
			 catch (SQLException e) {
				e.printStackTrace();
				message("Error getting data from the database", request);
			}
		}
		return count;
	}
	
	private int getNoOfAvailableProgrammers(HttpServletRequest request) {
		int count = 0;
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT COUNT(*) AS cnt FROM programmers WHERE status='available'");
				recordCnt.next();
				count = recordCnt.getInt("cnt");
				
			}
			 catch (SQLException e) {
				e.printStackTrace();
				message("Error getting data from the database", request);
			}
		}
		return count;
	}

	private void message(String string, HttpServletRequest request) {
		request.setAttribute("workloadMessage", string);
	}
}
