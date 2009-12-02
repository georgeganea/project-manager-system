package usr.speedy.ds.programmers;

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
import usr.speedy.ds.client.programmers.FireProgrammer;
import usr.speedy.ds.client.programmers.FireProgrammerService;

public class FireComposite extends Composite implements IManageble{
	private Text text;
	private List<IListener> listeners = new ArrayList<IListener>();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public FireComposite(final Composite parent, int style) {
		super(parent, style);
		
		Label lblName = new Label(this, SWT.NONE);
		lblName.setBounds(43, 45, 39, 14);
		lblName.setText("Name:");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(88, 42, 173, 19);
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addMouseListener(new MouseAdapter() {
			private String fireProgrammerStatus;
			@Override
			public void mouseDown(MouseEvent e) {
				//FIXME modify here
				final String programmerName = text.getText();
				Display.getCurrent().syncExec(new Runnable() {
					
					public void run() {
						FireProgrammerService shs = new FireProgrammerService();

						FireProgrammer sh = shs.getFireProgrammerPort();

						((BindingProvider)sh).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8083/DS3/fire");

						System.out.println( ((BindingProvider)sh).toString() );

						fireProgrammerStatus = sh.fireProgrammer(programmerName);
						
					}
				});
				
				MessageComposite messageComposite = new MessageComposite(parent, SWT.NONE, fireProgrammerStatus);
				for (IListener listener : listeners) {
					listener.contentChanged(messageComposite);
				}
			}
		});
		btnOk.setBounds(167, 86, 94, 30);
		btnOk.setText("Ok");
		
		Label lblInsertTheName = new Label(this, SWT.NONE);
		lblInsertTheName.setBounds(10, 10, 287, 16);
		lblInsertTheName.setText("Insert the name of the programmer being fired:");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void addListener(IListener listener) {
		listeners.add(listener);
	}
}
