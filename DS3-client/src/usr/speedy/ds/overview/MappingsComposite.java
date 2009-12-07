package usr.speedy.ds.overview;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;

import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;
import usr.speedy.ds.client.overview.Overview;
import usr.speedy.ds.client.overview.OverviewService;

public class MappingsComposite extends Composite implements IManageble{

	public class TreeContentProvider implements ITreeContentProvider {

		public Object[] getChildren(final Object arg0) {
			final List<String> elements = new ArrayList<String>();
			Display.getCurrent().syncExec(new Runnable() {
				
				@Override
				public void run() {
					OverviewService shs = new OverviewService();

					Overview sh = shs.getOverviewPort();

					((BindingProvider)sh).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8083/DS3/overview");
					
					elements.addAll(sh.getProgrammersForTask((String)arg0));
				}
			});
			return elements.toArray(new String[elements.size()]);
		}


		public Object getParent(Object arg0) {
			return null;
		}

		public boolean hasChildren(Object arg0) {
			return true;
		}

		public Object[] getElements(Object arg0) {
			final List<String> elements = new ArrayList<String>();
			Display.getCurrent().syncExec(new Runnable() {
				
				@Override
				public void run() {
					OverviewService shs = new OverviewService();

					Overview sh = shs.getOverviewPort();

					((BindingProvider)sh).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8083/DS3/overview");
					
					elements.addAll(sh.getOpenTasks());
				}
			});
			return elements.toArray(new String[elements.size()]);
		}

		public void dispose() {
			// Nothing to dispose
		}

		public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
			// Nothing to change
		}
	}

	public class TreeLabelProvider implements ILabelProvider {
		  public TreeLabelProvider() {
		    
		  }

		public Image getImage(Object arg0) {
			return null;
		}

		public String getText(Object arg0) {
			return (String)arg0;
		}

		public void addListener(ILabelProviderListener arg0) {
		}

		public void dispose() {
		}

		public boolean isLabelProperty(Object arg0, String arg1) {
			return false;
		}

		public void removeListener(ILabelProviderListener arg0) {
		}
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MappingsComposite(Composite parent, int style) {
		super(parent, style);

		TreeViewer treeViewer = new TreeViewer(this, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setBounds(10, 10, 319, 193);
		treeViewer.setContentProvider(new TreeContentProvider());
		treeViewer.setLabelProvider(new TreeLabelProvider());
		treeViewer.setInput("root"); // pass a non-null that will be ignored
		treeViewer.expandAll();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void addListener(IListener listener) {
		// TODO Auto-generated method stub
		
	}
}
