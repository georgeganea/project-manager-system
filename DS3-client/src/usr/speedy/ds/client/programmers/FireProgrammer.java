
package usr.speedy.ds.client.programmers;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "FireProgrammer", targetNamespace = "http://ds.speedy.usr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FireProgrammer {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "fireProgrammer", targetNamespace = "http://ds.speedy.usr/", className = "usr.speedy.ds.client.programmers.FireProgrammer_Type")
    @ResponseWrapper(localName = "fireProgrammerResponse", targetNamespace = "http://ds.speedy.usr/", className = "usr.speedy.ds.client.programmers.FireProgrammerResponse")
    public String fireProgrammer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
