//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.03 at 03:18:31 PM SAMT 
//


package rpis61.barinova.wdad.data.managers;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "registryOrBindedobject"
})
@XmlRootElement(name = "server")
public class Server {

    @XmlElements({
        @XmlElement(name = "registry", required = true, type = Registry.class),
        @XmlElement(name = "bindedobject", required = true, type = Bindedobject.class)
    })
    protected List<Object> registryOrBindedobject;

    /**
     * Gets the value of the registryOrBindedobject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registryOrBindedobject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistryOrBindedobject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Registry }
     * {@link Bindedobject }
     * 
     * 
     */
    public List<Object> getRegistryOrBindedobject() {
        if (registryOrBindedobject == null) {
            registryOrBindedobject = new ArrayList<Object>();
        }
        return this.registryOrBindedobject;
    }

}
