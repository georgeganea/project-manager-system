package org.speedy.assignment;
import java.util.List;

import javax.ejb.Remote;

import org.speedy.Programmer;
import org.speedy.Task;

@Remote
public interface AssignmentDAORemote {
	
	public List<Task> getTasks(String status);

	public List<Programmer> getProgrammers(String status);
	
	public List<Programmer> getProgrammersForTask(String name);
}
