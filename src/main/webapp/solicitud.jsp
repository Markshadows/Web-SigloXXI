<%-- 
    Document   : solicitud
    Created on : 05-10-2019, 14:31:19
    Author     : Betta
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitar</title>
    </head>

    <body>


         <jsp:include page="/BodegaServlet" />


        <c:if test="${!empty mensaje}" >
            <strong>${mensaje}</strong> 
        </c:if>

        <c:if test="${!empty errors}" >
            <strong>${errors}</strong> 
        </c:if>


        <h1>Solicitudes Enviadas</h1>    


        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>asunto</th>
                    <th>mensaje</th>
                    <th>Productos</th>
                    <th>estado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item2" items="${listaDeSolicitudes}">
                    <tr>
                        <td>${item2.idSolicitud}</td>
                        <td>${item2.asunto}</td>
                        <td>${item2.mensaje}</td>
                        <td>
                            <c:forEach var="x" items="${item2.productoSolicitudList}">
                                <p>
                                    ${x.productoId.nombre}
                                    Con un stock de:
                                    ${x.productoId.metricaId.peso}
                                    ${x.productoId.metricaId.medida}
                                </p>

                            </c:forEach>
                        </td>
                        <td>${item2.estadoSolicitud.descripcion}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>





        <form action="BodegaServlet" method="POST">
            <h1>Formulario Enviar Solicitud</h1> 
           

            <table border="1">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>codigo</th>
                        <th>nombre</th>
                        <th>Proveedor</th>
                        <th>Metrica</th>
                        <th>acciones</th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach var="item" items="${listaDeProductos}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.codigo}</td>
                            <td>${item.nombre}</td>

                            <td>${item.proveedorId.nombre}</td>
                            <td>${item.metricaId.peso} ${item.metricaId.medida}</td>
                            <td>
                                <input type="checkbox" name="idProducto" value="${item.id}" /> Seleccionar
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>



            <h6>Asunto</h6>
            <input type="text" id="txtAsunto" name="txtAsunto" placeholder="Asunto..." >

            <h6>Mensaje</h6>
            <input type="text" id="txtMensaje" name="txtMensaje" placeholder="Mensaje..." >



            <input type="submit" name="btnAccion" value="Enviar" >
        </form>













    </body>
</html>