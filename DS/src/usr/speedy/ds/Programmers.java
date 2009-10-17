package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;


/**
 * Servlet implementation class Programmers
 */
public class Programmers extends TemplateServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see TemplateServlet#TemplateServlet()
     */
    public Programmers() {
        super();
    }
    
    protected void templateMethod(PrintWriter out, HttpServletRequest request) {
    	try {
			util.printFromFile(out, "programmers/top.html", "Programmers");
			printContent(out, request);
			util.printFromFile(out, "programmers/bottom.html");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    protected void printContent(PrintWriter out, HttpServletRequest request) {
		try {
			util.printFromFile(out, "programmers/content.html");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    protected String getActivePage() {
		return "Programmers";
	}
}
