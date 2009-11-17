package org.speedy;
import javax.ejb.Remote;

@Remote
public interface TaskSessionRemote {

	public int findTaskID(String taskName);
	
	public void modify(int id, String name, String status);
	
	public void close(String name);
	
	public boolean addTask(String taskName,int noPeople);
}
