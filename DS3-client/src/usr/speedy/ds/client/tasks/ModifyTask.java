
package usr.speedy.ds.client.tasks;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ModifyTask", targetNamespace = "http://ds.speedy.usr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ModifyTask {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "modifyTask", targetNamespace = "http://ds.speedy.usr/", className = "usr.speedy.ds.client.tasks.ModifyTask_Type")
    @ResponseWrapper(localName = "modifyTaskResponse", targetNamespace = "http://ds.speedy.usr/", className = "usr.speedy.ds.client.tasks.ModifyTaskResponse")
    public String modifyTask(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
