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

            case "pedir":
                pedir(request, response);
                break;
            case "pago":
                pago(request, response);
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

    private void pedir(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pedidoId = pedidoFacade.ultimoId();
        java.util.Date hoy = new Date();
        Boleta b = (Boleta) request.getSession().getAttribute("boletas");
        Boleta boleta = boletaFacade.find(b.getId());
        Estado estado = new Estado(3);
        int m = Integer.parseInt(request.getParameter("cboMenu"));
        Menu menu = new Menu(m);
        Reserva r = (Reserva) request.getSession().getAttribute("reserva");
        Reserva reserva = reservaFacade.find(r.getId());
        Pedido pedido = new Pedido(pedidoId, hoy, boleta, estado, menu, reserva);

        try {
            pedidoFacade.create(pedido);
            request.getSession().setAttribute("carrito", pedidoFacade.carrito(reserva.getId()));
            request.getSession().setAttribute("valor", pedidoFacade.valores(reserva.getId()));
            response.sendRedirect("pedido.jsp");
        } catch (Exception e) {
            request.getSession().setAttribute("pedido", "Error al ingresar pedido");
            response.sendRedirect("pedido.jsp");
        }

        //int id, Date createdAt, Boleta boletaId, Estado estadoId, Menu menuId, Reserva reservaId        
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("menus", menuFacade.findAll());
        request.getSession().setAttribute("me", mesaFacade.mesahabilitada());

    }

    private void mesa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int me = Integer.parseInt(request.getParameter("cboMesa"));
        Mesa mes = mesaFacade.find(me);
        Estado e = new Estado(2);
        Mesa mesa = new Mesa(me, mes.getNumero(), mes.getSillas(), e);
        mesaFacade.edit(mesa);
        request.getSession().setAttribute("mesa", mesa);

        response.sendRedirect("cliente.jsp");

    }

    private void pago(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("pago.jsp");
    }

}
