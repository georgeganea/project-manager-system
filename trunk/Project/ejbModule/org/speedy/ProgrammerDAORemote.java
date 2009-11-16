package org.speedy;
import javax.ejb.Remote;

@Remote
public interface ProgrammerDAORemote {
	public boolean insert(Programmer programmer);
}
