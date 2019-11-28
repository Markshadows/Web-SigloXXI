<%-- 
    Document   : ingresoproductos
    Created on : 14-10-2019, 17:53:40
    Author     : Betta
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/BodegaServlet" />


        <%--
        <div class="col-md-4">
            <div class="card card-user">
              
              <div class="card-body">
                <div class="author">
                
                    <h5 class="title">Chet Faker</h5>
                  <p class="description">
                    @chetfaker
                  </p>
                </div>
                <p class="description text-center">
                  "I like the way you work it
                  <br> No diggity
                  <br> I wanna bag it up"
                </p>
              </div>
              <div class="card-footer">
                <hr>
                <div class="button-container">
                  <div class="row">
                    <div class="col-lg-3 col-md-6 col-6 ml-auto">
                      <h5>12
                        <br>
                        <small>Files</small>
                      </h5>
                    </div>
                    <div class="col-lg-4 col-md-6 col-6 ml-auto mr-auto">
                      <h5>2GB
                        <br>
                        <small>Used</small>
                      </h5>
                    </div>
                    <div class="col-lg-3 mr-auto">
                      <h5>24,6$
                        <br>
                        <small>Spent</small>
                      </h5>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>


          <div class="col-md-8">
            <div class="card card-user">
              <div class="card-header">
                <h5 class="card-title">Edit Profile</h5>
              </div>
              <div class="card-body">
                <form>
                  
                  
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control" placeholder="Home Address" value="Melbourne, Australia">
                      </div>
                    </div>
                  </div>
                 
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>About Me</label>
                        <textarea class="form-control textarea">Oh so, your weak rhyme You doubt I'll bother, reading into it</textarea>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="update ml-auto mr-auto">
                      <button type="submit" class="btn btn-primary btn-round">Update Profile</button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        --%>


        <div class="card card-nav-tabs text-center">
            <div class="card-header card-header-primary">
                Recepcion de Insumos
            </div>
            <div class="card-body">
                <h4 class="card-title">Ingreso de Productos</h4>
                <p class="card-text">Seleccione el producto y luego la cantidad a ingresar</p>


                <form action="BodegaServlet"  id="formIngresoProducto" method="POST">
                    <div class="form-row">
                        <div class="col">

                            <div class="form-group has-label">
                                <label>
                                    Seleccion de Producto
                                </label>
                                <select required="true" name="selectProducto" class="btn btn-outline-danger btn-round btn-lg" name="txtIdProducto">
                                    <option value="" class="form-control">Seleccione...</option>
                                    <c:forEach var="item" items="${listaDeProductos}">
                                        <option class="form-control" value="${item.id}">${item.nombre}</option>
                                        <c:set var="idpro" value="${item.id}"/>
                                    </c:forEach>
                                </select>
                            </div>


                        </div>
                        <div class="col">

                            <div class="form-group has-label">
                                <label>
                                    Cantidad a Ingresar
                                </label>
                                <input required="true" min="1" type="number" class="form-control"  placeholder="Ingreso de cantidad" name="txtPesoModificar" placeholder="Cantidad a ingresar" >
                            </div>

                            <input type="submit" style="" class="btn btn-outline-primary btn-round btn-lg" name="btnAccion"  value="RegistrarIngreso" >

                        </div>
                    </div>
                </form>




            </div>
            <div class="card-footer text-muted">
                formulario validado
            </div>
        </div>





    </body>
</html>
