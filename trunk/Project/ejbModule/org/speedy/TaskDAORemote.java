package org.speedy;
import javax.ejb.Remote;

@Remote
public interface TaskDAORemote {

	public boolean insert(Task task,int nb_programmer);
	
	public int getTaskID(String taskName);

	public Task getTask(int id);

	public void modify(Task task);
	
	public void close(Task task);

}
