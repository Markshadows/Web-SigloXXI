
package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Service1", targetNamespace = "http://ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Service1 {


    /**
     * 
     * @param pass
     * @param montoPago
     * @param run
     * @return
     *     returns int
     */
    @WebMethod(operationName = "WStransferencia")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "WStransferencia", targetNamespace = "http://ws/", className = "ws.WStransferencia")
    @ResponseWrapper(localName = "WStransferenciaResponse", targetNamespace = "http://ws/", className = "ws.WStransferenciaResponse")
    @Action(input = "http://ws/Service1/WStransferenciaRequest", output = "http://ws/Service1/WStransferenciaResponse")
    public int wStransferencia(
        @WebParam(name = "run", targetNamespace = "")
        String run,
        @WebParam(name = "pass", targetNamespace = "")
        String pass,
        @WebParam(name = "montoPago", targetNamespace = "")
        int montoPago);

    /**
     * 
     * @param id
     * @return
     *     returns int
     */
    @WebMethod(operationName = "WSSII")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "WSSII", targetNamespace = "http://ws/", className = "ws.WSSII")
    @ResponseWrapper(localName = "WSSIIResponse", targetNamespace = "http://ws/", className = "ws.WSSIIResponse")
    @Action(input = "http://ws/Service1/WSSIIRequest", output = "http://ws/Service1/WSSIIResponse")
    public int wssii(
        @WebParam(name = "id", targetNamespace = "")
        int id);

}