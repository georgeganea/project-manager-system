package usr.speedy.overview;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.speedy.Programmer;
import org.speedy.Task;
import org.speedy.assignment.AssignmentSessionRemote;

import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;

public class MappingsComposite extends Composite implements IManageble{

	public class TreeContentProvider implements ITreeContentProvider {

		public Object[] getChildren(Object arg0) {
			return new Object[0];
		}


		public Object getParent(Object arg0) {
			return null;
		}

		public boolean hasChildren(Object arg0) {
			return false;
		}

		public Object[] getElements(Object arg0) {
			InitialContext ctx;
			try {
				ctx = new InitialContext();
				AssignmentSessionRemote  bean = ( AssignmentSessionRemote) ctx.lookup("assignmentSession"); 
				return bean.getOpenTasks().toArray(new Task[bean.getOpenTasks().size()]);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			return null;
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
			if (arg0 instanceof Programmer){
				return ((Programmer)arg0).getName();
			}
			if (arg0 instanceof Task){
				return ((Task)arg0).getName();
			}
			return "error";
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
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void addListener(IListener listener) {
		// TODO Auto-generated method stub
		
	}
}
