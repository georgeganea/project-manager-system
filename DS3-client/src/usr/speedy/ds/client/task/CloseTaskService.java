
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
@WebServiceClient(name = "CloseTaskService", targetNamespace = "http://task.ds.speedy.usr/", wsdlLocation = "http://localhost:8083/DS3/closetask?wsdl")
public class CloseTaskService
    extends Service
{

    private final static URL CLOSETASKSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(usr.speedy.ds.client.task.CloseTaskService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = usr.speedy.ds.client.task.CloseTaskService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8083/DS3/closetask?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8083/DS3/closetask?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        CLOSETASKSERVICE_WSDL_LOCATION = url;
    }

    public CloseTaskService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CloseTaskService() {
        super(CLOSETASKSERVICE_WSDL_LOCATION, new QName("http://task.ds.speedy.usr/", "CloseTaskService"));
    }

    /**
     * 
     * @return
     *     returns CloseTask
     */
    @WebEndpoint(name = "CloseTaskPort")
    public CloseTask getCloseTaskPort() {
        return super.getPort(new QName("http://task.ds.speedy.usr/", "CloseTaskPort"), CloseTask.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CloseTask
     */
    @WebEndpoint(name = "CloseTaskPort")
    public CloseTask getCloseTaskPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://task.ds.speedy.usr/", "CloseTaskPort"), CloseTask.class, features);
    }

}
