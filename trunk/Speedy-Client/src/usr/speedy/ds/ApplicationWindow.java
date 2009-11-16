package usr.speedy.ds;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import usr.speedy.ds.programmers.ProgrammersCTab;

public class ApplicationWindow {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationWindow window = new ApplicationWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		CTabFolder tabFolder = new CTabFolder(shell, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setBounds(10, 10, 430, 258);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		new ProgrammersCTab().create(tabFolder);
		
		CTabItem tbtmTasks = new CTabItem(tabFolder, SWT.NONE);
		tbtmTasks.setText("Tasks");
		
		Composite mainCompositeTasks = new Composite(tabFolder, SWT.NONE);
		tbtmTasks.setControl(mainCompositeTasks);
		
		Label lblAdd = new Label(mainCompositeTasks, SWT.NONE);
		lblAdd.setBounds(5, 47, 59, 16);
		lblAdd.setText("Add");
		
		Label lblDelete = new Label(mainCompositeTasks, SWT.NONE);
		lblDelete.setBounds(5, 78, 59, 16);
		lblDelete.setText("Delete");
		
		Label lblModify = new Label(mainCompositeTasks, SWT.NONE);
		lblModify.setBounds(5, 109, 59, 16);
		lblModify.setText("Modify");
		
		Label label = new Label(mainCompositeTasks, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(67, 10, 2, 213);
		
		Composite rightSideTasks = new Composite(mainCompositeTasks, SWT.NONE);
		rightSideTasks.setBounds(75, 10, 339, 213);

	}
}
