package org.speedy;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ProgrammerDAORemote {

	public List<Programmer> getAllProgrammers();
	public Task getTaskForProgrammer(String name);
	public boolean insert(Programmer programmer);
}
