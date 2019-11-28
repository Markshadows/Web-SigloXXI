<%-- 
  Document   : login
  Created on : 25-09-2019, 23:27:21
  Author     : Asus
--%>

<%-- 
    Document   : index
    Created on : 23-09-2019, 22:28:17
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SigloxxI</title>
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


        <header role="banner">
            <nav class="navbar navbar-expand-md navbar-dark bg-dark">
                <div class="container">
                    <a class="navbar-brand" href="index.jsp">Siglo XXI</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample05" aria-controls="navbarsExample05" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarsExample05">
                        <ul class="navbar-nav ml-auto pl-lg-5 pl-0">
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item cta-btn">
                                    <a class="nav-link" href="index.jsp">volver</a>
                                </li>
                            </ul>
                    </div>
                </div>
            </nav>
        </header>



        <section class="py-5 bg-light">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-6 text-center">
                        <div class="row">
                            <div class="col-md-12">
                                <h1>inicia sesion</h1>
                            </div>

                            <form action="login" method="POST" class="col-12">
                                <div class="row align-items-center">
                                    <div class="col-md-8 mb-3 mb-md-0">
                                        <input type="email" class="form-control" name="txtCorreo" placeholder="jose@gmail.com">
                                    </div>

                                    <td />

                                    <div class="col-md-8 mb-3 mb-md-0">
                                        <input type="password" class="form-control" name="txtPass" placeholder="ingrese correo electronico ">
                                    </div>
                                    <div class="col-md-4">
                                        <input type="submit" class="btn btn-primary btn-block" name="btnAccion" value="ingresar">
                                    </div>
                                </div>


                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>

  
    <c:if test="${error!=null}">
              <div class="alert alert-danger">
            <strong>${error}<strong> 
                 </div>   
                    </c:if>

                    </html>
