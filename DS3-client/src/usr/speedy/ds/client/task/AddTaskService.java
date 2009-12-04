
package usr.speedy.ds.client.task;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "AddTaskService", targetNamespace = "http://task.ds.speedy.usr/", wsdlLocation = "http://localhost:8083/DS3/addtask?wsdl")
public class AddTaskService
    extends Service
{

    private final static URL ADDTASKSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(usr.speedy.ds.client.task.AddTaskService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = usr.speedy.ds.client.task.AddTaskService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8083/DS3/addtask?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8083/DS3/addtask?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        ADDTASKSERVICE_WSDL_LOCATION = url;
    }

    public AddTaskService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AddTaskService() {
        super(ADDTASKSERVICE_WSDL_LOCATION, new QName("http://task.ds.speedy.usr/", "AddTaskService"));
    }

    /**
     * 
     * @return
     *     returns AddTask
     */
    @WebEndpoint(name = "AddTaskPort")
    public AddTask getAddTaskPort() {
        return super.getPort(new QName("http://task.ds.speedy.usr/", "AddTaskPort"), AddTask.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AddTask
     */
    @WebEndpoint(name = "AddTaskPort")
    public AddTask getAddTaskPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://task.ds.speedy.usr/", "AddTaskPort"), AddTask.class, features);
    }

}
