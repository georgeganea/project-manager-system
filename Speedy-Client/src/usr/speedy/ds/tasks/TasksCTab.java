package usr.speedy.ds.tasks;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import usr.speedy.ds.IManageble;

import com.swtdesigner.SWTResourceManager;

public class TasksCTab {
	private List<Label> allLabels = new ArrayList<Label>();
	
	public void create(CTabFolder tabFolder){
		CTabItem tbtmTasks = new CTabItem(tabFolder, SWT.NONE);
		tbtmTasks.setText("Tasks");
		
		final Composite mainCompositeTasks = new Composite(tabFolder, SWT.NONE);
		tbtmTasks.setControl(mainCompositeTasks);
		
		final Label lblAdd = new Label(mainCompositeTasks, SWT.NONE);
		lblAdd.setBounds(5, 47, 59, 16);
		lblAdd.setText("Add");
		allLabels.add(lblAdd);
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				disable();
				lblAdd.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
				disposeRightSideComposite(mainCompositeTasks);
			}
		});
		
		
		Label lblDelete = new Label(mainCompositeTasks, SWT.NONE);
		lblDelete.setBounds(5, 78, 59, 16);
		lblDelete.setText("Delete");
		allLabels.add(lblDelete);
		
		Label lblModify = new Label(mainCompositeTasks, SWT.NONE);
		lblModify.setBounds(5, 109, 59, 16);
		lblModify.setText("Modify");
		allLabels.add(lblModify);
		
		Label label = new Label(mainCompositeTasks, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(67, 10, 2, 213);
	
		Composite rightSideTasks = new Composite(mainCompositeTasks, SWT.NONE);
		rightSideTasks.setBounds(75, 10, 339, 213);
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
}
