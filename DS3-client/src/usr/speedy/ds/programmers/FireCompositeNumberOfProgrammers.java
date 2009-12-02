package usr.speedy.ds.programmers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;
import usr.speedy.ds.MessageComposite;

public class FireCompositeNumberOfProgrammers extends Composite implements IManageble{
	private Text text;
	private List<IListener> listeners = new ArrayList<IListener>();
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public FireCompositeNumberOfProgrammers(final Composite parent, int style) {
		super(parent, style);
		
		Label lblName = new Label(this, SWT.NONE);
		lblName.setBounds(34, 45, 48, 14);
		lblName.setText("Current:");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(88, 42, 173, 19);
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//TODO add logic here
				MessageComposite messageComposite = new MessageComposite(parent, SWT.NONE, "Fired or not");
				for (IListener listener : listeners) {
					listener.contentChanged(messageComposite);
				}
			}
		});
		btnOk.setBounds(167, 114, 94, 30);
		btnOk.setText("Ok");
		
		Label lblInsertTheName = new Label(this, SWT.NONE);
		lblInsertTheName.setBounds(10, 10, 328, 16);
		lblInsertTheName.setText("Insert the current number of programmers and the new one:");
		
		Label lblUpdateTo = new Label(this, SWT.NONE);
		lblUpdateTo.setBounds(22, 77, 60, 14);
		lblUpdateTo.setText("Update to:");
		
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
