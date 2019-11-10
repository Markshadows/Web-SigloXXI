<%-- 
    Document   : AdminBodega
    Created on : 20-10-2019, 11:20:38
    Author     : Betta
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>
            Siglo XXI
        </title>
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
              name='viewport' />
        <!--     Fonts and icons     -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <!-- CSS Files -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/css/paper-dashboard.css?v=2.0.0" rel="stylesheet" />
        <!-- CSS Just for demo purpose, don't include it in your project -->
        <link href="assets/demo/demo.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        
        
        






        
        <script>
            function printDiv(divName) {
                var printContents = document.getElementById(divName).innerHTML;
                var originalContents = document.body.innerHTML;

                document.body.innerHTML = printContents;

                window.print();

                document.body.innerHTML = originalContents;
                
                <input type="button" onclick="printDiv('printableArea')" value="print a div!" />
            }
        </script>
        

    </head>

    <body class="">

        <div class="wrapper ">
            <div class="sidebar" data-color="white" data-active-color="danger">
                <div class="logo">
                    <a href="" class="simple-text logo-mini">
                        <div class="">
                            <img src="assets/IMG/Restaurant-Logo-by-Koko-Store-580x386.jpg">
                        </div>
                    </a>
                    <a href="" class="simple-text logo-normal">
                        <h1 class="">SIGLO XXI</h1>
                        <!-- <div class="logo-image-big">
                          <img src="../assets/img/logo-big.png">
                        </div> -->
                    </a>
                </div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li class="active ">
                            <a data-toggle="pill" href="#home">
                                <i class="nc-icon nc-single-copy-04"></i>
                                <p>Inventario</p>
                            </a>
                        </li>
                        <li>
                            <a data-toggle="pill" href="#menu1">
                                <i class="nc-icon nc-paper"></i>
                                <p>Ingresos</p>
                            </a>
                        </li>
                        <li>
                            <a data-toggle="pill" href="#menu2">
                                <i class="nc-icon nc-delivery-fast"></i>
                                <p>Recepcion</p>
                            </a>
                        </li>
                        <li>
                            <a data-toggle="pill" href="#menu3">
                                <i class="nc-icon nc-chat-33"></i>
                                <p>Solicitudes</p>

                            </a>
                        </li>
                    </ul>
                </div>
            </div>




            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
                    <div class="container-fluid">
                        <div class="navbar-wrapper">
                            <div class="navbar-toggle">
                                <button type="button" class="navbar-toggler">
                                    <span class="navbar-toggler-bar bar1"></span>
                                    <span class="navbar-toggler-bar bar2"></span>
                                    <span class="navbar-toggler-bar bar3"></span>
                                </button>
                            </div>
                            <a class="navbar-brand" href="">Administracion de la Bodega</a>
                        </div>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
                                aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-end" id="navigation">
                            <ul class="navbar-nav">
                                <!-- AQUI FORMULARIO PARA CERRAR SESION -->
                                <li class="nav-item ">
                                    <a class="nav-link btn-rotate" href="#">
                                        <i class="nc-icon nc-user-run"></i>
                                        <p>
                                            <span class="d-lg d-md-block">Salir</span>
                                        </p>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- End Navbar -->
                <!-- <div class="panel-header panel-header-lg">
          
                
            <canvas id="bigDashboardChart"></canvas>
          
          
          </div> -->
                <div class="content">
                    <div class="tab-content">
                        <div id="home" class="tab-pane fade in active">
                            <h1>inventario.jsp</h1>
                            <jsp:include page="inventario.jsp" ></jsp:include>
                            </div>

                            <div id="menu1" class="tab-pane fade">
                                <h1>bodega.jsp</h1>
                            <jsp:include page="bodega.jsp" ></jsp:include>
                            </div>

                            <div id="menu2" class="tab-pane fade">
                                <h1>ingresoproductos.jsp</h1>
                            <jsp:include page="ingresoproductos.jsp" ></jsp:include>
                            </div>

                            <div id="menu3" class="tab-pane fade">
                                <h1>solicitud.jsp</h1>
                            <jsp:include page="solicitud.jsp" ></jsp:include>
                        </div>
                    </div>
                </div>
                <footer class="footer footer-black  footer-white ">
                    <div class="container-fluid">
                        <div class="row">
                            <nav class="footer-nav">
                                <ul>
                                    <li>
                                        <a href="https://www.creative-tim.com" target="_blank">Creative Tim</a>
                                    </li>
                                    <li>
                                        <a href="http://blog.creative-tim.com/" target="_blank">Blog</a>
                                    </li>
                                    <li>
                                        <a href="https://www.creative-tim.com/license" target="_blank">Licenses</a>
                                    </li>
                                </ul>
                            </nav>
                            <div class="credits ml-auto">
                                <span class="copyright">
                                    ©
                                    <script>
                                        document.write(new Date().getFullYear())
                                    </script>, made with <i class="fa fa-heart heart"></i> by Creative Tim
                                </span>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>

        <!--   Core JS Files   -->
        <script src="assets/js/core/jquery.min.js"></script>
        <script src="assets/js/core/popper.min.js"></script>
        <script src="assets/js/core/bootstrap.min.js"></script>


        <script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>


        <!-- Chart JS -->
        <script src="assets/js/plugins/chartjs.min.js"></script>

        <!--  Notifications Plugin    -->
        <script src="assets/js/plugins/bootstrap-notify.js"></script>
        <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
        <script src="assets/js/paper-dashboard.min.js?v=2.0.0" type="text/javascript"></script>

    </body>

</html>