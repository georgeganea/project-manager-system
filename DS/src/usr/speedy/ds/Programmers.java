package usr.speedy.ds;


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

    protected String getActivePage() {
		return "Programmers";
	}
}
