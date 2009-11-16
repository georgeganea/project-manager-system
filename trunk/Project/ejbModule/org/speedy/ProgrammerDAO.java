package org.speedy;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
		Query select = em.createNativeQuery("select * from programmers");
		List resultList = select.getResultList();
		for (Object object : resultList) {
			System.out.println(">>>>>"+object+" "+object.getClass());
		}
		return true;
	}
	public void doSmth() {
		
	}

}
