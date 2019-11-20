<%-- 
    Document   : cliente
    Created on : 02-10-2019, 12:53:04
    Author     : Asus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    HttpSession se=request.getSession();
    se.removeAttribute("boletas");
    se.removeAttribute("reserva");
    se.removeAttribute("cerror");
    se.removeAttribute("carrito");
    se.removeAttribute("valor");
    //se.removeAttribute("cerror");
    se.removeAttribute("clientes");
    
    
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>ingresar Cliente</title>
        <meta charset="utf-8">
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
                        <form action="Cliente" method="POST">
                            <div class="row">
                                <div class="col-md-12 form-group">
                                    <label >rut</label>
                                    <input type="text" name="txtRut" oninput="checkRut(this)" required="" placeholder="19999245-5"  class="form-control ">
                                </div>
                                <div class="col-md-12 form-group">
                                    <label >nombre</label>
                                    <input type="text" name="txtNombre" required="5" placeholder="juanito figueroa" class="form-control ">
                                </div>
                                <div class="col-md-12 form-group">
                                    <div class="col-md-12 form-group">
                                        <input type="submit" value="ingresar" name="btnAccion" class="btn btn-primary">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
  <div class="jumbotron">
                        ${rese.getNombre()}
                        ${clientes.getNombre()}
                    </div>

            <c:if test="${cerror!=null}">
                <div class="alert alert-danger">
                    <strong>${cerror}<strong> 
                </div>
            </c:if>
    </body>
    <%@include file="footer.jsp"  %>
</html>
