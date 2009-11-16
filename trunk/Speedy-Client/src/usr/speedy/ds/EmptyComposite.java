package usr.speedy.ds;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;

public class EmptyComposite extends Composite implements IManageble{
	private List<IListener> listeners = new ArrayList<IListener>();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public EmptyComposite(final Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void addListener(IListener listener) {
		listeners.add(listener);
	}

}
