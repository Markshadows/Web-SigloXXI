<%-- 
    Document   : inventario.jsp
    Created on : 21-10-2019, 19:31:41
    Author     : Betta
--%>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
--%>



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
                $("#search").keyup(function () {
                    _this = this;
                    // Show only matching TR, hide rest of them
                    $.each($("#mytable tbody tr"), function () {
                        if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                            $(this).hide();
                        else
                            $(this).show();
                    });
                });
            });

            $(document).ready(function () {
                $("#selectPorProveedor").change(function () {
                    _this = this;
                    // Show only matching TR, hide rest of them
                    $.each($("#mytable tbody tr"), function () {
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
        <jsp:useBean id="list" class="java.util.ArrayList"/>
        <%--
        <c:set var="noUse" value="${list.add('YourThing')}"/>
        <c:set var="noUse" value="${list.add('YourThing1')}"/>
        <c:out value="${list}"/>
        <br>
        <c:forEach var="z" items="${list}">
            <c:out value="${z}"></c:out>
        </c:forEach>
        --%>
        <%--
            <sql:setDataSource var = "snapshot" driver = "com.oracle.jdbc.ojdbc6"
                               url = "jdbc:oracle:thin:@mycm.cl:4921:XE"
                               user = "siglo21"  password = "siglo21"/>

    <sql:query dataSource = "${snapshot}" var = "result">
        SELECT nombre FROM proveedor;
    </sql:query>

    <c:forEach items="${result}" var="pro">
        <c:out value = "${pro}"/>
    </c:forEach>
        --%>
        <jsp:include page="/BodegaServlet" />

        <div class="col">
            <div class="card">
                <div class="card-header">
                    <div class="info">
                        <h4 class="info-title">Existencias</h4>
                        <p>Productos en bodega</p>
                    </div>
                    <blockquote class="blockquote text-right blockquote-danger">
                        <p class="mb-0 text-danger">Esta tabla es referencial a los productos existente actualmente al dia: 
                            <script>
                                document.write(new Date().getDate())
                            </script>
                            /
                            <script>
                                document.write(new Date().getMonth())
                            </script>
                            /
                            <script>
                                document.write(new Date().getFullYear())
                            </script>
                        </p>
                    </blockquote>
                </div>


                <br>


                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table" id="mytable">
                            <thead class=" text-primary">
                                <tr>
                                    <th>id</th>
                                    <th>codigo</th>
                                    <th>Producto
                                    </th>

                                    <th>
                                        <%--
                                        <div class="lfr-panel-inventario">
                                            <c:forEach var="x" items="${listaDeProductos}">
                                                <c:if test="${not fn:containsIgnoreCase(list, x.proveedorId.nombre)}">
                                                    <c:set var="noUse" value="${list.add(x.proveedorId.nombre)}"/>
                                                </c:if>
                                            </c:forEach>

                                            <select id="selectPorProveedor" class="btn btn-info dropdown-toggle" aria-expanded="false" aria-haspopup="true" name="">
                                                <option class="form-control" value="">Proveedor</option>

                                                <c:forEach var="y" items="${list}">
                                                    <option class="form-control" value="${y}">${y}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        --%>
                                        Proveedor
                                    </th>
                                    <th>Metrica</th>
                                </tr>
                            </thead>
                            <tbody class="table-body">
                                <c:forEach var="item" items="${listaDeProductos}">
                                    <tr>
                                        <td class="disabled" >${item.id}</td>
                                        <td>${item.codigo}</td>
                                        <td>${item.nombre}</td>
                                        <td>${item.proveedorId.nombre}</td>
                                        <td>${item.metricaId.peso} ${item.metricaId.medida}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
