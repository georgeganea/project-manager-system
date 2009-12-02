package usr.speedy.ds;

import javax.xml.ws.Endpoint;

public class RunService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Task manager Web Service started.");
		Endpoint.publish("http://localhost:8085/DS3", new AddProgrammer());
	}

}
