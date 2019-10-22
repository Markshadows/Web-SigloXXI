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





        <div class="row">
            <div class="card">

                <div class="card-header">
                    <h1 class="card-title">Solicitudes</h1>
                    <h2 class="card-category">Enviar una Solicitud</h2>
                </div>
                <div class="card-body">


                    <div class="col-md-12">
                        <form action="BodegaServlet" method="POST">


                            <div class="table-responsive-sm">
                                <table class="table">
                                    <thead class=" text-danger">
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
                                            <tr>

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
                            </div>






                            <div class="col-md-4">
                                <div class="form-group">
                                    <h6>Asunto</h6>
                                    <input type="text" class="form-control" placeholder="Asunto" id="txtAsunto" name="txtAsunto" placeholder="Asunto..." >
                                </div>
                                <div class="form-group">
                                    <h6>Mensaje</h6>
                                    <input type="text" class="form-control" placeholder="Mensaje" id="txtMensaje" name="txtMensaje" placeholder="Mensaje..." >
                                </div>
                                <div class="form-group">
                                    <input type="submit" name="btnAccion" value="Enviar" >
                                </div>
                            </div>
                        </form>
                    </div>



                </div>
            </div>





            <div class="col-md-12">
                <div class="card">

                    <div class="card-header">
                        <h1 class="card-title">Solicitudes</h1>
                        <h2 class="card-category">Solicitudes Enviadas</h2>
                    </div>
                    <div class="card-body">

                        <div class="table-responsive">
                            <table class="table">
                                <thead class=" text-danger">
                                    <tr>
                                        <%--
                                        <th>id</th>
                                        --%>
                                        <th>asunto</th>
                                        <th>mensaje</th>
                                        <th>Productos</th>
                                        <th>estado</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="sol" items="${listaDeSolicitudes}">
                                        <tr>

                                            <%--
                                            <td><c:out value="${sol.idSolicitud}"/></td>
                                            --%>
                                            <td>${sol.asunto}</td>
                                            <td>${sol.mensaje}</td>
                                            <td>
                                                <c:forEach var="prosol" items="${sol.productoSolicitudList}">

                                                    <%--
                                                    ${prosol.productoId}
                                                    --%>
                                                    ${prosol.productoId.nombre}

                                                    Quedan:
                                                    <p class="text-danger">${prosol.productoId.metricaId.peso}
                                                        ${prosol.productoId.metricaId.medida}</p>


                                                </c:forEach>
                                            </td>



                                            <c:choose>
                                                <c:when test="${sol.estadoSolicitud.descripcion=='Enviada'}">
                                                    <td>
                                                        <p class="text-primary">${sol.estadoSolicitud.descripcion}</p>
                                                    </td>
                                                </c:when>    
                                                <c:otherwise>
                                                    <td>
                                                        <p class="text-danger">${sol.estadoSolicitud.descripcion}</p>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>


                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>


                    </div>
                </div>
            </div>   

        </div>   





























        <%--

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



        --%>






    </body>
</html>