package usr.speedy.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
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
	protected Connection connection;
	private HttpServletResponse response;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TemplateServlet() {
		super();
	}

	protected HttpServletResponse getResponse(){
		return response;
	}

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/programmers";
			connection = DriverManager.getConnection(url,"speedy", "speedy");
			connection.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.response = response;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		util.printFromFile(out,"top.html", getActivePage());
		templateMethod(out,request);
		util.printFromFile(out,"bottom.html");
	}

	protected String getActivePage() {
		return "None";
	}



	protected void templateMethod(PrintWriter out, HttpServletRequest request) {
		out.println("<div id=\"container\">");
		out.println("<div id=\"content\">");
		//out.println( "<p>really cool picture of green speedy gonzales</p>");
		out.println("<p><img src=\"Web/speedy_gonzales.jpg\" alt=\"text de alternate\" align=\"middle\"/></p>");
	    out.println("</div></div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
