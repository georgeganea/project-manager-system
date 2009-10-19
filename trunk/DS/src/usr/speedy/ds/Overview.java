package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Overview
 */
public class Overview extends TemplateServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see TemplateServlet#TemplateServlet()
     */
    public Overview() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void templateMethod(PrintWriter out, HttpServletRequest request) {
		try {
			util.printFromFile(out, "overview/top.html", "Overview");
			printContent(out, request);
			util.printFromFile(out, "overview/bottom.html");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	protected void printContent(PrintWriter out, HttpServletRequest request) {
		try {
			util.printFromFile(out, "overview/content.html");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected String getActivePage() {
		return "Overview";
	}
}
