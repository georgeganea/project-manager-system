package usr.speedy.overview;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import usr.speedy.ds.EmptyComposite;
import usr.speedy.ds.IManageble;
import usr.speedy.ds.IUpdatable;

import com.swtdesigner.SWTResourceManager;

public class OverviewCTab implements IUpdatable{
	private List<Label> allLabels = new ArrayList<Label>();
	private SystemOverview overviewComposite = null; 

	public void create(CTabFolder tabFolder){
		final Shell shell = tabFolder.getShell();
		CTabItem tbtmOverview = new CTabItem(tabFolder, SWT.NONE);
		tbtmOverview.setText("Overview");

		final Composite mainCompositeOverview = new Composite(tabFolder, SWT.NONE);
		tbtmOverview.setControl(mainCompositeOverview);

		final Composite rightSideProgrammers = new EmptyComposite(mainCompositeOverview, SWT.NONE);
		rightSideProgrammers.setBounds(123, 10, 300, 213);

		final Label lblSystem = new Label(mainCompositeOverview, SWT.NONE);
		lblSystem.setBounds(5, 47, 105, 16);
		lblSystem.setText("System overview");
		allLabels.add(lblSystem);
		lblSystem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				disable();
				lblSystem.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
				disposeRightSideComposite(mainCompositeOverview);
				overviewComposite = new SystemOverview(mainCompositeOverview, SWT.NONE);
				overviewComposite.setBounds(123, 10, 300, 213);
				overviewComposite.setVisible(true);
				shell.redraw();
			}
		});

		Label lblOpenTasks = new Label(mainCompositeOverview, SWT.NONE);
		lblOpenTasks.setBounds(5, 78, 96, 16);
		lblOpenTasks.setText("Open Tasks");
		allLabels.add(lblOpenTasks);

		Label label_1 = new Label(mainCompositeOverview, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setBounds(115, 10, 2, 214);

	}

	private void disposeRightSideComposite(Composite parent){
		Control[] children = parent.getChildren();
		for (Control control : children) {
			if (control instanceof IManageble)
				control.dispose();
		}
	}

	private void disable(){
		for (Label aLabel : allLabels) {
			aLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		}
	}

	public void refresh() {
		if (overviewComposite != null){
			overviewComposite.refresh();
		}
	}
}
