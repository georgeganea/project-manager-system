package beans;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.RemoteBinding;


/**
 * Session Bean implementation class MyBean
 */
@Stateless
@Remote(MyBeanRemote.class)
@RemoteBinding(jndiBinding = "myBean")
public class MyBean implements MyBeanRemote, MyBeanLocal {

    public MyBean() {
    }

	public void gigi() {
		System.out.println("ceva frumos");
		
	}

}
