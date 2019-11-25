<%-- 
    Document   : pedido
    Created on : 08-10-2019, 0:19:35
    Author     : Asus
--%>
<% 
 HttpSession se = request.getSession();
 se.removeAttribute("cerror");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pedido</title>

<jsp:include page="Reserva"></jsp:include>

</head>
<body>
    <h1 class="jumbotron">
        pedido
    </h1>           
    <div class="col-sm-12">

        <div class="row">
            <div class="col-sm-3">
                <div class="col ">
                    <div class="container">
                        <form action="Reserva" method="POST">
                            <table class="table table-striped">
                                <tr>
                                    <td>menu</td>
                                    <td>
                                        <select name="cboMenu" class="form-control-plaintext " >
                                        <c:forEach var="item" items="${menus}">
                                            <option value="${item.id}" >${item.nombre} ${item.precio}    <img src="img/${item.url}" alt=""/> </option>

                                        </c:forEach>
                                        -
                                </td>
                            </tr>
                            <tr>
                                <td><input type="submit" name="btnAccion" value="pedir"></td>
                                <td><input type="submit" name="btnAccion" value="pago"></td>
                            </tr>

                        </table>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="col ">
                <div class="container">

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>nombre</th>
                                <th>estado</th>
                                <th>precio</th>
                            </tr>
                        </thead>
                        <c:forEach var="item2" items="${carrito}">
                            <tbody>
                                <tr>
                                    <td>${item2[0]}</td>
                                    <td>${item2[1]}</td>
                                    <td>${item2[2]}</td>
                                    <td>
                                        <img src="img/${item2[3]}" alt=""/>
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>

                    <div class="jumbotron">
                        ${rese.getNombre()}
                        ${clientes.getNombre()}
                    </div>

                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="col ">
                <div class="container">
                    <table class="table table-striped">

                        <c:forEach var="item3" items="${valor}">
                            <tr>
                                <td>neto</td>
                                <td>${item3[0]}</td>
                            </tr>

                            <tr>
                                <td>iva</td>
                                <td>${item3[1]}</td>
                            </tr>
                            <tr>
                                <td>total</td>
                                <td>${item3[2]}</td>
                            </tr>

                        </table>
                    </c:forEach>


                </div>
            </div>
        </div>

    </div>

</div>




</body>
<%@include file="footer.jsp" %>
</html>
