package org.speedy;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface TaskDAORemote {

	public boolean insert(Task task,int nb_programmer);

}
