package usr.speedy.overview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;

public class SystemOverview extends Composite implements IManageble{

	private Combo closedTasksCombo;
	private Combo availableProgrammersCombo;
	private Combo busyProgrammersCombo;
	private Combo openTasksCombo;


	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SystemOverview(Composite parent, int style) {
		super(parent, style);
		
		Label lblOpenTasks = new Label(this, SWT.NONE);
		lblOpenTasks.setBounds(10, 21, 77, 16);
		lblOpenTasks.setText("Open tasks:");
		
		Label lblClosedTasks = new Label(this, SWT.NONE);
		lblClosedTasks.setBounds(10, 54, 77, 16);
		lblClosedTasks.setText("Closed tasks:");
		
		Label lblAvailableProgrammers = new Label(this, SWT.NONE);
		lblAvailableProgrammers.setBounds(10, 85, 144, 16);
		lblAvailableProgrammers.setText("Available programmers:");
		
		Label lblBusyProgrammers = new Label(this, SWT.NONE);
		lblBusyProgrammers.setBounds(10, 116, 115, 16);
		lblBusyProgrammers.setText("Busy programmers:");
		
		openTasksCombo = new Combo(this, SWT.READ_ONLY);
		openTasksCombo.setBounds(85, 17, 120, 22);
		openTasksCombo.setItems(getOpenTasks());
		
		closedTasksCombo = new Combo(this, SWT.READ_ONLY);
		closedTasksCombo.setBounds(95, 50, 120, 22);
		closedTasksCombo.setItems(getClosedTasks());
		
		availableProgrammersCombo = new Combo(this, SWT.READ_ONLY);
		availableProgrammersCombo.setBounds(155, 81, 120, 22);
		availableProgrammersCombo.setItems(getAvailableProgrammers());
		
		busyProgrammersCombo = new Combo(this, SWT.READ_ONLY);
		busyProgrammersCombo.setBounds(130, 112, 120, 22);
		busyProgrammersCombo.setItems(getBusyProgrammers());
	}
	
	private String[] getOpenTasks() {
		//FIXME modify here
		/*InitialContext ctx;
		try {
			ctx = new InitialContext();
			AssignmentSessionRemote  bean = ( AssignmentSessionRemote) ctx.lookup("assignmentSession"); 
			List<Task> openTasks = bean.getOpenTasks();
			String[] openTasksNames = new String[openTasks.size()];
			int i = 0;
			for (Task aTask : openTasks) {
				openTasksNames[i++] = aTask.getName(); 
			}
			return openTasksNames;
		} catch (NamingException e) {
			e.printStackTrace();
		}*/
		return new String[0];

	}
	
	private String[] getClosedTasks() {
		//FIXME modify here
		/*InitialContext ctx;
		try {
			ctx = new InitialContext();
			AssignmentSessionRemote  bean = ( AssignmentSessionRemote) ctx.lookup("assignmentSession"); 
			List<Task> closedTasks = bean.getClosedTasks();
			String[] closedTasksNames = new String[closedTasks.size()];
			int i = 0;
			for (Task aTask : closedTasks) {
				closedTasksNames[i++] = aTask.getName(); 
			}
			return closedTasksNames;
		} catch (NamingException e) {
			e.printStackTrace();
		}*/
		return new String[0];

	}
	
	private String[] getAvailableProgrammers() {
		//FIXME modify here
		/*InitialContext ctx;
		try {
			ctx = new InitialContext();
			AssignmentSessionRemote  bean = ( AssignmentSessionRemote) ctx.lookup("assignmentSession"); 
			List<Programmer> availableProgrammers = bean.getAvailableProgrammers();
			String[] availableProgrammersNames = new String[availableProgrammers.size()];
			int i = 0;
			for (Programmer aProgrammer : availableProgrammers) {
				availableProgrammersNames[i++] = aProgrammer.getName(); 
			}
			return availableProgrammersNames;
		} catch (NamingException e) {
			e.printStackTrace();
		}*/
		return new String[0];

	}
	
	private String[] getBusyProgrammers() {
		//FIXME modify here
		/*InitialContext ctx;
		try {
			ctx = new InitialContext();
			AssignmentSessionRemote  bean = ( AssignmentSessionRemote) ctx.lookup("assignmentSession"); 
			List<Programmer> busyProgrammers = bean.getBusyProgrammers();
			String[] busyProgrammersNames = new String[busyProgrammers.size()];
			int i = 0;
			for (Programmer aProgrammer : busyProgrammers) {
				busyProgrammersNames[i++] = aProgrammer.getName(); 
			}
			return busyProgrammersNames;
		} catch (NamingException e) {
			e.printStackTrace();
		}*/
		return new String[0];

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void addListener(IListener listener) {
		
	}

	public void refresh() {
		openTasksCombo.setItems(getOpenTasks());
		
		closedTasksCombo.setItems(getClosedTasks());
		
		availableProgrammersCombo.setItems(getAvailableProgrammers());
		
		busyProgrammersCombo.setItems(getBusyProgrammers());
	}
}
