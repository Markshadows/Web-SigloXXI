<%-- 
    Document   : pago
    Created on : 21-10-2019, 20:51:40
    Author     : Asus
--%>

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

<jsp:include page="boleta"></jsp:include>

</head>
<body>
    <h1 class="jumbotron">
        Pago
    </h1>           
    <div class="col-sm-12">

        <div class="row">
            <div class="col-sm-3">
                <div class="col ">
                    <div class="container">
                        <form action="boleta" method="POST">
                            <table class="table table-striped">
                                <tr>
                                    <td>menu</td>
                                    <td>
                                        <select name="cboMenu" class="form-control-plaintext " >

                                        </select>
                                    </td>
                                </tr>
                            <c:forEach var="item5" items="${n}">
                                <tr>
                                    <td>neto</td>
                                    <td>${item5[0]}</td>
                                </tr>
                                <tr>
                                    <td>total</td>
                                    <td>${item5[2]}</td>
                                </tr>
                                <tr>
                                    <td>iva</td>
                                    <td>${item5[1]}</td>
                                </tr>


                            </c:forEach>
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
    </div>
</div>








<%@include file="footer.jsp" %>
</body>
</html>
