<%-- 
    Document   : bodega
    Created on : 03-10-2019, 20:42:49
    Author     : Betta
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comprar</title>
    </head>

    <body>



        <jsp:include page="/BodegaServlet" />


        <h1>Existencias actuales en bodega</h1>
        <h2>Tabla de Listar Productos</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>codigo</th>
                    <th>nombre</th>

                    <th>Proveedor</th>
                    <th>Metrica</th>

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

                    </tr>

                </c:forEach>

            </tbody>
        </table>



        <c:if test="${!empty mensaje}" >
            <strong>${mensaje}</strong> 
        </c:if>

        <c:if test="${!empty errors}" >
            <strong>${errors}</strong> 
        </c:if>



        <br>
        <br>

        <br>

        <br>














        <h1>Ingresos</h1>
        <h2>Tabla de listaDeIngresos</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>fecha de ingreso</th>
                    <th>Recivido por:</th>
                    <th>Proveedor</th>
                    <th>Producto</th>
                    <th>Metrica</th>

                </tr>

            </thead>
            <tbody>
                <c:forEach var="item" items="${listaDeIngresos}">
                    <tr>
                        <td>

                            <p>  

                                El
                                <fmt:formatDate type="date" dateStyle="long" value="${item.ingreso}" />
                                A las
                                <fmt:formatDate type="time" timeStyle="short" value="${item.ingreso}" />
                            </p> 


                        </td>


                        <td>
                            ${item.usuarioId.nombre}
                            ${item.usuarioId.apellidos}
                        </td>

                        <td>
                            ${item.productoId.proveedorId.nombre}
                        </td>

                        <td>
                            ${item.productoId.codigo} //
                            ${item.productoId.nombre} //
                        </td>

                        <td>
                            ${item.productoId.metricaId.peso} //
                            ${item.productoId.metricaId.medida} //
                        </td>


                    </tr>

                </c:forEach>

            </tbody>
        </table>



















        <br>

        <br>





        <form action="BodegaServlet" method="POST">

            <h1>Recepcion de Productos</h1>
            <h1>Formulario Agregar Producto</h1>

            <h6>Peso</h6>
            <input type="number" id="peso" name="txtPeso" placeholder="Peso" >

            <h6>Medida</h6>
            <select name="txtMedida">
                <option selected="true"> Seleccione...</option>
                <option value="Kilos">Kilogramos</option>
                <option value="Litros">Litros</option>
                <option value="Sobres">Sobres</option>
                <option value="Cajas">Cajas</option>
                <option value="Botellas">Botellas</option>
            </select>


            <!--
            <input type="text" id="medida" name="txtMedida" placeholder="Medida" >
            -->


            <h6>Codigo</h6>
            <input type="text" id="codigo" name="txtCodigo" placeholder="Codigo" >

            <h6>Nombre</h6>
            <input type="text" id="nombre" name="txtNombre" placeholder="Nombre" >


            <h6> idProveedor </h6>
            <select name="txtIdProveedor">
                <option value="0"> Seleccione...</option>
                <c:forEach var="item" items="${listaDeProveedor}">
                    <option value="${item.id}">${item.nombre}</option>
                </c:forEach>
            </select>


            <h6> idUsuario </h6>
            <select name="txtIdUsuario">
                <option value="0"> Seleccione...</option>
                <c:forEach var="item" items="${listaDeUsuario}">
                    <option value="${item.id}">${item.nombre}</option>
                </c:forEach>
            </select>


            <input type="submit" name="btnAccion" value="RegistrarIngreso" >



        </form>













        <h1>Tabla para Modificar</h1>
        <table border="1">
            <thead>
                <tr>

                    <th>codigo</th>
                    <th>nombre</th>

                    <th>Proveedor</th>
                    <th>Metrica</th>
                    <th>acciones</th>
                </tr>

            </thead>
            <tbody>
                <c:forEach var="item" items="${listaDeProductos}">

                <form action="BodegaServlet"  id="" method="POST"> 

                    <tr>

                    <input type="hidden" id="txtIdProductoModificar" name="txtIdProductoModificar" value="${item.id}" >   

                    <td>
                        <input type="text" id="txtCodigoModificar${item.id}" name="txtCodigoModificar${item.id}" value="${item.codigo}" > 
                    </td>
                    <td>
                        <input type="text" id="txtNombreModificar${item.id}" name="txtNombreModificar${item.id}" value="${item.nombre}" > 
                    </td>


                    <td>
                        <select name="txtProveedorModificar${item.id}">
                            <option value="${item.proveedorId.id}">${item.proveedorId.nombre} </option>
                            <c:forEach var="lista" items="${listaDeProveedor}">
                                <option value="${lista.id}">${lista.nombre}</option>
                            </c:forEach>
                        </select>
                    </td>

                    <td>
                        <input type="hidden" id="txtPesoModificar" name="txtIdModificar${item.id}" value="${item.metricaId.id}" >

                        <input type="number" id="txtPesoModificar" name="txtPesoModificar${item.id}" value="${item.metricaId.peso}" >

                       <!-- 
                        <input type="text" id="txtMedidaModificar" name="txtMedidaModificar${item.id}" value="${item.metricaId.medida}" >
                       -->

                       
                        <select name="txtMedidaModificar${item.id}">
                            <option selected="true" value="${item.metricaId.medida}">${item.metricaId.medida}</option>
                            <option value="Kilos">Kilogramos</option>
                            <option value="Litros">Litros</option>
                            <option value="Sobres">Sobres</option>
                            <option value="Cajas">Cajas</option>
                            <option value="Botellas">Botellas</option>
                        </select>




                    </td>
                    <td>
                        <input type="submit" name="btnAccion" value="EditarProducto" >
                        
                    </td>
                    </tr>
                </form>
            </c:forEach>

        </tbody>
    </table>








</body>
</html>