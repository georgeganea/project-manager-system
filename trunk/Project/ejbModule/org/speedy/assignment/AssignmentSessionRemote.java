package org.speedy.assignment;
import java.util.List;

import javax.ejb.Remote;

import org.speedy.Programmer;
import org.speedy.Task;

@Remote
public interface AssignmentSessionRemote {
	
	public List<Task> getOpenTasks();

	public List<Task> getClosedTasks();
	
	public List<Programmer> getAvailableProgrammers();
	
	public List<Programmer> getBusyProgrammers();
	
	public List<Programmer> getProgrammersForTask(String name);
}
