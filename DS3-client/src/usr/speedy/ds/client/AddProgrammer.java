
package usr.speedy.ds.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3.1-hudson-749-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebService(name = "AddProgrammer", targetNamespace = "http://ds.speedy.usr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface AddProgrammer {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addProgrammer", targetNamespace = "http://ds.speedy.usr/", className = "usr.speedy.ds.client.AddProgrammer_Type")
    @ResponseWrapper(localName = "addProgrammerResponse", targetNamespace = "http://ds.speedy.usr/", className = "usr.speedy.ds.client.AddProgrammerResponse")
    public String addProgrammer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
