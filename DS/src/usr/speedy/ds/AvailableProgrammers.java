package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AvailProg
 */
public class AvailableProgrammers extends Overview {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see Overview#Overview()
     */
    public AvailableProgrammers() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void printContent(PrintWriter out, HttpServletRequest request) {
    	try {
    		String message="\n";
    		int i = 0;
    		ArrayList <String> programmers = getListOfAvailProgrammers(request);
    	while (i < programmers.size()){
    		message = message + programmers.get(i)+"<BR>";
    		i++;
    	}
    	if (programmers.size()>0)
    		util.printReplacedText(out, "overview/availprog.html", "templateMessage", message);
    	else
    		util.printReplacedText(out, "overview/printMessage.html", "templateMessage", "Right now, there are no available programmers.");
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
		
	}
	
   
    
    private ArrayList<String> getListOfAvailProgrammers(HttpServletRequest request) {
    	ArrayList<String> result = new ArrayList<String>();
		if (connection != null){
			Statement stmt;
			try {
				stmt = connection.createStatement();
				ResultSet recordCnt = stmt.executeQuery("SELECT * FROM programmers WHERE status='available';");
				while (recordCnt.next()) {
				      String name = recordCnt.getString(1);
				      result.add(name);
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
