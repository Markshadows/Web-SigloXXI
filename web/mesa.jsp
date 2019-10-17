<%-- 
    Document   : Mesa
    Created on : 14-10-2019, 15:49:59
    Author     : Asus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

    <head>
        <title>ingresar Cliente</title>
        <meta charset="utf-8">
        <jsp:include page="Reserva"></jsp:include>
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

            <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800" rel="stylesheet">

            <link rel="stylesheet" href="css/bootstrap.css">
            <link rel="stylesheet" href="css/animate.css">
            <link rel="stylesheet" href="css/owl.carousel.min.css">

            <link rel="stylesheet" href="css/magnific-popup.css">
            <script src="js/validarRUT.js" type="text/javascript"></script>

            <link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
            <link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">
            <link rel="stylesheet" href="fonts/flaticons/font/flaticon.css">

            <!-- Theme Style -->
            <link rel="stylesheet" href="css/style.css">
        </head>
        <body>

            <section class="section element-animate">
                <div class="clearfix mb-5 pb-5">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12 text-center heading-wrap">
                                <h2>Registrate</h2>
                                <span class="back-text"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <form action="Reserva" method="POST">
                                <div class="row">
                                    <div class="col-md-12 form-group">
                                        
                                        <select name="cboMesa" class="form-control-plaintext " >
                                    <c:forEach var="item" items="${me}">
                                        <option value="${item.id}" >mesa ${item.numero} con cantidad ${item.sillas} sillas</option>
                                    </c:forEach>
                                        </select>
                                </div>
                                <div class="col-md-12 form-group">
                                    <div class="col-md-12 form-group">
                                        <input type="submit" value="mesa" name="btnAccion" class="btn btn-primary">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

${secuencia}

    </body>
    <%@include file="footer.jsp"  %>
</html>