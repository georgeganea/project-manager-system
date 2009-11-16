package org.speedy;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class TasksDAO
 */
@Stateless
public class TasksDAO implements TasksDAORemote {

	@PersistenceContext(unitName = "Project")
	private EntityManager em;
	public int getTaskID(String taskName) {
		Task aTask = (Task) em.createQuery("select p from "+Task.class.getName()+" p where p.name = :theName").setParameter("theName", taskName).getSingleResult();
		System.out.println("FOUND the task ..... "+ aTask.getId());
		return aTask.getId();
	}
	
	public Task getTask(int id) {
		Task aTask = (Task) em.createQuery("select p from "+Task.class.getName()+" p where p.id = :theid").setParameter("theid", id).getSingleResult();
		return aTask;
	}

	public void persist(Task task) {
		em.persist(task);
		em.flush();
	}

}
