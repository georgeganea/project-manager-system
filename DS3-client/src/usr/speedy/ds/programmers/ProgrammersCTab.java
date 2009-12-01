package usr.speedy.ds.programmers;

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
import org.eclipse.swt.widgets.Shell;

import usr.speedy.ds.EmptyComposite;
import usr.speedy.ds.IListener;
import usr.speedy.ds.IManageble;
import usr.speedy.ds.IUpdatable;

import com.swtdesigner.SWTResourceManager;

public class ProgrammersCTab implements IUpdatable{
	private List<Label> allLabels = new ArrayList<Label>();
	
	public void create(CTabFolder tabFolder){
		final Shell shell = tabFolder.getShell();
		CTabItem tbtmProgrammers = new CTabItem(tabFolder, SWT.NONE);
		tbtmProgrammers.setText("Programmers");
		
		final Composite mainCompositeProgrammers = new Composite(tabFolder, SWT.NONE);
		tbtmProgrammers.setControl(mainCompositeProgrammers);
		
		final Composite rightSideProgrammers = new EmptyComposite(mainCompositeProgrammers, SWT.NONE);
		rightSideProgrammers.setBounds(75, 10, 339, 213);
		
		final Label lblHire = new Label(mainCompositeProgrammers, SWT.NONE);
		allLabels.add(lblHire);
		lblHire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				disable();
				lblHire.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
				disposeRightSideComposite(mainCompositeProgrammers);
				final HireComposite hireComposite = new HireComposite(mainCompositeProgrammers, SWT.NONE);
				hireComposite.setBounds(75, 10, 339, 213);
				hireComposite.setVisible(true);
				shell.redraw();
				hireComposite.addListener(new IListener() {
					
					public void contentChanged(Composite c) {
						hireComposite.dispose();
						c.setBounds(75, 10, 339, 213);
						c.setVisible(true);
						shell.redraw();
					}
				});
			}
		});
		
		lblHire.setBounds(5, 47, 59, 16);
		lblHire.setText("Hire");
		
		final Label lblFire = new Label(mainCompositeProgrammers, SWT.NONE);
		lblFire.setBounds(5, 78, 59, 16);
		lblFire.setText("Fire");
		allLabels.add(lblFire);
		lblFire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				disable();
				lblFire.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
				disposeRightSideComposite(mainCompositeProgrammers);
				final FireComposite fireComposite = new FireComposite(mainCompositeProgrammers, SWT.NONE);
				fireComposite.setBounds(75, 10, 339, 213);
				fireComposite.setVisible(true);
				shell.redraw();
				fireComposite.addListener(new IListener() {
					
					public void contentChanged(Composite c) {
						fireComposite.dispose();
						c.setBounds(75, 10, 339, 213);
						c.setVisible(true);
						shell.redraw();
					}
				});
			}
		});
		Label label_1 = new Label(mainCompositeProgrammers, SWT.SEPARATOR);
		label_1.setBounds(67, 10, 2, 213);
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
		
	}
}
