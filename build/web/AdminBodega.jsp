<%@page import="java.lang.Object"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>

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
        <link media="screen" href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
        <link media="screen" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <!-- CSS Files -->
        <link media="screen" href="assets/css/paper-dashboard.css?v=2.0.0" rel="stylesheet" />
        <link media="screen" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <link media="screen" href="assets/css/bootstrap.min.css" rel="stylesheet" />

        <link media="print" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <style media="print" type="text/css">

            @media print {

                #divMenu,#idNavbar,#rowImprimir,#idFooter,#search, .page-break
                ,#ingresoBuscar,#formIngresoProducto,#formSolicitarIngreso,#buscarSolicitud
                {
                    display: none;
                }

                #container #content #main {
                    width: 90%;
                    margin: 0px;
                    padding: 0px;
                }

                .page-break  { display: block; page-break-before: always; }

                /**/
                .lfr-panel-title #selectProve{
                    display:none;
                }

                .lfr-panel-title:after{
                    content: "Proveedor";   
                }

                .lfr-panel-inventario #selectPorProveedor{
                    display:none;
                }

                .lfr-panel-inventario:after{
                    content: "Proveedor";   
                }



                .lfr-panel-solicitud #selectEstado{
                    display:none;
                }

                .lfr-panel-solicitud:after{
                    content: "Estado";   
                }

                /**/


                table {
                    display: table;
                    border-collapse: separate;
                    border-spacing: 2px;
                    border-color: grey;
                }
                *, ::after, ::before {
                    box-sizing: border-box;
                }
                table {
                    border-collapse: collapse;
                }
                .table {
                    width: 100%;
                    max-width: 100%;
                    margin-bottom: 1rem;
                    background-color: transparent;
                }

                thead {
                    display: table-header-group;
                    vertical-align: middle;
                    border-color: inherit;
                }
                tr {
                    display: table-row;
                    vertical-align: inherit;
                    border-color: inherit;
                }

                .table>thead>tr>th, .table>tbody>tr>th, .table>tfoot>tr>th, .table>thead>tr>td, .table>tbody>tr>td, .table>tfoot>tr>td {
                    padding: 12px 7px;
                    vertical-align: middle;
                }
                .table>thead>tr>th {
                    font-size: 14px;
                    font-weight: 700;
                    padding-bottom: 0;
                    text-transform: uppercase;
                    border: 0;
                }
                .table thead th {
                    vertical-align: bottom;
                    border-bottom: 2px solid #dee2e6;
                }
                .table td, .table th {
                    padding: .75rem;
                    vertical-align: top;
                    border-top: 1px solid #dee2e6;
                }
                th {
                    text-align: inherit;
                }
                *, ::after, ::before {
                    box-sizing: border-box;
                }


                th {
                    display: table-cell;
                    vertical-align: inherit;
                    font-weight: bold;
                    text-align: -internal-center;
                }

                .table>thead>tr>th, .table>tbody>tr>th, .table>tfoot>tr>th, .table>thead>tr>td, .table>tbody>tr>td, .table>tfoot>tr>td {
                    padding: 12px 7px;
                    vertical-align: middle;
                }

                .table td, .table th {
                    padding: .75rem;
                    vertical-align: top;
                    border-top: 1px solid #dee2e6;
                }
                *, ::after, ::before {
                    box-sizing: border-box;
                }
                user agent stylesheet
                td {
                    display: table-cell;
                    vertical-align: inherit;
                }


                *{
                    align-items: center;
                    align-content: center;
                }

            }



            .text-primary{
                color: #51cbce !important;
            }

            .text-info{
                color: #51bcda !important;
            }

            .text-success {
                color: #6bd098 !important;
            }

            .text-warning {
                color: #fbc658 !important;
            }

            .text-danger{
                color: #ef8157 !important;
            }

            .text-gray {
                color: #E3E3E3 !important;
            }

        </style>



        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="/home/datat/private_releases/Editor-1.9.2/css/editor.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/autofill/2.3.4/css/autoFill.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/colreorder/1.5.2/css/colReorder.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/fixedcolumns/3.3.0/css/fixedColumns.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/fixedheader/3.1.6/css/fixedHeader.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/keytable/2.5.1/css/keyTable.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/rowgroup/1.1.1/css/rowGroup.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/rowreorder/1.2.6/css/rowReorder.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/scroller/2.0.1/css/scroller.dataTables.css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.1/css/select.dataTables.css"/>


        <style>
            .error {
                color: red;
                background-color: #acf;
            }
        </style>

    </head>

    <body class="">
        <sql:setDataSource var = "snapshot" driver = "oracle.jdbc.OracleDriver"
                           url = "jdbc:oracle:thin:@mycm.cl:4921:XE"
                           user = "siglo21"  password = "siglo21"/>

        <sql:query dataSource = "${snapshot}" var = "result">
            SELECT * FROM SOLICITUDES_HECHAS
        </sql:query>
        <%--
    <c:forEach var = "row" items = "${result.rows}">
        <c:out value = "${row}"/>
    </c:forEach>
        --%>

        <%--
                <sql:query dataSource = "${snapshot}" var = "result">
                    select p.nombre as "producto",
                    AVG( TO_CHAR(i.ingreso,'DD') ) as "promedio"
                    from ingreso i inner join producto p on p.id = i.producto_id
                    group by p.nombre
                </sql:query>

            <c:forEach var = "row" items = "${result.rows}">
                            '<c:out value = "${row.producto}"/>',
            </c:forEach>
 
<c:forEach var = "row" items = "${result.rows}">
                <c:out value = "${row.promedio}"/>,
            </c:forEach>
           
    <c:forEach items="${result}" var="pro">
        <c:out value = "${pro}"/>
    </c:forEach>
        --%>


        <div class="wrapper ">
            <div id="divMenu" class="sidebar" data-color="white" data-active-color="danger">
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
                <nav id="idNavbar" class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
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
                        <div class="collapse navbar-collapse justify-content-end row-12" id="navigation">
                            <ul class="navbar-nav">
                                <!-- AQUI FORMULARIO PARA CERRAR SESION -->
                                <li style="" class="nav-item ">
                                    <a style="" class="nav-link btn-rotate" href="#">
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

                            <%--<h1>inventario.jsp</h1>--%>

                            <div id="rowImprimir" class="row">
                                <div class="col-lg-3 col-md-6 col-sm-6">
                                    <div class="card card-stats">
                                        <div class="card-body ">
                                            <div class="row">
                                                <div class="col-5 col-md-4">
                                                    <div class="icon-big text-center icon-warning">
                                                        <i class="nc-icon nc-cloud-download-93 text-danger"></i>
                                                    </div>
                                                </div>
                                                <div class="col-7 col-md-8">
                                                    <div class="numbers">
                                                        <p class="card-category">Generar Reporte</p>
                                                        <p class="card-title">
                                                            <a id="btn-imprimir" class="btn btn-danger" href="javascript:window.print();">Imprimir</a>
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-footer ">
                                            <hr>
                                            <div class="stats">
                                                <i class="fa fa-download"></i> Reporte de estado general de bodega.
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                <div class="col-lg-3 col-md-6 col-sm-6">
                                    <div class="card card-stats">
                                        <div class="card-body ">
                                            <div class="row">
                                                <div class="col-4 col-md-5">
                                                    <div class="icon-big text-center icon-warning">
                                                        <i class="fa fa-file-pdf-o" aria-hidden="true"></i>
                                                    </div>
                                                </div>
                                                <div class="col-8 col-md-7">
                                                    <div class="numbers">
                                                        <p class="card-category">Planilla de Control</p>
                                                        <p class="card-title">

                                                        <form action="ImprimirServlet" method="post">
                                                            <input id="btnImprimir" type="submit" class="btn btn-danger" name="" value="Descargar">
                                                        </form>
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-footer ">
                                            <hr>
                                            <div class="stats">
                                                <i class="fa fa-download"></i> Descargar Planilla de Control de Inventario.
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>


                            <%--
                            <a class="btn btn-primary" onclick="PrintElem($('home'))">Imprimir</a>
                            <a href="listaDeSolicitudes?${pdfExportUrl}">Export as PDF</a>
                            --%>





                            <div class="row">
                                <div class="col-md-4">
                                    <div class="card ">
                                        <div class="card-header ">
                                            <h5 class="card-title">Solicitudes</h5>
                                            <p class="card-category">Cantidad de Solicitudes Realizadas</p>
                                        </div>
                                        <div class="card-body ">
                                            <canvas id="chartEmail"></canvas>
                                        </div>
                                        <div class="card-footer ">
                                            <div class="legend">
                                                <i class="fa fa-circle text-primary"></i> Cerradas
                                                <i class="fa fa-circle text-warning"></i> Propuestas
                                                <i class="fa fa-circle text-danger"></i> Abierta
                                                <i class="fa fa-circle text-gray"></i> Enviadas
                                            </div>
                                            <hr>
                                            <div class="stats">
                                                <i class="nc-icon nc-chat-33"></i> Solicitudes realizadas en Unidades
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="card card-chart">
                                        <div class="card-header">
                                            <h5 class="card-title">Productos</h5>
                                            <p class="card-category">Promedio de Ingreso en Productos</p>
                                        </div>
                                        <div class="card-body">
                                            <canvas id="myChart" ></canvas>
                                        </div>
                                        <div class="card-footer">
                                            <div class="chart-legend">
                                                <i class="fa fa-calendar text-danger"></i> Dias Promedio
                                            </div>
                                            <hr/>
                                            <div class="card-stats">
                                                <i class="fa fa-check"></i> Solicitar productos antes de la fecha
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="page-break"></div>


                            <%--
                            <div class="row">
                                <jsp:include page="pruebaPag.jsp" ></jsp:include>
                            </div>
                            --%>
                            <div class="row">
                                <jsp:include page="inventario.jsp" ></jsp:include>    
                                </div>

                            </div>

                            <div class="page-break"></div>

                            <div id="menu1" class="tab-pane fade">
                            <%--<h1>bodega.jsp</h1>--%>

                            <jsp:include page="bodega.jsp"></jsp:include>

                            </div>

                            <div class="page-break"></div>

                            <div id="menu2" class="tab-pane fade">
                            <%--<h1>ingresoproductos.jsp</h1>--%>

                            <jsp:include page="ingresoproductos.jsp" ></jsp:include>

                            </div>

                            <div class="page-break"></div>

                            <div id="menu3" class="tab-pane fade">
                            <%--<h1>solicitud.jsp</h1>--%>

                            <jsp:include page="solicitud.jsp" ></jsp:include>

                            </div>
                        </div>
                    </div>





                    <footer id="idFooter" class="footer footer-black  footer-white ">
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
                                        </script>, made with <i class="fa fa-heart heart"></i> by Creative Tim y Grupo1
                                    </span>
                                </div>
                            </div>
                        </div>
                    </footer>


                </div>
            </div>

            <!--   Core JS Files   -->


        <%--
<script src="assets/js/core/bootstrap.min.js"></script>
        --%>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        
        <script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!-- Chart JS -->
        <script src="assets/js/plugins/chartjs.min.js"></script>
        <!--  Notifications Plugin    -->
        <script src="assets/js/plugins/bootstrap-notify.js"></script>
        <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->

        <script src="assets/js/core/jquery.min.js"></script>
        <script src="assets/js/core/popper.min.js"></script>
        <script src="assets/js/paper-dashboard.min.js?v=2.0.0" type="text/javascript"></script>

        <%--
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        --%>        



        <script>

                                            ctx = document.getElementById('chartEmail').getContext("2d");
                                            myChart = new Chart(ctx, {
                                            type: 'pie',
                                                    data: {
                                                    labels: [
            <c:forEach var = "row" items = "${result.rows}">
                                                    '<c:out value = "${row.estado}"/>',
            </c:forEach>
                                                    ],
                                                            datasets: [{
                                                            label: "Soliitudes",
                                                                    pointRadius: 0,
                                                                    pointHoverRadius: 0,
                                                                    backgroundColor: [
                                                                            '#e3e3e3',
                                                                            '#4acccd',
                                                                            '#fcc468',
                                                                            '#ef8157'
                                                                    ],
                                                                    borderWidth: 0,
                                                                    data: [

            <c:forEach var = "row" items = "${result.rows}">
                                                                    '<c:out value = "${row.cantidad}"/>',
            </c:forEach>

                                                                    ]
                                                            }]
                                                    },
                                                    options: {
                                                    legend: {
                                                    display: false
                                                    },
                                                            pieceLabel: {
                                                            render: 'percentage',
                                                                    fontColor: ['white'],
                                                                    precision: 2
                                                            },
                                                            tooltips: {
                                                            enabled: false
                                                            },
                                                            scales: {
                                                            yAxes: [{
                                                            ticks: {
                                                            display: false
                                                            },
                                                                    gridLines: {
                                                                    drawBorder: false,
                                                                            zeroLineColor: "transparent",
                                                                            color: 'rgba(255,255,255,0.05)'
                                                                    }

                                                            }],
                                                                    xAxes: [{
                                                                    barPercentage: 1.6,
                                                                            gridLines: {
                                                                            drawBorder: false,
                                                                                    color: 'rgba(255,255,255,0.1)',
                                                                                    zeroLineColor: "transparent"
                                                                            },
                                                                            ticks: {
                                                                            display: false,
                                                                            }
                                                                    }]
                                                            },
                                                    }
                                            });
                                            var ctx = document.getElementById('myChart').getContext('2d');
                                            var myChart = new Chart(ctx, {
                                            type: 'bar',
                                                    data: {
                                                    labels: [
            <c:forEach var="item" items="${producto}">
                                                    '<c:out value = "${item[0]}"/>',
            </c:forEach>
                                                    ],
                                                            datasets: [{
                                                            label: 'Ingreso promedio en dias',
                                                                    data: [
            <c:forEach var="item" items="${producto}">
                <c:out value = "${item[1]}"/>,
            </c:forEach>
                                                                    ],
                                                                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
                                                                    borderColor: 'rgba(255, 99, 132, 1)',
                                                                    borderWidth: 1
                                                            }]
                                                    },
                                                    options: {
                                                    scales: {
                                                    yAxes: [{
                                                    ticks: {
                                                    beginAtZero: true
                                                    }
                                                    }]
                                                    }
                                                    }
                                            });
        </script>







        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/autofill/2.3.4/js/dataTables.autoFill.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.colVis.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.flash.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.print.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/colreorder/1.5.2/js/dataTables.colReorder.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/fixedcolumns/3.3.0/js/dataTables.fixedColumns.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/fixedheader/3.1.6/js/dataTables.fixedHeader.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/keytable/2.5.1/js/dataTables.keyTable.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/rowgroup/1.1.1/js/dataTables.rowGroup.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/rowreorder/1.2.6/js/dataTables.rowReorder.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/scroller/2.0.1/js/dataTables.scroller.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/select/1.3.1/js/dataTables.select.js"></script>
        <script>
                                            $(document).ready(function () {
                                            $('#tablaSolicitudes').DataTable({
                                            "language":
                                            {
                                            "url": "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Spanish.json"
                                            },
                                                    "lengthMenu": [ [3, 7, 10, - 1], [3, 7, 10, "Todo"] ],
                                                    "scrollY":        "800px",
                                                    "scrollCollapse": true,
                                            });
                                            });
        </script>


        <script language="javascript" type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.min.js"></script>
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/localization/messages_es.js"></script>

        <script>
                                            jQuery(function() {
                                            jQuery("#formIngresoProducto").validate({
                                            rules: {
                                            selectProducto: {
                                            required: "#txtIdProducto:checked",
                                            },
                                                    txtPesoModificar:{
                                                    required: true
                                                    }
                                            },
                                                    messages: {
                                                    selectProducto: {
                                                    required: "Seleccione el Producto",
                                                    },
                                                            txtPesoModificar:{
                                                            required: "No olvide ingresar la cantidad!",
                                                            }
                                                    }
                                            });
                                            });
        </script>





    </body>

</html>