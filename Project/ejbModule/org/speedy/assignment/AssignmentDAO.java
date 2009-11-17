package org.speedy.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.RemoteBinding;
import org.speedy.Assingment;
import org.speedy.Programmer;
import org.speedy.Task;

/**
 * Session Bean implementation class AssignmentDAO
 */
@Stateless
@Remote(AssignmentDAORemote.class)
@RemoteBinding(jndiBinding = "assignment")
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

	public List<Programmer> getProgrammersForTask(String name){
		try{
			Task aTask = (Task) em.createQuery("select t from "+Task.class.getName()+" t where t.name = :theName").setParameter("theName", name).getSingleResult();
			Set<Assingment> assingments = aTask.getAssingments();
			List<Programmer> allProgrammers = new ArrayList<Programmer>();			
			for (Assingment assingment : assingments) {
				allProgrammers.add(assingment.getProgrammer());
			}
			return allProgrammers;
		}
		catch(NoResultException e){
			return null;
		}
		catch(NonUniqueResultException e){
			return null;
		}
	}
	
	public List<Task> getTasks(String status){
		return (List<Task>) em.createQuery("select t from "+Task.class.getName()+" t where status = '"+status+"'").getResultList();
	}

	public List<Programmer> getProgrammers(String status) {
		return (List<Programmer>) em.createQuery("select p from "+Programmer.class.getName()+" p where status = '"+status+"'").getResultList();
	}

}
