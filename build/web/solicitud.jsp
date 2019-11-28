
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitar</title>

        <script>
            // Write on keyup event of keyword input element
            $(document).ready(function () {
                $("#buscarProductoTab").keyup(function () {
                    _this = this;
                    // Show only matching TR, hide rest of them
                    $.each($("#tablaSolicitarProducto tbody tr"), function () {
                        if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                            $(this).hide();
                        else
                            $(this).show();
                    });
                });
            });

            $(document).ready(function () {
                $("#buscarSolicitud").keyup(function () {
                    _this = this;
                    // Show only matching TR, hide rest of them
                    $.each($("#tablaSolicitudes tbody tr"), function () {
                        if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                            $(this).hide();
                        else
                            $(this).show();
                    });
                });
            });

            $(document).ready(function () {
                $("#selectEstado").change(function () {
                    _this = this;
                    $.each($("#tablaSolicitudes tbody tr"), function () {
                        if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                            $(this).hide();
                        else
                            $(this).show();
                    });
                });
            });
        </script>

    </head>

    <body>

        <jsp:useBean id="estadoSolicitudes" class="java.util.ArrayList"/>

        <jsp:include page="/BodegaServlet" />

        <c:if test="${!empty mensaje}" >
            <strong>${mensaje}</strong> 
        </c:if>

        <c:if test="${!empty errors}" >
            <strong>${errors}</strong> 
        </c:if>



        <form id="formSolicitarIngreso" action="BodegaServlet" method="POST">
            <div class="row">
                <div class="col-md-4">
                    <div class="card">

                        <div class="card-header">
                            <h1 class="card-title">Solicitudes</h1>
                            <h2 class="card-category">Descripcion del asunto</h2>
                        </div>

                        <div class="card-body">

                            <div class="form-group has-label">
                                <label>
                                    Asunto
                                </label>
                                <input required="true" type="text" class="form-control" placeholder="Asunto" id="txtAsunto" name="txtAsunto" placeholder="Asunto..." >
                            </div>

                            <div class="form-group has-label">
                                <label>
                                    Mensaje
                                </label>
                                <textarea type="text" style="width: 600px; height: 800px" maxlength="255" class="form-control" placeholder="Cuerpo del mensaje- maximo 255 caracteres" id="txtMensaje" name="txtMensaje" placeholder="Mensaje..." ></textarea>
                            </div>


                            
                            <div class="col-md-12" style="align-items: center; padding: auto">
                                <input class="btn btn-lg btn-danger" type="submit" name="btnAccion" value="Enviar" >
                            </div>
                        </div>

                        <div class="card-footer">
                            <i class="nc-icon nc-alert-circle-i"></i> Favor de seleccionar productos
                        </div>

                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">
                            <h1 class="card-title">Solicitudes</h1>
                            <h2 class="card-category">Enviar una Solicitud</h2>



                            <div class="form-group" style="padding-left: 70%">
                                <%-- style="width:50%" --%>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text"><i class="nc-icon nc-zoom-split"></i></div>
                                    </div>
                                    <input type="text" class="form-control pull-right" style="width:40%" id="buscarProductoTab" placeholder="Buscar...">
                                </div>
                            </div>

                        </div>
                        <div class="card-body">
                            <div class="table-responsive-sm">
                                <table class="table" id="tablaSolicitarProducto">
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
                        </div>
                    </div>
                </div>
            </div>
        </form>













        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h1 class="card-title">Solicitudes</h1>
                        <h2 class="card-category">Solicitudes Enviadas</h2>
                        <%--
                        <div class="input-group">
                            <input type="text" class="form-control pull-right" style="width:40%" id="buscarSolicitud" placeholder="Buscar...">
                            <span class="input-group-addon">
                                <i class="nc-icon nc-zoom-split"></i>
                            </span>
                        </div>
                        --%>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table" id="tablaSolicitudes">
                                <thead class=" text-danger">
                                    <tr>
                                        <%--
                                        <th>id</th>
                                        --%>
                                        <th>asunto</th>
                                        <th>mensaje</th>
                                        <th>Productos</th>
                                        <th>
                                            <%--
                                            <div class="lfr-panel-solicitud">
                                                <c:forEach var="x" items="${listaDeSolicitudes}">
                                                    <c:if test="${not fn:containsIgnoreCase( estadoSolicitudes , x.estadoSolicitud.descripcion )}">
                                                        <c:set var="noUse" value="${estadoSolicitudes.add( x.estadoSolicitud.descripcion)}"/>
                                                    </c:if>
                                                </c:forEach>
                                                <select id="selectEstado" class="btn btn-danger" aria-expanded="false" aria-haspopup="true" name="">
                                                    <option class="dropdown-item" value="">Estado</option>
                                                    <p class="dropdown-divider"></p>
                                                    <c:forEach var="y" items="${estadoSolicitudes}">
                                                        <option class="dropdown-item" value="${y}">${y}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            --%>
                                            Estado

                                        </th>
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
                                                        <p class="text-primary"><strong> ${sol.estadoSolicitud.descripcion}</strong></p>
                                                    </td>
                                                </c:when>
                                                <c:when test="${sol.estadoSolicitud.descripcion=='Abierta'}">
                                                    <td>
                                                        <p class="text-info"><strong>${sol.estadoSolicitud.descripcion}</strong></p>
                                                    </td>
                                                </c:when>
                                                <c:when test="${sol.estadoSolicitud.descripcion=='Pospuesta'}">
                                                    <td>
                                                        <p class="text-warning"><strong>${sol.estadoSolicitud.descripcion}</strong></p>
                                                    </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>
                                                        <p class="text-danger"><strong>${sol.estadoSolicitud.descripcion}</strong></p>
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


        <%--
        <div class="row">
            <jsp:include page="pruebaPag.jsp" ></jsp:include>
        </div>
        --%>



    </body>
</html>