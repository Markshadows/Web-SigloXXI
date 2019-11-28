
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
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

    private final static QName _WSSII_QNAME = new QName("http://ws/", "WSSII");
    private final static QName _WSSIIResponse_QNAME = new QName("http://ws/", "WSSIIResponse");
    private final static QName _WStransferencia_QNAME = new QName("http://ws/", "WStransferencia");
    private final static QName _WStransferenciaResponse_QNAME = new QName("http://ws/", "WStransferenciaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WSSII }
     * 
     */
    public WSSII createWSSII() {
        return new WSSII();
    }

    /**
     * Create an instance of {@link WSSIIResponse }
     * 
     */
    public WSSIIResponse createWSSIIResponse() {
        return new WSSIIResponse();
    }

    /**
     * Create an instance of {@link WStransferencia }
     * 
     */
    public WStransferencia createWStransferencia() {
        return new WStransferencia();
    }

    /**
     * Create an instance of {@link WStransferenciaResponse }
     * 
     */
    public WStransferenciaResponse createWStransferenciaResponse() {
        return new WStransferenciaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WSSII }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "WSSII")
    public JAXBElement<WSSII> createWSSII(WSSII value) {
        return new JAXBElement<WSSII>(_WSSII_QNAME, WSSII.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WSSIIResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "WSSIIResponse")
    public JAXBElement<WSSIIResponse> createWSSIIResponse(WSSIIResponse value) {
        return new JAXBElement<WSSIIResponse>(_WSSIIResponse_QNAME, WSSIIResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WStransferencia }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "WStransferencia")
    public JAXBElement<WStransferencia> createWStransferencia(WStransferencia value) {
        return new JAXBElement<WStransferencia>(_WStransferencia_QNAME, WStransferencia.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WStransferenciaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "WStransferenciaResponse")
    public JAXBElement<WStransferenciaResponse> createWStransferenciaResponse(WStransferenciaResponse value) {
        return new JAXBElement<WStransferenciaResponse>(_WStransferenciaResponse_QNAME, WStransferenciaResponse.class, null, value);
    }

}
