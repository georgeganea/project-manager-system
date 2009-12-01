package usr.speedy.ds.tasks;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;
import usr.speedy.ds.client.AddProgrammer;
import usr.speedy.ds.client.AddProgrammerService;

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
			
			@Override
			public void mouseDown(MouseEvent e) {
				
				//FIXME modify here
				/*InitialContext ctx;
				boolean result=false;
				String name = text.getText();
				int nb_prg = Integer.parseInt(text_1.getText());
				try {
					ctx = new InitialContext();
					TaskSessionRemote  bean = ( TaskSessionRemote) ctx.lookup("taskSession"); 
					result = bean.addTask(name,nb_prg);
				} catch (NamingException e1) {
					e1.printStackTrace();
				} 
				MessageComposite messageComposite = new MessageComposite(parent, SWT.NONE, result ? "Task "+name+" succesfully added":"Task "+name+" could not be added, sorry :( ");
				for (IListener listener : listeners) {
					listener.contentChanged(messageComposite);
				}*/
			}
		});
		btnOk.setBounds(167, 114, 94, 30);
		btnOk.setText("Ok");
		
		Label lblInsertTheName = new Label(this, SWT.NONE);
		lblInsertTheName.setBounds(10, 10, 328, 16);
		lblInsertTheName.setText("Add Task ");
		
		Label lblStatus = new Label(this, SWT.NONE);
		lblStatus.setBounds(12, 77, 60, 14);
		lblStatus.setText("Programmers:");
		
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
