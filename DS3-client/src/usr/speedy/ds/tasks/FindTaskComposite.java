package usr.speedy.ds.tasks;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;
import usr.speedy.ds.MessageComposite;
import usr.speedy.ds.client.tasks.ModifyTask;
import usr.speedy.ds.client.tasks.ModifyTaskService;

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
			private String modifyTaskStatus;
			@Override
			public void mouseDown(MouseEvent e) {
				//FIXME modify here
				final String taskName = text.getText();
				Display.getCurrent().syncExec(new Runnable() {

					public void run() {
						ModifyTaskService shs = new ModifyTaskService();

						ModifyTask sh = shs.getModifyTaskPort();

						((BindingProvider)sh).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8083/DS3/find");

						modifyTaskStatus = sh.modifyTask(taskName);

					}
				});
				if (isIntNumber(modifyTaskStatus) == false)
				{
					MessageComposite messageComposite = new MessageComposite(parent, SWT.NONE, modifyTaskStatus);

					for (IListener listener : listeners) {
						listener.contentChanged(messageComposite);
					}
				}else{
					usr.speedy.ds.tasks.ModifyTask test = new usr.speedy.ds.tasks.ModifyTask(parent,SWT.NONE,Integer.parseInt(modifyTaskStatus));
					for (IListener listener : listeners) {
						listener.contentChanged(test);
					}
					test.addListener(new IListener() {
						public void contentChanged(Composite c) {
							Control[] children = parent.getChildren();
							for (Control control : children) {
								control.dispose();
							}
						}
					});
				}

			}
		});
		btnOk.setBounds(167, 86, 94, 30);
		btnOk.setText("Ok");

		Label lblInsertTheName = new Label(this, SWT.NONE);
		lblInsertTheName.setBounds(10, 10, 287, 16);
		lblInsertTheName.setText("Insert the name of the task you want to modify:");


	}
	private boolean isIntNumber(String num){
		try{
			Integer.parseInt(num);
		} catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void addListener(IListener listener) {
		listeners.add(listener);
	}

}
