
package usr.speedy.ds.client.task;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the usr.speedy.ds.client.task package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CloseTask_QNAME = new QName("http://task.ds.speedy.usr/", "closeTask");
    private final static QName _CloseTaskResponse_QNAME = new QName("http://task.ds.speedy.usr/", "closeTaskResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: usr.speedy.ds.client.task
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CloseTaskResponse }
     * 
     */
    public CloseTaskResponse createCloseTaskResponse() {
        return new CloseTaskResponse();
    }

    /**
     * Create an instance of {@link CloseTask_Type }
     * 
     */
    public CloseTask_Type createCloseTask_Type() {
        return new CloseTask_Type();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseTask_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.ds.speedy.usr/", name = "closeTask")
    public JAXBElement<CloseTask_Type> createCloseTask(CloseTask_Type value) {
        return new JAXBElement<CloseTask_Type>(_CloseTask_QNAME, CloseTask_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.ds.speedy.usr/", name = "closeTaskResponse")
    public JAXBElement<CloseTaskResponse> createCloseTaskResponse(CloseTaskResponse value) {
        return new JAXBElement<CloseTaskResponse>(_CloseTaskResponse_QNAME, CloseTaskResponse.class, null, value);
    }

}
