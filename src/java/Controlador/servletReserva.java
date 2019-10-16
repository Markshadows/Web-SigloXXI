/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.BoletaFacade;
import dao.MenuFacade;
import dao.MesaFacade;
import dao.PedidoFacade;
import dao.ReservaFacade;
import dto.Boleta;
import dto.Cliente;
import dto.Estado;
import dto.EstadoBoleta;
import dto.Menu;
import dto.Mesa;
import dto.ModoPago;
import dto.Pedido;
import dto.Reserva;
import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
public class servletReserva extends HttpServlet {

    @EJB
    private MesaFacade mesaFacade;

    @EJB
    private MenuFacade menuFacade;

    @EJB
    private BoletaFacade boletaFacade;

    @EJB
    private ReservaFacade reservaFacade;

    @EJB
    private PedidoFacade pedidoFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("btnAccion");

        opcion = opcion != null ? opcion : "";
        switch (opcion) {
            case "ingresar":
                ingresar(request, response);
                break;
            case "pedir":
                pedir(request, response);
                break;
            case "mesa":
                mesa(request, response);
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
        int id = reservaFacade.ultimoId();
        java.util.Date hoy = new Date();
        Estado est = new Estado(1);
        Cliente c = (Cliente) request.getSession().getAttribute("clientes");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarios");
        Mesa mesa = (Mesa) request.getSession().getAttribute("mesa");
        

        //int id, String nombre, Date createdAt, Cliente clienteId, Estado estado, Mesa mesaId, Usuario usuario
        Reserva reserva = new Reserva(id, c.getNombre(), hoy, c, est, mesa, usuario);
        try {
            reservaFacade.create(reserva);
            request.getSession().setAttribute("reserva", reserva);
            int idB = boletaFacade.ultimoId();
            ModoPago pago = new ModoPago(1);
            EstadoBoleta eb = new EstadoBoleta(1);
            Boleta boleta = new Boleta(idB, hoy, 0, eb, pago);
            request.getSession().setAttribute("boleta", boleta);
            boletaFacade.create(boleta);
            response.sendRedirect("pedido.jsp");
            //request.getRequestDispatcher("agregarPedido.jsp").forward(request, response);
        } catch (IOException e) {
            response.sendRedirect("mesa.jsp");
        }
    }

    private void pedir(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = pedidoFacade.ultimoId();
        java.util.Date hoy = new Date();
        Boleta boleta = (Boleta) request.getSession().getAttribute("boleta");
        Boleta b =boletaFacade.find(boleta.getId());
        Reserva reserva = (Reserva) request.getSession().getAttribute("reserva");
        Reserva r = reservaFacade.find(reserva.getId());
        Estado estado = new Estado(2);
        int menu = Integer.parseInt(request.getParameter("cboMenu"));
        Menu m = new Menu(menu);
        //nt id, Date createdAt, Boleta boletaId, Estado estadoId, Menu menuId, Reserva reservaId)
        Pedido pedido = new Pedido(id, hoy, b, estado, m, r);
        try {
            pedidoFacade.create(pedido);
            response.sendRedirect("pedido.jsp");
        } catch (Exception e) {
        
            response.sendRedirect("pedido.jsp");
            
        }

    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("menus", menuFacade.findAll());
        request.getSession().setAttribute("carrito", pedidoFacade.carrito(1));
        request.getSession().setAttribute("val", pedidoFacade.valores(1));
        request.getSession().setAttribute("me", mesaFacade.mesahabilitada());

    }

    private void mesa(HttpServletRequest request, HttpServletResponse response) {
        int me = Integer.parseInt(request.getParameter("cboMesa"));
        Mesa mesa = mesaFacade.find(me);
        request.getSession().setAttribute("mesa", mesa);
        try {
            response.sendRedirect("cliente.jsp");
        } catch (Exception e) {
        }

    }

}
