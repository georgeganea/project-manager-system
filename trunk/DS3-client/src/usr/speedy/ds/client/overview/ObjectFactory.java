
package usr.speedy.ds.client.overview;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the usr.speedy.ds.client.overview package. 
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

    private final static QName _GetClosedTaks_QNAME = new QName("http://overview.ds.speedy.usr/", "getClosedTaks");
    private final static QName _GetTasks_QNAME = new QName("http://overview.ds.speedy.usr/", "getTasks");
    private final static QName _GetBusyProgrammers_QNAME = new QName("http://overview.ds.speedy.usr/", "getBusyProgrammers");
    private final static QName _GetProgrammersForTask_QNAME = new QName("http://overview.ds.speedy.usr/", "getProgrammersForTask");
    private final static QName _GetProgrammersForTaskResponse_QNAME = new QName("http://overview.ds.speedy.usr/", "getProgrammersForTaskResponse");
    private final static QName _GetAvailableProgrammersResponse_QNAME = new QName("http://overview.ds.speedy.usr/", "getAvailableProgrammersResponse");
    private final static QName _GetBusyProgrammersResponse_QNAME = new QName("http://overview.ds.speedy.usr/", "getBusyProgrammersResponse");
    private final static QName _GetClosedTaksResponse_QNAME = new QName("http://overview.ds.speedy.usr/", "getClosedTaksResponse");
    private final static QName _GetAvailableProgrammers_QNAME = new QName("http://overview.ds.speedy.usr/", "getAvailableProgrammers");
    private final static QName _GetOpenTasksResponse_QNAME = new QName("http://overview.ds.speedy.usr/", "getOpenTasksResponse");
    private final static QName _GetTasksResponse_QNAME = new QName("http://overview.ds.speedy.usr/", "getTasksResponse");
    private final static QName _GetOpenTasks_QNAME = new QName("http://overview.ds.speedy.usr/", "getOpenTasks");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: usr.speedy.ds.client.overview
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProgrammersForTask }
     * 
     */
    public GetProgrammersForTask createGetProgrammersForTask() {
        return new GetProgrammersForTask();
    }

    /**
     * Create an instance of {@link GetBusyProgrammersResponse }
     * 
     */
    public GetBusyProgrammersResponse createGetBusyProgrammersResponse() {
        return new GetBusyProgrammersResponse();
    }

    /**
     * Create an instance of {@link GetOpenTasksResponse }
     * 
     */
    public GetOpenTasksResponse createGetOpenTasksResponse() {
        return new GetOpenTasksResponse();
    }

    /**
     * Create an instance of {@link GetTasksResponse }
     * 
     */
    public GetTasksResponse createGetTasksResponse() {
        return new GetTasksResponse();
    }

    /**
     * Create an instance of {@link GetAvailableProgrammersResponse }
     * 
     */
    public GetAvailableProgrammersResponse createGetAvailableProgrammersResponse() {
        return new GetAvailableProgrammersResponse();
    }

    /**
     * Create an instance of {@link GetAvailableProgrammers }
     * 
     */
    public GetAvailableProgrammers createGetAvailableProgrammers() {
        return new GetAvailableProgrammers();
    }

    /**
     * Create an instance of {@link GetClosedTaks }
     * 
     */
    public GetClosedTaks createGetClosedTaks() {
        return new GetClosedTaks();
    }

    /**
     * Create an instance of {@link GetTasks }
     * 
     */
    public GetTasks createGetTasks() {
        return new GetTasks();
    }

    /**
     * Create an instance of {@link GetProgrammersForTaskResponse }
     * 
     */
    public GetProgrammersForTaskResponse createGetProgrammersForTaskResponse() {
        return new GetProgrammersForTaskResponse();
    }

    /**
     * Create an instance of {@link GetOpenTasks }
     * 
     */
    public GetOpenTasks createGetOpenTasks() {
        return new GetOpenTasks();
    }

    /**
     * Create an instance of {@link GetClosedTaksResponse }
     * 
     */
    public GetClosedTaksResponse createGetClosedTaksResponse() {
        return new GetClosedTaksResponse();
    }

    /**
     * Create an instance of {@link GetBusyProgrammers }
     * 
     */
    public GetBusyProgrammers createGetBusyProgrammers() {
        return new GetBusyProgrammers();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClosedTaks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getClosedTaks")
    public JAXBElement<GetClosedTaks> createGetClosedTaks(GetClosedTaks value) {
        return new JAXBElement<GetClosedTaks>(_GetClosedTaks_QNAME, GetClosedTaks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTasks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getTasks")
    public JAXBElement<GetTasks> createGetTasks(GetTasks value) {
        return new JAXBElement<GetTasks>(_GetTasks_QNAME, GetTasks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBusyProgrammers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getBusyProgrammers")
    public JAXBElement<GetBusyProgrammers> createGetBusyProgrammers(GetBusyProgrammers value) {
        return new JAXBElement<GetBusyProgrammers>(_GetBusyProgrammers_QNAME, GetBusyProgrammers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProgrammersForTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getProgrammersForTask")
    public JAXBElement<GetProgrammersForTask> createGetProgrammersForTask(GetProgrammersForTask value) {
        return new JAXBElement<GetProgrammersForTask>(_GetProgrammersForTask_QNAME, GetProgrammersForTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProgrammersForTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getProgrammersForTaskResponse")
    public JAXBElement<GetProgrammersForTaskResponse> createGetProgrammersForTaskResponse(GetProgrammersForTaskResponse value) {
        return new JAXBElement<GetProgrammersForTaskResponse>(_GetProgrammersForTaskResponse_QNAME, GetProgrammersForTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableProgrammersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getAvailableProgrammersResponse")
    public JAXBElement<GetAvailableProgrammersResponse> createGetAvailableProgrammersResponse(GetAvailableProgrammersResponse value) {
        return new JAXBElement<GetAvailableProgrammersResponse>(_GetAvailableProgrammersResponse_QNAME, GetAvailableProgrammersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBusyProgrammersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getBusyProgrammersResponse")
    public JAXBElement<GetBusyProgrammersResponse> createGetBusyProgrammersResponse(GetBusyProgrammersResponse value) {
        return new JAXBElement<GetBusyProgrammersResponse>(_GetBusyProgrammersResponse_QNAME, GetBusyProgrammersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClosedTaksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getClosedTaksResponse")
    public JAXBElement<GetClosedTaksResponse> createGetClosedTaksResponse(GetClosedTaksResponse value) {
        return new JAXBElement<GetClosedTaksResponse>(_GetClosedTaksResponse_QNAME, GetClosedTaksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableProgrammers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getAvailableProgrammers")
    public JAXBElement<GetAvailableProgrammers> createGetAvailableProgrammers(GetAvailableProgrammers value) {
        return new JAXBElement<GetAvailableProgrammers>(_GetAvailableProgrammers_QNAME, GetAvailableProgrammers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOpenTasksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getOpenTasksResponse")
    public JAXBElement<GetOpenTasksResponse> createGetOpenTasksResponse(GetOpenTasksResponse value) {
        return new JAXBElement<GetOpenTasksResponse>(_GetOpenTasksResponse_QNAME, GetOpenTasksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTasksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getTasksResponse")
    public JAXBElement<GetTasksResponse> createGetTasksResponse(GetTasksResponse value) {
        return new JAXBElement<GetTasksResponse>(_GetTasksResponse_QNAME, GetTasksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOpenTasks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://overview.ds.speedy.usr/", name = "getOpenTasks")
    public JAXBElement<GetOpenTasks> createGetOpenTasks(GetOpenTasks value) {
        return new JAXBElement<GetOpenTasks>(_GetOpenTasks_QNAME, GetOpenTasks.class, null, value);
    }

}
