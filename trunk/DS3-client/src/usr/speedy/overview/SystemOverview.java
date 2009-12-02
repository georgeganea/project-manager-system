package usr.speedy.overview;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;
import usr.speedy.ds.client.overview.Overview;
import usr.speedy.ds.client.overview.OverviewService;

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
		final List<String> elements = new ArrayList<String>();
		Display.getCurrent().syncExec(new Runnable() {
			
			@Override
			public void run() {
				OverviewService shs = new OverviewService();

				Overview sh = shs.getOverviewPort();

				((BindingProvider)sh).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8083/DS3/overview");
				
				elements.addAll(sh.getOpenTasks());
			}
		});
		return elements.toArray(new String[elements.size()]);
	}
	
	private String[] getClosedTasks() {
		final List<String> elements = new ArrayList<String>();
		Display.getCurrent().syncExec(new Runnable() {
			
			@Override
			public void run() {
				OverviewService shs = new OverviewService();

				Overview sh = shs.getOverviewPort();

				((BindingProvider)sh).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8083/DS3/overview");
				
				elements.addAll(sh.getClosedTaks());
			}
		});
		return elements.toArray(new String[elements.size()]);

	}
	
	private String[] getAvailableProgrammers() {
		final List<String> elements = new ArrayList<String>();
		Display.getCurrent().syncExec(new Runnable() {
			
			@Override
			public void run() {
				OverviewService shs = new OverviewService();

				Overview sh = shs.getOverviewPort();

				((BindingProvider)sh).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8083/DS3/overview");
				
				elements.addAll(sh.getAvailableProgrammers());
			}
		});
		return elements.toArray(new String[elements.size()]);
	}
	
	private String[] getBusyProgrammers() {
		final List<String> elements = new ArrayList<String>();
		Display.getCurrent().syncExec(new Runnable() {
			
			@Override
			public void run() {
				OverviewService shs = new OverviewService();

				Overview sh = shs.getOverviewPort();

				((BindingProvider)sh).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8083/DS3/overview");
				
				elements.addAll(sh.getBusyProgrammers());
			}
		});
		return elements.toArray(new String[elements.size()]);
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
