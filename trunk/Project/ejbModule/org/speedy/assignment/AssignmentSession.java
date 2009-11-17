package org.speedy.assignment;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.RemoteBinding;
import org.speedy.Programmer;
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
    	return assignDAO.getTasks("open");
    }

	public List<Task> getClosedTasks(){
		return assignDAO.getTasks("closed");
	}

	public List<Programmer> getAvailableProgrammers() {
		return assignDAO.getProgrammers("available");
	}

	public List<Programmer> getBusyProgrammers() {
		return assignDAO.getProgrammers("busy");
	}
	
	public List<Programmer> getProgrammersForTask(String name){
		return assignDAO.getProgrammersForTask(name);
	}

}
