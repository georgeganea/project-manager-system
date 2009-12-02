package usr.speedy.ds.tasks;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;

public class FindTaskComposite extends Composite implements IManageble{
	private Text text;
	private List<IListener> listeners = new ArrayList<IListener>();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public FindTaskComposite(final Composite parent, int style) {
		super(parent, style);
		
		Label lblName = new Label(this, SWT.NONE);
		lblName.setBounds(43, 45, 39, 14);
		lblName.setText("Name:");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(88, 42, 173, 19);
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//FIXME modify here
				/*
				InitialContext ctx;
				int result=0;
				String name = text.getText();
				try {
					ctx = new InitialContext();
					TaskSessionRemote  bean = ( TaskSessionRemote) ctx.lookup("taskSession"); 
					result = bean.findTaskID(name);
				} catch (NamingException e1) {
					e1.printStackTrace();
				} 
				
				ModifyTask messageComposite = new ModifyTask(parent, SWT.NONE,result);
				for (IListener listener : listeners) {
					listener.contentChanged(messageComposite);
				}
				*/
			}
		});
		btnOk.setBounds(167, 86, 94, 30);
		btnOk.setText("Ok");
		
		Label lblInsertTheName = new Label(this, SWT.NONE);
		lblInsertTheName.setBounds(10, 10, 287, 16);
		lblInsertTheName.setText("Insert the name of the task you want to modify:");


	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void addListener(IListener listener) {
		listeners.add(listener);
	}

}
