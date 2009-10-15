package usr.speedy.ds;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TemplateServlet
 */
public class TemplateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		printFromFile(out,"top.html",request.getContextPath());
		templateMethod(out,request.getContextPath());
		printFromFile(out,"bottom.html",request.getContextPath());
	}

	protected void templateMethod(PrintWriter out, String contextPath) {
		out.println( "really cool picture of green speedy gonzales");
	}

	protected void printFromFile(PrintWriter out,String fileName, String contextPath) throws FileNotFoundException,IOException {
		URL resource = this.getClass().getResource(fileName);
		try {
			FileReader reader = new FileReader(new File(resource.toURI()));
			BufferedReader input =  new BufferedReader(reader);
			String line;
			while (( line = input.readLine()) != null){
				out.println(line);
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
