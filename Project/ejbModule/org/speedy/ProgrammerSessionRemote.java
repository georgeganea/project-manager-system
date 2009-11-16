package org.speedy;
import javax.ejb.Remote;

@Remote
public interface ProgrammerSessionRemote {

	public boolean addProgrammer(String name);
}
