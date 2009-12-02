
package usr.speedy.ds.client;

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
 * JAX-WS RI 2.1.3.1-hudson-749-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "AddProgrammerService", targetNamespace = "http://ds.speedy.usr/", wsdlLocation = "http://localhost:8085/DS3?wsdl")
public class AddProgrammerService
    extends Service
{

    private final static URL ADDPROGRAMMERSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(usr.speedy.ds.client.AddProgrammerService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = usr.speedy.ds.client.AddProgrammerService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8085/DS3?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8085/DS3?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        ADDPROGRAMMERSERVICE_WSDL_LOCATION = url;
    }

    public AddProgrammerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AddProgrammerService() {
        super(ADDPROGRAMMERSERVICE_WSDL_LOCATION, new QName("http://ds.speedy.usr/", "AddProgrammerService"));
    }

    /**
     * 
     * @return
     *     returns AddProgrammer
     */
    @WebEndpoint(name = "AddProgrammerPort")
    public AddProgrammer getAddProgrammerPort() {
        return super.getPort(new QName("http://ds.speedy.usr/", "AddProgrammerPort"), AddProgrammer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AddProgrammer
     */
    @WebEndpoint(name = "AddProgrammerPort")
    public AddProgrammer getAddProgrammerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ds.speedy.usr/", "AddProgrammerPort"), AddProgrammer.class, features);
    }

}
