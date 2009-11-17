package org.speedy;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.RemoteBinding;

/**
 * Session Bean implementation class TaskDAO
 */
@Stateless
@Remote(TaskDAORemote.class)
@RemoteBinding(jndiBinding = "programmersDS")
public class TaskDAO implements TaskDAORemote {
	

	@PersistenceContext(unitName = "Project")
	private EntityManager em;
	/**
     * Default constructor. 
     */
    public TaskDAO() {
    }
	    

	@SuppressWarnings("unchecked")
	public boolean insert(Task task, int nbProgrammer) {
		try
		{
			List<Programmer> listprg =  em.createQuery("select p from " + Programmer.class.getName() + "p where p.status = 'available' " ).getResultList();
			
			if ( nbProgrammer > listprg.size()) return false;
			else
			{
			    for (Programmer prg : listprg)
			    	{
			    	prg.setStatus("busy");
			    	em.merge(prg);
			    	}
				
			    List<Integer> maxList = (List<Integer>) em.createQuery("select max(id) from " + Task.class.getName() + " p" ).getResultList();
			    
			    int max = maxList.get(0);
			    Assingment ass;
			    for (Programmer prg : listprg)
			    {
			    	ass =new Assingment();
			    	
			    	ass.setProgrammer(prg);
			    	ass.setTask(task);
			    	em.persist(ass);
			    }
			    
				em.persist(task);
				return true;
			}
			
		}
		catch(NoResultException e){
			return false;
		}
		catch(NonUniqueResultException e){
			return false;
		}
		
		
	}
	
	
	
	public int getTaskID(String taskName) {
		Task aTask = (Task) em.createQuery("select p from "+Task.class.getName()+" p where p.name = :theName").setParameter("theName", taskName).getSingleResult();
		System.out.println("FOUND the task ..... "+ aTask.getId());
		return aTask.getId();
	}
	
	public Task getTask(int id) {
		Task aTask = (Task) em.createQuery("select p from "+Task.class.getName()+" p where p.id = :theid").setParameter("theid", id).getSingleResult();
		return aTask;
	}

	public void modify(Task task) {
		
	    Task userx = em.find(Task.class, task.getId());
	    task.setNopeople(userx.getNopeople());
	    em.remove(userx);
	    em.persist(task);
	
	}

}
