package org.speedy;

import java.util.Iterator;
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
@RemoteBinding(jndiBinding = "taskDAO")
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
			List<Programmer> listprg =  em.createQuery(" select p from "+Programmer.class.getName()+" p where p.status = :theStatus").setParameter("theStatus", "available").getResultList();
			
			if ( nbProgrammer > listprg.size()) {
				System.out.println("else");
				return false;}
			else
			{
				
			    List<Integer> maxList = (List<Integer>) em.createQuery("select max(id) from " + Task.class.getName() + " p" ).getResultList();
			    
			    int max = maxList.get(0);
			    Assingment ass;
			    Iterator<Programmer> it = listprg.iterator();
				   while(it.hasNext() && nbProgrammer !=0)
				    	{
					   	Programmer p = (Programmer)it.next();
				    	p.setStatus("busy");
				    	em.merge(p);
				    		
				    	ass =new Assingment();
				    	ass.setAssID(max+1);
				    	ass.setProgrammer(p);
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
		
		List resultList = em.createQuery("select p from "+Task.class.getName()+" p where p.name = :theName").setParameter("theName", taskName).getResultList();
		if (resultList.size() ==1){
		Task aTask = (Task) em.createQuery("select p from "+Task.class.getName()+" p where p.name = :theName").setParameter("theName", taskName).getSingleResult();
		
		System.out.println("FOUND the task ..... "+ aTask.getId());
		return aTask.getId();
		}
		else return -1;
	}
	
	public Task getTask(int id) {
//		Task aTask = (Task) em.createQuery("select p from "+Task.class.getName()+" p where p.id = :theid").setParameter("theid", id).getSingleResult();
//		return aTask;
		return em.find(Task.class,id);
	}

	public void modify(Task task) {
	    Task userx = em.find(Task.class, task.getId());
	    task.setNopeople(userx.getNopeople());
	    em.remove(userx);
	    em.persist(task);
	
	}
	
	public void close(Task task) {
		Task aTask = em.find(Task.class, task.getId());
		aTask.setStatus("colsed");
		em.persist(aTask);
		
		List<Assingment> listassig =  em.createQuery("select p from " + Assingment.class.getName() + " p where p.tskID = :theId").setParameter("theId",task.getId()).getResultList();
		
		int index = 0;

		while(index<listassig.size()){
			Programmer prog = (Programmer) em.createQuery("select p from "+Programmer.class.getName()+" p where p.id = :theId").setParameter("theId", listassig.get(index).getProgrammer().getId()).getSingleResult();
			Programmer aProg = em.find(Programmer.class,prog.getId());
			aProg.setStatus("available");
			em.persist(aProg);
			Assingment aAssig = em.find(Assingment.class, listassig.get(index).getAssID());
			em.remove(aAssig);
		}
		
	}

}
