
package usr.speedy.ds.overview.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getProgrammersResponse", namespace = "http://overview.ds.speedy.usr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProgrammersResponse", namespace = "http://overview.ds.speedy.usr/")
public class GetProgrammersResponse {

    @XmlElement(name = "return", namespace = "")
    private List<String> _return;

    /**
     * 
     * @return
     *     returns List<String>
     */
    public List<String> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<String> _return) {
        this._return = _return;
    }

}
