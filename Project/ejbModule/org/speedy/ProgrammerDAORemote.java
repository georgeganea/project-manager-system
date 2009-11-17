package org.speedy;
import javax.ejb.Remote;

@Remote
public interface ProgrammerDAORemote {
	public boolean insert(Programmer programmer);
	
	public boolean delete(String name);
}
