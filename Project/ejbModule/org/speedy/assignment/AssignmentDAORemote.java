package org.speedy.assignment;
import java.util.List;

import javax.ejb.Remote;

import org.speedy.Task;

@Remote
public interface AssignmentDAORemote {
	
	public List<Task> getOpenTasks();

	public List<Task> getClosedTasks();
}