package org.speedy;
import javax.ejb.Remote;

@Remote
public interface TasksDAORemote {

	public int getTaskID(String taskName);

	public Task getTask(int id);

	public void persist(Task task);
}
