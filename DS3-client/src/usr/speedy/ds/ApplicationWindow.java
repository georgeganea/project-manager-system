package usr.speedy.ds;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import usr.speedy.ds.programmers.ProgrammersCTab;
import usr.speedy.ds.tasks.TasksCTab;
import usr.speedy.overview.OverviewCTab;

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
		
		ProgrammersCTab programmersCTab = new ProgrammersCTab();
		programmersCTab.create(tabFolder);
		
		TasksCTab tasksCTab = new TasksCTab();
		tasksCTab.create(tabFolder);
		
		final OverviewCTab overviewCTab = new OverviewCTab();
		overviewCTab.create(tabFolder);
		
		tabFolder.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				if (arg0.getSource() instanceof CTabFolder){
					CTabFolder tabFolder = (CTabFolder)arg0.getSource();
					CTabItem selection = tabFolder.getSelection();
					Control control = selection.getControl();
					if (control instanceof Composite){
						Composite parentComposite = (Composite)control;
						for (Control aChild : parentComposite.getChildren()) {
							if (aChild instanceof Composite){
								Composite composite = (Composite)aChild;
								Control[] grandChildren = composite.getChildren();
								for (Control grandChild : grandChildren) {
									if (grandChild instanceof Combo){
										overviewCTab.refresh();
										Combo theCombo = (Combo)grandChild;
										theCombo.computeSize(SWT.DEFAULT,SWT.DEFAULT,true);
										theCombo.layout();
										theCombo.getParent().layout();
										theCombo.setRedraw(true);
										
									}
								}
							}
						}
					}
				}
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
		
	}
}
