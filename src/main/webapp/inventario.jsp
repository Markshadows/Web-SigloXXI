<%-- 
    Document   : inventario.jsp
    Created on : 21-10-2019, 19:31:41
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
                    <h1 class="title">Existencias</h1>
                    <h1>Productos en bodega </h1>
                </div>
                <div class="card-body">

                    <div class="table-responsive">
                        <table class="table">
                            <thead class=" text-primary">
                                <tr>
                                    <th>
                                        id
                                    </th>
                                    <th>codigo</th>
                                    <th>nombre</th>
                                    <th>Proveedor</th>
                                    <th>Metrica</th>
                                </tr>
                            </thead>
                            <tbody class="table-body">
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
                    </div>

                </div>
            </div>
        </div>



    </body>
</html>
