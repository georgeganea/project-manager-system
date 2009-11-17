package org.speedy;

import java.util.Iterator;
import java.util.List;
import java.util.Set;



import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.RemoteBinding;

/**
 * Session Bean implementation class ProgrammerDAO
 */
@Stateless
@Remote(ProgrammerDAORemote.class)
@RemoteBinding(jndiBinding = "programmerDAO")
public class ProgrammerDAO  implements ProgrammerDAORemote{

	@PersistenceContext(unitName = "Project")
	private EntityManager em;
	public ProgrammerDAO() {
	}
	public boolean insert(Programmer programmer) {
		em.persist(programmer);
		return true;
	}
	
	public boolean delete(String name){
		
		try{
			Programmer prog = (Programmer) em.createQuery("select p from "+Programmer.class.getName()+" p  where p.name = :theName").setParameter("theName", name).getSingleResult();
		
			if (prog.getStatus().equals("busy")){
				Set <Assingment>assigns = prog.getAssingments();
				
				Iterator<Assingment>iter = assigns.iterator();
				while (iter.hasNext()){
					Assingment a = (Assingment)iter.next();
					Task tmpTask = (Task) em.createQuery("select t from "+Task.class.getName()+" t where t.id= :theId").setParameter("theId",a.getTask().getId()).getSingleResult();
					if (tmpTask.getNopeople()==1){
						tmpTask.setStatus("closed");
						em.persist(tmpTask);
					}
					else if (tmpTask.getNopeople()>1){
						tmpTask.setNopeople(tmpTask.getNopeople()-1);
						em.persist(tmpTask);
					}
							
				}
				
				
			}
		
			em.remove(em.merge(prog));
			em.flush();
		    return true;
			  
			 
			
		}
		catch(NoResultException e){
			return false;
		}
		catch(NonUniqueResultException e){
			return false;
		}	
	}

}
