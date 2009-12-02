
package usr.speedy.ds.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the usr.speedy.ds.client package. 
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

    private final static QName _AddProgrammer_QNAME = new QName("http://ds.speedy.usr/", "addProgrammer");
    private final static QName _AddProgrammerResponse_QNAME = new QName("http://ds.speedy.usr/", "addProgrammerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: usr.speedy.ds.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddProgrammerResponse }
     * 
     */
    public AddProgrammerResponse createAddProgrammerResponse() {
        return new AddProgrammerResponse();
    }

    /**
     * Create an instance of {@link AddProgrammer_Type }
     * 
     */
    public AddProgrammer_Type createAddProgrammer_Type() {
        return new AddProgrammer_Type();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProgrammer_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ds.speedy.usr/", name = "addProgrammer")
    public JAXBElement<AddProgrammer_Type> createAddProgrammer(AddProgrammer_Type value) {
        return new JAXBElement<AddProgrammer_Type>(_AddProgrammer_QNAME, AddProgrammer_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProgrammerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ds.speedy.usr/", name = "addProgrammerResponse")
    public JAXBElement<AddProgrammerResponse> createAddProgrammerResponse(AddProgrammerResponse value) {
        return new JAXBElement<AddProgrammerResponse>(_AddProgrammerResponse_QNAME, AddProgrammerResponse.class, null, value);
    }

}
