package org.speedy;
import javax.ejb.Remote;

@Remote
public interface TaskDAORemote {

	public boolean insert(Task task,int nb_programmer);
}
