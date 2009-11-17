package org.speedy;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

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

	public boolean addProgrammer(String name) {
		Programmer prog  = new Programmer();
		prog.setName(name);
		prog.setStatus("available");
		return programmer.insert(prog);
		
	}

	public boolean fireProgrammer(String name) {
		return programmer.delete(name);		
	}
}
