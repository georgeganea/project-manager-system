package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;


/**
 * Servlet implementation class Tasks
 */
public class Tasks extends TemplateServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Tasks() {
		super();
	}


	protected void templateMethod(PrintWriter out, String contextPath) {
		try {
			printFromFile(out, "tasks/top.html", contextPath);
			printContent(out, contextPath);
			printFromFile(out, "tasks/bottom.html", contextPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	protected void printContent(PrintWriter out, String contextPath) {
		try {
			printFromFile(out, "tasks/content.html", contextPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
