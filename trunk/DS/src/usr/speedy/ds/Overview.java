package usr.speedy.ds;


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

	
    protected String getActivePage() {
		return "Overview";
	}
}
