<%-- 
    Document   : bodega
    Created on : 03-10-2019, 20:42:49
    Author     : Betta
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

        <script>
            // Write on keyup event of keyword input element
            $(document).ready(function () {
                $("#ingresoBuscar").keyup(function () {
                    _this = this;
                    // Show only matching TR, hide rest of them
                    $.each($("#tablaIngresos tbody tr"), function () {
                        if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                            $(this).hide();
                        else
                            $(this).show();
                    });
                });
            });

            $(document).ready(function () {
                $("#selectProve").change(function () {
                    _this = this;
                    $.each($("#tablaIngresos tbody tr"), function () {
                        if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                            $(this).hide();
                        else
                            $(this).show();
                    });
                });
            });

            $(document).ready(function () {
                $("#fechaIngreso").change(function () {
                    _this = this;
                    $.each($("#tablaIngresos tbody tr"), function () {
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

        <jsp:useBean id="listaIngresosProveedor" class="java.util.ArrayList"/>
        <jsp:useBean id="listaIngresosRecivido" class="java.util.ArrayList"/>

        <%--
        <jsp:useBean id="string" class="java.lang.String"/>
        --%>
        <jsp:include page="/BodegaServlet" />





        <div class="row">
            <div class="col-md-12">
                <div class="card" style="">

                    <div class="card-header" style="">
                        <h1 class="card-title">Ingresos</h1>
                        <h2 class="card-category">Tabla de Ingresos</h2>
                        <div class="input-group">
                            <input type="text" class="form-control pull-right" style="width:40%" id="ingresoBuscar" placeholder="Buscar...">
                            <span class="input-group-addon">
                                <i class="nc-icon nc-zoom-split"></i>
                            </span>
                        </div>
                    </div>


                    <div class="card-body">

                        <div class="table-responsive">

                            <table class="table" id="tablaIngresos">
                                <thead class=" text-primary">
                                    <tr>

                                        <th>
                                            fecha de ingreso <span class="glyphicon glyphicon-calendar"></span>   
                                        </th>



                                        <th>

                                            Recivido por:

                                            <%--
                                            <c:forEach var="x" items="${listaDetalleIngreso}">
                                                <c:if test="${not fn:containsIgnoreCase( listaIngresosRecivido , 
                                                              
                                                              ( x.idIngreso.usuarioId.nombre.toString().concat( x.idIngreso.usuarioId.apellidos))
                                                              
                                                              )}">
                                                    <c:set var="noUse" value="${listaIngresosRecivido.add((x.idIngreso.usuarioId.nombre + x.idIngreso.usuarioId.apellidos))}"/>
                                                </c:if>
                                            </c:forEach>
                                            --%>
                                            <%--
                                            <select id="selectProve" class="btn btn-info" aria-expanded="false" aria-haspopup="true" name="">
                                                <option class="dropdown-item" value="">Recivido Por:</option>
                                                <p class="dropdown-divider"></p>
                                                <c:forEach var="y" items="${listaIngresosRecivido}">
                                                    <option class="dropdown-item" >${y}</option>
                                                </c:forEach>

                                            </select>
                                           
                                            --%>

                                        </th>
                                        <th>

                                            <c:forEach var="x" items="${listaDetalleIngreso}">
                                                <c:if test="${not fn:containsIgnoreCase( listaIngresosProveedor , x.idIngreso.productoId.proveedorId.nombre )}">
                                                    <c:set var="noUse" value="${listaIngresosProveedor.add(x.idIngreso.productoId.proveedorId.nombre)}"/>
                                                </c:if>
                                            </c:forEach>


                                            <select id="selectProve" class="btn btn-info" aria-expanded="false" aria-haspopup="true" name="">
                                                <option class="dropdown-item" value="">Proveedor</option>
                                                <p class="dropdown-divider"></p>
                                                <c:forEach var="y" items="${listaIngresosProveedor}">
                                                    <option class="dropdown-item" value="${y}">${y}</option>
                                                </c:forEach>

                                            </select>


                                        </th>
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

                                            <td style="align-content: space-between">
                                                ${item.idIngreso.productoId.proveedorId.nombre}
                                            </td>

                                            <td>

                                                <div class="" style="align-items: flex-start">

                                                    <p class="text-muted">Codigo: ${item.idIngreso.productoId.codigo}</p>
                                                    <p class="text-warning"> <strong>${item.idIngreso.productoId.nombre}</strong>  </p>

                                                </div>

                                            </td>

                                            <td >



                                                <div class="" style="text-align: left">


                                                    <p class="text-muted">Habian: ${item.pesoAntiguo} en inventario</p>
                                                    <p class="text-warning"><strong>  Ingresaron: ${item.pesoIngresado} </strong>  </p>

                                                </div>


                                                    
                                                <p class="text-info"
                                                   style="text-align: center"><strong>  Ahora Hay: ${item.idIngreso.productoId.metricaId.peso} ${item.idIngreso.productoId.metricaId.medida}</strong> </p>

                                                <%--
                                                <h6 class="" style="text-align: right">Ahora Hay: ${item.pesoNuevo}</h6>
                                                --%>




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



    </body>
</html>