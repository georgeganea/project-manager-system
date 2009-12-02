package usr.speedy.ds;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

public class MessageComposite extends Composite implements IManageble{
	private List<IListener> listeners = new ArrayList<IListener>();
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MessageComposite(Composite parent, int style, String text) {
		super(parent, style);
		
		Label label = new Label(this, SWT.NONE);
		label.setBounds(10, 10, 430, 66);
		label.setText(text);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void addListener(IListener listener) {
		listeners.add(listener);
	}

}
