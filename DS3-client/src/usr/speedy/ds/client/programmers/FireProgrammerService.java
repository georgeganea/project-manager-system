
package usr.speedy.ds.client.programmers;

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
@WebServiceClient(name = "FireProgrammerService", targetNamespace = "http://ds.speedy.usr/", wsdlLocation = "http://localhost:8083/DS3/fire?wsdl")
public class FireProgrammerService
    extends Service
{

    private final static URL FIREPROGRAMMERSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(usr.speedy.ds.client.programmers.FireProgrammerService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = usr.speedy.ds.client.programmers.FireProgrammerService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8083/DS3/fire?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8083/DS3/fire?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        FIREPROGRAMMERSERVICE_WSDL_LOCATION = url;
    }

    public FireProgrammerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FireProgrammerService() {
        super(FIREPROGRAMMERSERVICE_WSDL_LOCATION, new QName("http://ds.speedy.usr/", "FireProgrammerService"));
    }

    /**
     * 
     * @return
     *     returns FireProgrammer
     */
    @WebEndpoint(name = "FireProgrammerPort")
    public FireProgrammer getFireProgrammerPort() {
        return super.getPort(new QName("http://ds.speedy.usr/", "FireProgrammerPort"), FireProgrammer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FireProgrammer
     */
    @WebEndpoint(name = "FireProgrammerPort")
    public FireProgrammer getFireProgrammerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ds.speedy.usr/", "FireProgrammerPort"), FireProgrammer.class, features);
    }

}
