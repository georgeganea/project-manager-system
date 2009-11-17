package usr.speedy.ds.tasks;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.speedy.TaskSessionRemote;

import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;
import usr.speedy.ds.MessageComposite;

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
			InitialContext ctx;
			
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					ctx = new InitialContext();
					TaskSessionRemote  bean = ( TaskSessionRemote) ctx.lookup("tasksSession"); 
					
					
					/// 	AICI se pune codul care adauga in baza de date !!!
					
					
					
					
					
				} catch (NamingException e1) {
					e1.printStackTrace();
				}
				MessageComposite messageComposite = new MessageComposite(parent, SWT.NONE, "added the task ");
				for (IListener listener : listeners) {
					listener.contentChanged(messageComposite);
				}
			}
		});
		btnOk.setBounds(167, 114, 94, 30);
		btnOk.setText("Ok");
		
		Label lblInsertTheName = new Label(this, SWT.NONE);
		lblInsertTheName.setBounds(10, 10, 328, 16);
		lblInsertTheName.setText("Add Task ");
		
		Label lblStatus = new Label(this, SWT.NONE);
		lblStatus.setBounds(12, 77, 60, 14);
		lblStatus.setText("Status open/closed :");
		
		
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(88, 74, 173, 19);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void addListener(IListener listener) {
		listeners.add(listener);
	}
}
