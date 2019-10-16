<%-- 
    Document   : pedido
    Created on : 08-10-2019, 0:19:35
    Author     : Asus
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pedido</title>
<!--
<jsp:include page="Reserva"></jsp:include>
    -->
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
                        <form action="reserva" method="POST">
                            <table class="table table-striped">
                                <tr>
                                    <td>menu</td>
                                    <td>
                                        <select name="cboMenu" class="form-control-plaintext " >
                                        <c:forEach var="item" items="${menus}">
                                            <option value="${item.id}" >${item.nombre} ${item.precio}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><input type="submit" name="btnAccion" value="pedir"></td>
                                <td></td>
                            </tr>

                        </table>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <table class="table table-striped">

                <!--
                            
                -->
                <tr>
                    <td><input type="submit" name="btnAccion" value="pedir"></td>
                    <td></td>
                </tr>

            </table>
        </div>
    </div>

</div>













<%@include file="footer.jsp" %>
</body>
</html>
