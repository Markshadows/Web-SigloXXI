<%-- 
    Document   : ingresoproductos
    Created on : 14-10-2019, 17:53:40
    Author     : Betta
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <jsp:include page="/BodegaServlet" />




        <h1>Tabla registrar ingreso actualizando el stock del producto</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Producto</th>
                    <th>Cantidad a Ingresar</th>
                    <th>acciones</th>
                </tr>
            </thead>
            <tbody>

            <form action="BodegaServlet"  id="" method="POST">


                <td>
                    <h6> Seleccion de Producto </h6>
                    <select name="txtIdProducto">
                        <c:forEach var="item" items="${listaDeProductos}">
                            <option value="${item.id}">${item.nombre}</option>
                            <c:set var="idpro" value="${item.id}"/>
                        </c:forEach>
                    </select>             

                </td>

                <td>
                    <input type="number"  name="txtPesoModificar" placeholder="Cantidad a ingresar" >
                </td>

                <td>
                    <input type="submit" name="btnAccion" value="RegistrarIngreso2" >
                </td>

            </form>
        </tbody>
    </table>
</body>
</html>
