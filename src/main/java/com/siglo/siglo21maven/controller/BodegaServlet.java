package com.siglo.siglo21maven.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ejb.EJB;

import com.siglo.siglo21maven.dao.*;
import com.siglo.siglo21maven.dto.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BodegaServlet extends HttpServlet {

    @EJB
    private IngresoFacade ingresoFacade;

    @EJB
    private MetricaFacade metricaFacade;

    @EJB
    private EstadoSolicitudFacade estadoSolicitudFacade;

    @EJB
    private ProductoSolicitudFacade productoSolicitudFacade;

    @EJB
    private SolicitudFacade solicitudFacade;

    @EJB
    ProductoFacade productoFacade;

    @EJB
    private UsuarioFacade usuarioFacade;

    @EJB
    private ProveedorFacade proveedorFacade;

    Producto pro;
    Metrica met;
    Proveedor proveedor;

    private String mensaje = null;
    private String errors = null;
    private String paginaRetorno = "bodega.jsp";
    private Object objeto = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String opcion = request.getParameter("btnAccion");

            if (opcion.equals("RegistrarIngreso")) {
                RegistrarIngreso(request, response);
            }

            if (opcion.equals("EditarProducto")) {
                modificarIngreso(request, response);
            }

            if (opcion.equals("Enviar")) {
                SolicitarInsumoPersistencia(request, response);
            }
            //Cargar(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Cargar(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void RegistrarIngreso(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            int peso = Integer.parseInt(request.getParameter("txtPeso"));
            String Medida = request.getParameter("txtMedida");
            String Codigo = request.getParameter("txtCodigo");
            String nombre = request.getParameter("txtNombre");
           

            int idProveedor = Integer.parseInt(request.getParameter("txtIdProveedor"));

            int idUsuario = Integer.parseInt(request.getParameter("txtIdUsuario"));

            if (productoFacade.IngresarProducto(peso, Medida, Codigo, nombre, idProveedor, idUsuario)) {
                mensaje = "El producto ha sido Registrado";
                request.getSession().setAttribute("mensaje", mensaje);

            } else {
                errors = "El producto ha sido Registrado";
                request.getSession().setAttribute("errors", errors);
                response.sendRedirect(paginaRetorno);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void modificarIngreso(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {

            pro = new Producto();
            met = new Metrica();
            proveedor = new Proveedor();
            //List<String> errores = new ArrayList<>();

          
            
            short idProducto = Short.parseShort(request.getParameter("txtIdProductoModificar"));
            System.out.println("id del producto: "+idProducto);
            String Codigo = request.getParameter("txtCodigoModificar"+idProducto);
            System.out.println("codigo del producto : "+Codigo);
            String nombre = request.getParameter("txtNombreModificar"+idProducto);
            System.out.println("Nombre de producto: "+nombre);
  
            BigDecimal idProveedor = BigDecimal.valueOf(Long.parseLong(request.getParameter("txtProveedorModificar"+idProducto)));
            System.out.println("id del proveedor: "+idProveedor);
            
            BigDecimal idmetrica = BigDecimal.valueOf(Long.parseLong(request.getParameter("txtIdModificar"+idProducto)));
            System.out.println("id de la metrica : "+request.getParameter("txtIdModificar"));
            
            BigInteger peso = BigInteger.valueOf(Long.parseLong(request.getParameter("txtPesoModificar"+idProducto)));
            System.out.println("Pseso de la metrica"+peso);
            
            String Medida = request.getParameter("txtMedidaModificar"+idProducto);
            System.out.println("medida modificar"+Medida);
            
            
            ///recien aqui empoesa
            pro = productoFacade.find(idProducto);
            met = metricaFacade.find(idmetrica);
            proveedor = proveedorFacade.find(idProveedor);

            System.out.println("nombre proveedor encontrado"+ proveedor.getNombre());
            
            pro.setCodigo(Codigo);
            pro.setNombre(nombre);
            pro.setProveedorId(proveedor);

            met.setPeso(peso);
            met.setMedida(Medida);

            System.out.println("id del producto encontrado"+pro.getId());
            System.out.println("id de la metrica encontrada"+met.getId());
            
            productoFacade.edit(pro);
            System.out.println("producto editado");
            metricaFacade.edit(met);
            System.out.println("metrica editada");

            mensaje = "Producto Editado";
            request.getSession().setAttribute("mensaje", mensaje);

            paginaRetorno = "bodega.jsp";
            response.sendRedirect(paginaRetorno);

        } catch (Exception e) {
            System.out.println("error al modificar servlet " + e.getMessage());
            
        }
    }

    private void Cargar(HttpServletRequest request, HttpServletResponse response) {

        request.getSession().setAttribute("listaDeUsuario", usuarioFacade.findAll());
        request.getSession().setAttribute("listaDeProveedor", proveedorFacade.findAll());
        request.getSession().setAttribute("listaDeProductos", productoFacade.findAll());
        request.getSession().setAttribute("listaDeSolicitudes", solicitudFacade.findAll());
        
        request.getSession().setAttribute("listaDeIngresos",ingresoFacade.findAll());
        
//        try {
//            response.sendRedirect(paginaRetorno);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }

    }

    private void SolicitarInsumoPersistencia(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            
            String asunto = request.getParameter("txtAsunto");
            String mensaje = request.getParameter("txtMensaje");
            String[] idProductos = (request.getParameterValues("idProducto"));
            
            //lista para que cda producto ingrresado se transforma a un producto
            List<Producto> productos = new ArrayList<>();
            
            
            EstadoSolicitud es = estadoSolicitudFacade.find(Short.parseShort("1"));
            System.out.println("estado de solicitud existente : "+es);
            
            //short usi = Short.parseShort( String.valueOf( solicitudFacade.ultimaSolicitudInsert()));
            short usi =  (short) solicitudFacade.ultimaSolicitudInsert();
            System.out.println("valor de la variable para dar el id de la nueva solicitud: "+usi);
            //(short)solicitudFacade.ultimaSolicitudInsert()
            
            Solicitud s = new Solicitud( usi , asunto, mensaje, es);
            System.out.println("id de la nueva solicicitud : "+s.getIdSolicitud());
            solicitudFacade.create(s);
            System.out.println("********se creo la solicitud*******");

            //tener el id de esa ultima solicitud 
            short idsolicitudfinal = (short) solicitudFacade.ultimaSolicitud();
            System.out.println("Id de la solicitud final "+ idsolicitudfinal);
            
            // se forma la ultima solicitud 
            Solicitud solicitudFinal = solicitudFacade.find(idsolicitudfinal);
            System.out.println("id de la solicitud final ");

            for (String item : idProductos) {
               productos.add(productoFacade.find(Short.parseShort(item)));
            }

            for (int i = 0; i < productos.size(); i++) {
                
                short producsolitu = Short.parseShort(String.valueOf(productoSolicitudFacade.ultimaProductoSolicitudInsert()));
                
                ProductoSolicitud solicitudporproducto = new ProductoSolicitud( producsolitu , productos.get(i), solicitudFinal);
                productoSolicitudFacade.create(solicitudporproducto);

            }

            mensaje = "Solicitud Enviada";
            request.getSession().setAttribute("mensaje", mensaje);
            paginaRetorno = "solicitud.jsp";
            Cargar(request, response);
            response.sendRedirect(paginaRetorno);

        } catch (Exception e) {

            System.out.println("/////****** error complila plis" + e.getMessage());
        }

    }

}


