//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.03 at 03:18:31 PM SAMT 
//


package rpis61.barinova.wdad.data.managers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rmi"
})
@XmlRootElement(name = "appconfig")
public class Appconfig {

    @XmlElement(required = true)
    protected Rmi rmi;

    /**
     * Gets the value of the rmi property.
     * 
     * @return
     *     possible object is
     *     {@link Rmi }
     *     
     */
    public Rmi getRmi() {
        return rmi;
    }

    /**
     * Sets the value of the rmi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rmi }
     *     
     */
    public void setRmi(Rmi value) {
        this.rmi = value;
    }

}
