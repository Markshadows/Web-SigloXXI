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


        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">


    </head>

    <body>


        <jsp:include page="/BodegaServlet" />




        <div class="col-md-12">
            <div class="card">

                <div class="card-header">
                    <h1 class="card-title">Ingresos</h1>
                    <h2 class="card-category">Tabla de Ingresos</h2>
                </div>
                <div class="card-body">

                    <div class="table-responsive">
                        <table class="table">
                            <thead class=" text-primary">
                                <tr>
                                    <th>fecha de ingreso</th>
                                    <th>Recivido por:</th>
                                    <th>Proveedor</th>
                                    <th>Producto</th>
                                    <th>Metrica</th>

                                </tr>

                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${listaDetalleIngreso}">
                                    <tr>
                                        <td>

                                            <p>  

                                                El
                                                <fmt:formatDate type="date" dateStyle="long" value="${item.idIngreso.ingreso}" />
                                                A las
                                                <fmt:formatDate type="time" timeStyle="short" value="${item.idIngreso.ingreso}" />
                                            </p> 


                                        </td>


                                        <td>
                                            ${item.idIngreso.usuarioId.nombre}
                                            ${item.idIngreso.usuarioId.apellidos}
                                        </td>

                                        <td>
                                            ${item.idIngreso.productoId.proveedorId.nombre}
                                        </td>

                                        <td>
                                            ${item.idIngreso.productoId.codigo} //
                                            ${item.idIngreso.productoId.nombre} //
                                        </td>

                                        <td >
                                            ${item.idIngreso.productoId.metricaId.peso} //
                                            ${item.idIngreso.productoId.metricaId.medida} //

                                            <p>Habian: ${item.pesoAntiguo} en inventario</p>
                                            <p>Ingresaron: ${item.pesoIngresado}</p>
                                            <p>Ahora Hay: ${item.pesoNuevo}</p>



                                        </td>


                                    </tr>

                                </c:forEach>

                            </tbody>
                        </table>
                    </div>


                </div>
            </div>
        </div>   




        <!--

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
                <option value="Unidades">Unidades</option>
                <option value="Paquetes">Paquetes</option>
                <option value="Botellas">Botellas</option>
            </select>


            
            <input type="text" id="medida" name="txtMedida" placeholder="Medida" >
            


            <h6>Codigo</h6>
            <input type="text" id="codigo" name="txtCodigo" placeholder="Codigo" >

            <h6>Nombre</h6>
            <input type="text" id="nombre" name="txtNombre" placeholder="Nombre" >


            <h6> idProveedor </h6>
            <select name="txtIdProveedor">
                <option value="0"> Seleccione...</option>
        <%--
        <c:forEach var="item" items="${listaDeProveedor}">
            <option value="${item.id}">${item.nombre}</option>
        </c:forEach>
        
        --%>
    </select>


    <h6> idUsuario </h6>
    <select name="txtIdUsuario">
        <option value="0"> Seleccione...</option>
        <%--
        <c:forEach var="item" items="${listaDeUsuario}">
            <option value="${item.id}">${item.nombre}</option>
        </c:forEach>
        --%>
    </select>


    <input type="submit" name="btnAccion" value="RegistrarIngreso" >

</form>

--

        -->










        <%--
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

        --%>







    </body>
</html>