package org.speedy;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.RemoteBinding;

/**
 * Session Bean implementation class TasksSession
 */
@Stateless
@Remote(TaskSessionRemote.class)
@RemoteBinding(jndiBinding = "taskSession")
public class TaskSession implements TaskSessionRemote, TaskSessionLocal {
	
	@EJB
	private TaskDAORemote taskDAO;

	public int findTaskID(String taskName) {
		
		return taskDAO.getTaskID(taskName);
		
	}

	public void modify(int id, String name, String status, int noPeople) {
		Task task = taskDAO.getTask(id);
		task.setStatus(status);
		task.setNopeople(noPeople);
		taskDAO.modify(task);
		System.out.println("modified in the database!!!!");
	}
}
