package org.speedy.assignment;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.RemoteBinding;
import org.speedy.Task;

/**
 * Session Bean implementation class AssignmentSession
 */
@Stateless
@Remote(AssignmentSessionRemote.class)
@RemoteBinding(jndiBinding = "assignmentSession")
public class AssignmentSession implements AssignmentSessionRemote, AssignmentSessionLocal {

	@EJB
	private AssignmentDAORemote assignDAO;
	
    public AssignmentSession() {
    }
    
    public List<Task> getOpenTasks(){
    	return assignDAO.getOpenTasks();
    }

	public List<Task> getClosedTasks(){
		return assignDAO.getClosedTasks();
	}

}
