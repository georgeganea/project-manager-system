
package usr.speedy.ds.client.programmers;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the usr.speedy.ds.client.programmers package. 
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

    private final static QName _FireProgrammerResponse_QNAME = new QName("http://ds.speedy.usr/", "fireProgrammerResponse");
    private final static QName _FireProgrammer_QNAME = new QName("http://ds.speedy.usr/", "fireProgrammer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: usr.speedy.ds.client.programmers
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FireProgrammer_Type }
     * 
     */
    public FireProgrammer_Type createFireProgrammer_Type() {
        return new FireProgrammer_Type();
    }

    /**
     * Create an instance of {@link FireProgrammerResponse }
     * 
     */
    public FireProgrammerResponse createFireProgrammerResponse() {
        return new FireProgrammerResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FireProgrammerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ds.speedy.usr/", name = "fireProgrammerResponse")
    public JAXBElement<FireProgrammerResponse> createFireProgrammerResponse(FireProgrammerResponse value) {
        return new JAXBElement<FireProgrammerResponse>(_FireProgrammerResponse_QNAME, FireProgrammerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FireProgrammer_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ds.speedy.usr/", name = "fireProgrammer")
    public JAXBElement<FireProgrammer_Type> createFireProgrammer(FireProgrammer_Type value) {
        return new JAXBElement<FireProgrammer_Type>(_FireProgrammer_QNAME, FireProgrammer_Type.class, null, value);
    }

}
