package org.speedy;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProgrammerDAO
 */
@Stateless
@Remote(ProgrammerDAORemote.class)
public class ProgrammerDAO  implements ProgrammerDAORemote{
	
	@PersistenceContext(unitName = "Project")
	private EntityManager em;
	public ProgrammerDAO() {
	}
	public boolean insert(Programmer programmer) {
		em.persist(programmer);
		return !em.getTransaction().getRollbackOnly();
	}
	public void doSmth() {
		
	}

}
