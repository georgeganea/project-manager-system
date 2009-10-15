package usr.speedy.ds;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


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

	protected void templateMethod(PrintWriter out, HttpServletRequest request) {
		try {
			util.printFromFile(out, "tasks/top.html");
			printContent(out, request);
			util.printFromFile(out, "tasks/bottom.html");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	protected void printContent(PrintWriter out, HttpServletRequest request) {
		try {
			util.printFromFile(out, "tasks/content.html");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
