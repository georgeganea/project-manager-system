package usr.speedy.ds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TemplateServlet
 */
public class TemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected Util util = new Util();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TemplateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		util.printFromFile(out,"top.html");
		templateMethod(out,request);
		util.printFromFile(out,"bottom.html");
	}

	protected void templateMethod(PrintWriter out, HttpServletRequest request) {
		out.println( "really cool picture of green speedy gonzales");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
