package usr.speedy.overview;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;

import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;

public class SystemOverview extends Composite implements IManageble{

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
		
		Combo openTasksCombo = new Combo(this, SWT.NONE);
		openTasksCombo.setBounds(80, 17, 166, 22);
		openTasksCombo.setItems(getOpenTasks());
		
		Combo closedTasksCombo = new Combo(this, SWT.NONE);
		closedTasksCombo.setBounds(90, 50, 166, 22);
		
		Combo availableProgrammersCombo = new Combo(this, SWT.NONE);
		availableProgrammersCombo.setBounds(143, 81, 172, 22);
		
		Combo busyProgrammersCombo = new Combo(this, SWT.NONE);
		busyProgrammersCombo.setBounds(120, 112, 155, 22);

	}

	private String[] getOpenTasks() {
		return null;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void addListener(IListener listener) {
		
	}
}
