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
            case "pagar":
                pagar(request, response);
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
//        int id = reservaFacade.ultimoId();
//        java.util.Date hoy = new Date();
//        Estado est = new Estado(1);
//        Cliente c = (Cliente) request.getSession().getAttribute("clientes");
//        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarios");
//        Mesa mesa = (Mesa) request.getSession().getAttribute("mesa");
//
//        //int id, String nombre, Date createdAt, Cliente clienteId, Estado estado, Mesa mesaId, Usuario usuario
//        Reserva reserva = new Reserva(id, c.getNombre(), hoy, c, est, mesa, usuario);
//        try {
//            reservaFacade.create(reserva);
//            request.getSession().setAttribute("rese", reserva);
//            int idB = boletaFacade.ultimoId();
//            ModoPago pago = new ModoPago(1);
//            EstadoBoleta eb = new EstadoBoleta(1);
//            Boleta boleta = new Boleta(idB, hoy, 0, eb, pago);
//            request.getSession().setAttribute("boleta", boleta);
//            boletaFacade.create(boleta);
//            response.sendRedirect("pedido.jsp");
//            //request.getRequestDispatcher("agregarPedido.jsp").forward(request, response);
//        } catch (IOException e) {
//            response.sendRedirect("mesa.jsp");
//        }
    }

    private void pedir(HttpServletRequest request, HttpServletResponse response) throws IOException {
       int pedidoId= pedidoFacade.ultimoId();
       java.util.Date hoy = new  Date();
       Boleta b = (Boleta)request.getSession().getAttribute("boletas");
       Boleta boleta = boletaFacade.find(b.getId());
       Estado estado = new Estado(1);
       int m= Integer.parseInt(request.getParameter("cboMenu"));
       Menu menu =new Menu(m);
       Reserva r = (Reserva)request.getSession().getAttribute("reserva");
       Reserva reserva = reservaFacade.find(r.getId());
       Pedido pedido = new Pedido(pedidoId, hoy, boleta, estado, menu, reserva);
       
        try {
       pedidoFacade.create(pedido);
       response.sendRedirect("Pedodo.jsp");
        } catch (Exception e) {
            request.getSession().setAttribute("Error", "Error al ingresar pedido");
        }
       
       
       //int id, Date createdAt, Boleta boletaId, Estado estadoId, Menu menuId, Reserva reservaId        
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("menus", menuFacade.findAll());
     //   Reserva reserva=(Reserva)request.getSession().getAttribute("reserva");
     //   Reserva r=reservaFacade.find(reserva.getId());
     //   request.getSession().setAttribute("carrito", pedidoFacade.carrito(r.getId()));
      //  request.getSession().setAttribute("val", pedidoFacade.valores(r.getId()));
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

    private void pagar(HttpServletRequest request, HttpServletResponse response) {

        Boleta boleta = (Boleta) request.getSession().getAttribute("boleta");
        Boleta b = boletaFacade.find(boleta.getId());
        java.util.Date hoy = new Date();
        Reserva reserva = (Reserva) request.getSession().getAttribute("reserva");
        Reserva r = reservaFacade.find(reserva.getId());
        int total = boletaFacade.total(r.getId());
        EstadoBoleta estadoBoleta=b.getEstadoId();
        ModoPago mp = new ModoPago();
        //  nt id, Date createdAt, int total, EstadoBoleta estadoId, ModoPago modoPagoId
        Boleta bo = new Boleta(b.getId(), hoy, total, estadoBoleta, mp);
        boletaFacade.edit(bo);

    }

}
