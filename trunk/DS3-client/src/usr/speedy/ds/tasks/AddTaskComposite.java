package usr.speedy.ds.tasks;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;
import usr.speedy.ds.MessageComposite;
import usr.speedy.ds.client.programmers.AddProgrammer;
import usr.speedy.ds.client.programmers.AddProgrammerService;
import usr.speedy.ds.client.task.AddTask;
import usr.speedy.ds.client.task.AddTaskService;

public class AddTaskComposite extends Composite implements IManageble{
	private Text text;
	private List<IListener> listeners = new ArrayList<IListener>();
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 * @param result 
	 */
	public AddTaskComposite(final Composite parent, int style) {
		super(parent, style);
		
		Label lblName = new Label(this, SWT.NONE);
		lblName.setBounds(34, 45, 48, 14);
		lblName.setText("Name:");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(88, 42, 173, 19);
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addMouseListener(new MouseAdapter() {
			private String addTaskStatus;
			@Override
			public void mouseDown(MouseEvent e) {
				final String taskName = text.getText();
				final String noOfProgrammers = text_1.getText();
				Display.getCurrent().syncExec(new Runnable() {
					
					public void run() {
						AddTaskService shs = new AddTaskService();

						AddTask sh = shs.getAddTaskPort();

						((BindingProvider)sh).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8083/DS3/addtask");

						addTaskStatus = sh.addTask(taskName,noOfProgrammers);
						
					}
				});
				MessageComposite messageComposite = new MessageComposite(parent, SWT.NONE, addTaskStatus);
				for (IListener listener : listeners) {
					listener.contentChanged(messageComposite);
				}
			}
		});
		btnOk.setBounds(167, 114, 94, 30);
		btnOk.setText("Ok");
		
		Label lblInsertTheName = new Label(this, SWT.NONE);
		lblInsertTheName.setBounds(10, 10, 328, 16);
		lblInsertTheName.setText("Create a new task with the given name");
		
		Label lblStatus = new Label(this, SWT.NONE);
		lblStatus.setBounds(12, 77, 90, 16);
		lblStatus.setText("Programmers:");
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(100, 74, 160, 19);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void addListener(IListener listener) {
		listeners.add(listener);
	}
}
