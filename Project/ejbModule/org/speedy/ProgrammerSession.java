package org.speedy;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.RemoteBinding;

/**
 * Session Bean implementation class ProgrammerSession
 */
@Stateless
@Remote(ProgrammerSessionRemote.class)
@RemoteBinding(jndiBinding = "programmerSession")
public class ProgrammerSession implements ProgrammerSessionLocal , ProgrammerSessionRemote{

	@EJB
	private ProgrammerDAORemote programmer;

	public void doSmth() {
		Programmer prog  = new Programmer();
		prog.setName("booyakasha");
		prog.setStatus("busy");
		programmer.insert(prog);
		System.out.println("cucotz");
	}


}
