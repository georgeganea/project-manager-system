
package usr.speedy.ds.client.tasks;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the usr.speedy.ds.client.tasks package. 
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

    private final static QName _FoundTaskResponse_QNAME = new QName("http://ds.speedy.usr/", "foundTaskResponse");
    private final static QName _FoundTask_QNAME = new QName("http://ds.speedy.usr/", "foundTask");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: usr.speedy.ds.client.tasks
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FoundTask_Type }
     * 
     */
    public FoundTask_Type createFoundTask_Type() {
        return new FoundTask_Type();
    }

    /**
     * Create an instance of {@link FoundTaskResponse }
     * 
     */
    public FoundTaskResponse createFoundTaskResponse() {
        return new FoundTaskResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FoundTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ds.speedy.usr/", name = "foundTaskResponse")
    public JAXBElement<FoundTaskResponse> createFoundTaskResponse(FoundTaskResponse value) {
        return new JAXBElement<FoundTaskResponse>(_FoundTaskResponse_QNAME, FoundTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FoundTask_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ds.speedy.usr/", name = "foundTask")
    public JAXBElement<FoundTask_Type> createFoundTask(FoundTask_Type value) {
        return new JAXBElement<FoundTask_Type>(_FoundTask_QNAME, FoundTask_Type.class, null, value);
    }

}
