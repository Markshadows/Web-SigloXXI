/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.BoletaFacade;
import dao.ClienteFacade;
import dao.MesaFacade;
import dao.ReservaFacade;
import dao.UsuarioFacade;
import dto.Boleta;
import dto.Cliente;
import dto.Estado;
import dto.EstadoBoleta;
import dto.Mesa;
import dto.ModoPago;
import dto.Reserva;
import dto.Usuario;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class servletCliente extends HttpServlet {

    @EJB
    private MesaFacade mesaFacade;

    @EJB
    private UsuarioFacade usuarioFacade;

    @EJB
    private BoletaFacade boletaFacade;

    @EJB
    private ReservaFacade reservaFacade;

    @EJB
    private ClienteFacade clienteFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("btnAccion");

        opcion = opcion != null ? opcion : "";
        switch (opcion) {
            case "ingresar":
                ingresar(request, response);
                break;

            default:
                listar(request, response);
                break;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException {
//ingresar datos clientes 
        int clienteID = clienteFacade.ultimoId();
        String rut = request.getParameter("txtRut");
        String Nombre = request.getParameter("txtNombre");
        Estado estado = new Estado(1);
        try {
            Cliente test = clienteFacade.existe(rut);
            if (test == null) {
                Cliente cliente = new Cliente(clienteID, rut, Nombre, estado);
                clienteFacade.create(cliente);
                request.getSession().setAttribute("clientes", cliente);
                int reservaID = reservaFacade.ultimoId();
                java.util.Date hoy = new Date();
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuarios");
                Usuario usu = usuarioFacade.find(usuario.getId());
                Mesa mesa = (Mesa) request.getSession().getAttribute("mesa");
                Mesa me = mesaFacade.find(mesa.getId());
                Reserva reserva = new Reserva(reservaID, cliente.getNombre(), hoy, cliente, estado, me, usu);
                        
                reservaFacade.create(reserva);
                request.getSession().setAttribute("reserva", reserva);
                //int id, Date createdAt, int total, EstadoBoleta estadoId, ModoPago modoPagoId
                int boletaID = boletaFacade.ultimoId();
                int total = 0;
                EstadoBoleta estadoboleta = new EstadoBoleta(2);
                ModoPago modopago = new ModoPago(1);
                Boleta boleta = new Boleta(boletaID, hoy, total, estadoboleta, modopago);
                boletaFacade.create(boleta);
                request.getSession().setAttribute("boletas", boleta);
                response.sendRedirect("pedido.jsp");
            } else {
                request.getSession().setAttribute("clientes", test);
                int reservaID = reservaFacade.ultimoId();
                java.util.Date hoy = new Date();
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuarios");
                Usuario usu = usuarioFacade.find(usuario.getId());
                Mesa mesa = (Mesa) request.getSession().getAttribute("mesa");
                Mesa me = mesaFacade.find(mesa.getId());
                Estado est = new Estado(1);
                Reserva reserva = new Reserva(reservaID, test.getNombre(), hoy, test, est, me, usu);
                reservaFacade.create(reserva);
                request.getSession().setAttribute("reserva", reserva);
                //int id, Date createdAt, int total, EstadoBoleta estadoId, ModoPago modoPagoId
                int boletaID = boletaFacade.ultimoId();
                int total = 0;
                EstadoBoleta estadoboleta = new EstadoBoleta(2);
                ModoPago modopago = new ModoPago(1);
                Boleta boleta = new Boleta(boletaID, hoy, total, estadoboleta, modopago);
                boletaFacade.create(boleta);
                request.getSession().setAttribute("boletas", boleta);
                response.sendRedirect("pedido.jsp");

            }
        } catch (Exception e) {
            request.getSession().setAttribute("cerror","no se pudo registrar");
            response.sendRedirect("cliente.jsp");
        }

    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
