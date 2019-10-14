<%-- 
    Document   : reservas
    Created on : 23-09-2019, 22:34:59
    Author     : Asus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <sql:setDataSource var="dataSource" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:XE" user="sigloxxi" password="sigloxxi"></sql:setDataSource>
    <sql:query dataSource="${dataSource}" var="a">
        select id ,numero from mesa 
    </sql:query> 
    <sql:query dataSource="${dataSource}" var="b">
        select id, nombre from estado 
    </sql:query>    
    <sql:query dataSource="${dataSource}" var="c">
        select id,nombre from usuario 
    </sql:query>  
    <head>
        <title>reserva</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800" rel="stylesheet">

        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">

        <link rel="stylesheet" href="css/magnific-popup.css">


        <link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
        <link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="fonts/flaticons/font/flaticon.css">

        <!-- Theme Style -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <!--
datos 
reserva 
id 
nombre*
fecha
usuario Id
mesa*
nombre*
estado*
        -->
        <%@include file="menu.jsp" %>
        <section class="section element-animate">
            <div class="clearfix mb-5 pb-5">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12 text-center heading-wrap">
                            <h2>Ingresa Reserva</h2>
                            <span class="back-text">Reserva</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">


                        <form action="Reserva" method="POST">
                            <div class="row">
                             <!--   <div class="col-md-6 form-group">
                                    <label >nombre</label>
                                    <input type="text" name="txtNombre" class="form-control ">
                                </div>
-->
                                <div class="col-md-6 form-group">
                                    <label>mesa</label>
                                    <select name="cboMesa" class="form-control-plaintext" >
                                        <c:forEach var="mesa" items="${a.rows}">
                                            <option value="${mesa.id}" >mesa  ${mesa.numero} </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-md-6 form-group">
                                    <label for="cboUsuario">usuario</label>
                                    <select name="cboUsuario" class="form-control-plaintext " >
                                        <c:forEach var="usu" items="${c.rows}">
                                            <option value="${usu.id}" >${usu.nombre} </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label for="cboMEsa">estado</label>
                                    <select name="cboEstado" class="form-control-plaintext " >
                                        <c:forEach var="esta" items="${b.rows}">
                                            <option value="${esta.id}" >${esta.nombre} </option>
                                        </c:forEach>
                                    </select>
                                </div>



                                <div class="row">
                                    <div class="col-md-6 form-group">
                                        <input type="submit" value="ingresar" name="btnAccion" class="btn btn-primary">
                                    </div>
                                </div>

                            </div>
                        </form>
   </div>
                                </div>

                            </div>

                      
                        <!-- END footer -->

                        <!-- loader 
                        <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#cf1d16"/></svg></div>
                        -->
                        <script src="js/jquery-3.2.1.min.js"></script>
                        <script src="js/popper.min.js"></script>
                        <script src="js/bootstrap.min.js"></script>
                        <script src="js/owl.carousel.min.js"></script>
                        <script src="js/jquery.waypoints.min.js"></script>

                        <script src="js/jquery.magnific-popup.min.js"></script>
                        <script src="js/magnific-popup-options.js"></script>


                        <script src="js/main.js"></script>
                        </body>
                          <%@include file="footer.jsp"  %>
        </html>
