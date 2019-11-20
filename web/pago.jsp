<%-- 
    Document   : pago
    Created on : 21-10-2019, 20:51:40
    Author     : Asus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pedido</title>
<jsp:include page="boleta"></jsp:include>
</head>
<body>
    <h1 class="jumbotron">
        Pago
    </h1>           
    <div class="col-sm-12">
        <div class="row">
            <div class="col-sm-12">
                <div class="col ">
                    <div class="container">
                        <form action="boleta" method="POST">
                            <table class="table table-striped">
                                <tr>
                                    <td>modo de pago</td>
                                    <td>
                                        <select name="cboModoP" class="form-control-plaintext " >
                                        <c:forEach var="x" items="${modop}">
                                            <option value="${x.id}" >${x.tipo}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <c:forEach var="item5" items="${n}">
                                <tr>
                                    <td>neto</td>
                                    <td>${item5[0]}</td>
                                </tr>
                                <tr>
                                    <td>iva</td>
                                    <td>${item5[1]}</td>
                                </tr>
                                <tr>
                                    <td>total</td>
                                    <td>${item5[2]}</td>
                                </tr>                          
                            </c:forEach>
                            </tr>
                            <tr>

                                <td><input type="submit" class="btn btn-default" name="btnAccion" value="pagar efectivo"></td>
                            </tr>
                            <tr>
                            <input type="submit" class="btn btn-info btn-lg" data-toggle="modal" value="transferencia" data-target="#myModal"></button>

                            </tr>
                        </table>    
                        <!-- Modal -->
                        <div class="modal fade" id="myModal" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Pagar por transferencia</h4>
                                        <p>ingresa tu usuario y contraseña para poder pagar con transferencia </p>
                                    </div>
                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-md-12 form-group">
                                                <label >rut</label>
                                                <input type="text" name="txtRut" oninput="checkRut(this)" required="" placeholder="19999245-5"  class="form-control ">
                                            </div>
                                            <div class="col-md-12 form-group">
                                                <label >nombre</label>
                                                <input type="password" name="txtPass" required="5" placeholder="juanito figueroa" class="form-control ">
                                            </div>
                                            <div class="col-md-12 form-group">
                                                <div class="col-md-12 form-group">
                                                    <input type="submit" value="transferir" name="btnAccion" class="btn btn-primary">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">salir</button>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
