package usr.speedy.ds;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class AuthenticationWindow {

	protected Shell shlLogin;
	private Text txtUsername;
	private Text txtPassword;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AuthenticationWindow window = new AuthenticationWindow();
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
		shlLogin.open();
		shlLogin.layout();
		while (!shlLogin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLogin = new Shell();
		shlLogin.setSize(450, 300);
		shlLogin.setText("Login");
		shlLogin.setLayout(null);
		
		Label lblUsername = new Label(shlLogin, SWT.NONE);
		lblUsername.setBounds(112, 79, 59, 14);
		lblUsername.setText("Username:");
		
		Label lblPassword = new Label(shlLogin, SWT.NONE);
		lblPassword.setBounds(112, 112, 59, 14);
		lblPassword.setText("Password:");
		
		txtUsername = new Text(shlLogin, SWT.BORDER);
		txtUsername.setBounds(177, 76, 135, 19);
		
		txtPassword = new Text(shlLogin, SWT.BORDER);
		txtPassword.setBounds(177, 109, 135, 19);
		
		Button btnOk = new Button(shlLogin, SWT.NONE);
		btnOk.setBounds(127, 159, 94, 30);
		btnOk.setText("Ok");
		
		Button btnCancel = new Button(shlLogin, SWT.NONE);
		btnCancel.setBounds(240, 159, 94, 30);
		btnCancel.setText("Cancel");

	}
}
