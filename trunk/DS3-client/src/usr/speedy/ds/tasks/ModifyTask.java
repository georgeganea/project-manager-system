package usr.speedy.ds.tasks;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
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
import usr.speedy.ds.client.programmers.FireProgrammer;
import usr.speedy.ds.client.programmers.FireProgrammerService;
import usr.speedy.ds.client.tasks.FoundTask;
import usr.speedy.ds.client.tasks.FoundTaskService;

public class ModifyTask extends Composite implements IManageble{
	private Text text;
	private List<IListener> listeners = new ArrayList<IListener>();
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 * @param result 
	 */
	public ModifyTask(final Composite parent, int style, final int result) {
		super(parent, style);
		if (result == -1){
			Label lblName = new Label(this, SWT.NONE);
			lblName.setBounds(5, 5, 60, 14);
			lblName.setText("not found !");
			return;
		}
		Label lblName = new Label(this, SWT.NONE);
		lblName.setBounds(34, 45, 48, 14);
		lblName.setText("Name:");
		text = new Text(this, SWT.BORDER);
		text.setBounds(88, 42, 173, 19);

		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addMouseListener(new MouseAdapter() {
			private String foundTaskStatus;
			@Override
			public void mouseDown(MouseEvent e) {
				//FIXME modify here
			
				final String taskName = text.getText();
				final String nbPrg = text_1.getText();
				Display.getCurrent().syncExec(new Runnable() {
					
					public void run() {
						FoundTaskService shs = new FoundTaskService();
						FoundTask sh = shs.getFoundTaskPort();
						((BindingProvider)sh).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8083/DS3/modify");
						System.out.println( ((BindingProvider)sh).toString() );
						foundTaskStatus = sh.foundTask(result,taskName,nbPrg);
					}
				});
				
				MessageComposite messageComposite = new MessageComposite(parent, SWT.NONE, foundTaskStatus);
				System.out.println(foundTaskStatus);
				for (IListener listener : listeners) {
					listener.contentChanged(messageComposite);
				}
			}
			
		});
		btnOk.setBounds(167, 114, 94, 30);
		btnOk.setText("Ok");

		Label lblInsertTheName = new Label(this, SWT.NONE);
		lblInsertTheName.setBounds(10, 10, 328, 16);
		lblInsertTheName.setText("Modify Task "+result);

		Label lblStatus = new Label(this, SWT.NONE);
		lblStatus.setBounds(0, 77, 68, 14);
		lblStatus.setText("New nb of programmers :");
       
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
