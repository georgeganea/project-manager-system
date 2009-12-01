package usr.speedy.ds.client;

import javax.xml.ws.BindingProvider;

public class AddProgrammerClient {

    public static void main(String args[]) {
		
        AddProgrammerService shs = new AddProgrammerService();
		
        AddProgrammer sh = shs.getAddProgrammerPort();
		
        ((BindingProvider)sh).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8085/DS3");

        System.out.println( ((BindingProvider)sh).toString() );

        System.out.println(sh.addProgrammer("George"));

    }
}
