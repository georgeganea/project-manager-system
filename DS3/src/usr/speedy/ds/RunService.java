package usr.speedy.ds;

import javax.xml.ws.Endpoint;

import usr.speedy.ds.overview.Overview;
import usr.speedy.ds.task.AddTask;
import usr.speedy.ds.task.CloseTask;

public class RunService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Task manager Web Service started.");
		Endpoint.publish("http://localhost:8083/DS3/hire", new AddProgrammer());
		Endpoint.publish("http://localhost:8083/DS3/fire", new FireProgrammer());
		Endpoint.publish("http://localhost:8083/DS3/overview", new Overview());
		Endpoint.publish("http://localhost:8083/DS3/addtask", new AddTask());
		Endpoint.publish("http://localhost:8083/DS3/closetask", new CloseTask());
		Endpoint.publish("http://localhost:8083/DS3/find", new ModifyTask());
		Endpoint.publish("http://localhost:8083/DS3/modify", new FoundTask());
	}

}
