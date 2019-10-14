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

        <section class="home-slider owl-carousel">
            <div class="slider-item" style="background-image: url('img/hero_1.jpg');">

                <div class="container">
                    <div class="row slider-text align-items-center justify-content-center">
                        <div class="col-md-8 text-center col-sm-12 element-animate">
                            <h1>cocina nacional</h1>
                            <p class="mb-5">Lo mejor de la cocina nacional, con recetas tradicionales y en manos de los mejores chef</p>
                            <p><a href="#" class="btn btn-white btn-outline-white">Get Started</a></p>
                        </div>
                    </div>
                </div>

            </div>


        </section>






    </section> <!-- .section -->


    <section class="py-5 bg-light">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6 text-center">
                    <div class="row">
                        <div class="col-md-12">
                            <h1>inicia sesion</h1>
                        </div>

                        <form action="Login" method="POST" class="col-12">
                            <div class="row align-items-center">
                                <div class="col-md-8 mb-3 mb-md-0">
                                    <input type="correo" class="form-control" name="txtCorreo" placeholder="jose@gmail.com">
                                </div>

                                <td />

                                <div class="col-md-8 mb-3 mb-md-0">
                                    <input type="password" class="form-control" name="txtPass" placeholder="ingrese correo electronico ">
                                </div>
                                <div class="col-md-4">
                                    <input type="submit" class="btn btn-primary btn-block" name="btnAccion" value="ingresar">
                                </div>
                            </div>
                            <c:if test="${error}">
                                <div class="alert alert-warning">
                                    Credenciales incorrectas
                                </div>
                            </c:if>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

    ${msj}

    <footer class="site-footer" role="contentinfo">
        <div class="container">
            <div class="row mb-5">
                <div class="col-md-4 mb-5">
                    <h3>About Us</h3>
                    <p class="mb-5">Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus et dolor blanditiis consequuntur ex voluptates perspiciatis omnis unde minima expedita.</p>
                    <ul class="list-unstyled footer-link d-flex footer-social">
                        <li><a href="#" class="p-2"><span class="fa fa-twitter"></span></a></li>
                        <li><a href="#" class="p-2"><span class="fa fa-facebook"></span></a></li>
                        <li><a href="#" class="p-2"><span class="fa fa-linkedin"></span></a></li>
                        <li><a href="#" class="p-2"><span class="fa fa-instagram"></span></a></li>
                    </ul>

                </div>
                <div class="col-md-5 mb-5">
                    <div class="mb-5">
                        <h3>Opening Hours</h3>
                        <p><strong class="d-block">Sunday-Thursday</strong> 5AM - 10PM</p>
                    </div>
                    <div>
                        <h3>Contact Info</h3>
                        <ul class="list-unstyled footer-link">
                            <li class="d-block">
                                <span class="d-block">Address:</span>
                                <span class="text-white">34 Street Name, City Name Here, United States</span></li>
                            <li class="d-block"><span class="d-block">Telephone:</span><span class="text-white">+1 242 4942 290</span></li>
                            <li class="d-block"><span class="d-block">Email:</span><span class="text-white">info@yourdomain.com</span></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 mb-5">
                    <h3>Quick Links</h3>
                    <ul class="list-unstyled footer-link">
                        <li><a href="#">About</a></li>
                        <li><a href="#">Terms of Use</a></li>
                        <li><a href="#">Disclaimers</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div>
                <div class="col-md-3">

                </div>
            </div>
            <div class="row">
                <div class="col-12 text-md-center text-left">
                    <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                </div>
            </div>
        </div>
    </footer>
    <!-- END footer -->

    <!-- loader -->
    <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#cf1d16"/></svg></div>

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.waypoints.min.js"></script>

    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/magnific-popup-options.js"></script>


    <script src="js/main.js"></script>
</body>
</html>
