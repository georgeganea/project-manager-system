package org.speedy.assignment;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.RemoteBinding;
import org.speedy.Assingment;
import org.speedy.Programmer;
import org.speedy.ProgrammerDAORemote;
import org.speedy.Task;

/**
 * Session Bean implementation class AssignmentDAO
 */
@Stateless
@Remote(AssignmentDAORemote.class)
@RemoteBinding(jndiBinding = "programmersDS")

public class AssignmentDAO implements AssignmentDAORemote {

	@PersistenceContext(unitName = "Project")
	private EntityManager em;
	public AssignmentDAO() {
	}
	
	public boolean insert(Programmer programmer) {
		em.persist(programmer);
		return true;
	}

	public List<Programmer> getAllProgrammers() {
		return (List<Programmer>) em.createQuery("select p from "+Programmer.class.getName()+" p").getResultList();	
	}

	public Task getTaskForProgrammer(String name){
		try{
			Programmer aProgrammer = (Programmer) em.createQuery("select p from "+Programmer.class.getName()+" p where p.name = :theName").setParameter("theName", name).getSingleResult();
			if (aProgrammer.getAssingments().size() == 1){
				Assingment anAssingment = aProgrammer.getAssingments().iterator().next();
				return anAssingment.getTask();
			}
			return null;
		}
		catch(NoResultException e){
			return null;
		}
		catch(NonUniqueResultException e){
			return null;
		}
	}


}
