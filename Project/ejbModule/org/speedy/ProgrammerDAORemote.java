package org.speedy;
import javax.ejb.Remote;

@Remote
public interface ProgrammerDAORemote {

	public void doSmth();
	public boolean insert(Programmer programmer);
}
