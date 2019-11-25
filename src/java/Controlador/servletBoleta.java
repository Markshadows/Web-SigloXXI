/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.BoletaFacade;
import dao.MesaFacade;
import dao.ModoPagoFacade;
import dao.PedidoFacade;
import dao.ReservaFacade;
import dto.Boleta;
import dto.Estado;
import dto.EstadoBoleta;
import dto.Mesa;
import dto.ModoPago;
import dto.Reserva;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ws.Service1;
import ws.Service1_Service;

/**
 *
 * @author Asus
 */
public class servletBoleta extends HttpServlet {

    @EJB
    private MesaFacade mesaFacade;

    @EJB
    private BoletaFacade boletaFacade;

    @EJB
    private PedidoFacade pedidoFacade;

    @EJB
    private ModoPagoFacade modoPagoFacade;

    @EJB
    private ReservaFacade reservaFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("btnAccion");

        opcion = opcion != null ? opcion : "";
        switch (opcion) {
            case "pagar":
                pagar(request, response);
                break;
            case "transferir":
                transferir(request, response);
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

    private void pagar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Service1_Service servicio = new Service1_Service();
        Service1 cliente = servicio.getService1Port();
        ModoPago mp = new ModoPago(1);
        Boleta boleta = (Boleta) request.getSession().getAttribute("boletas");
        Reserva reserva = (Reserva) request.getSession().getAttribute("reserva");
        int total = boletaFacade.total(reserva.getId());
        EstadoBoleta estadoBoleta = new EstadoBoleta(1);
        Boleta bfinal = new Boleta(boleta.getId(), boleta.getCreatedAt(), total, estadoBoleta, mp);
        boletaFacade.edit(bfinal);
        Mesa m = (Mesa) request.getSession().getAttribute("mesa");
        Estado e = new Estado(1);
        Mesa me = new Mesa(m.getId(), m.getNumero(), m.getSillas(), e);
        mesaFacade.edit(me);
        int resp = cliente.wssii(reserva.getId());
        if (resp == 1) {
            request.getSession().setAttribute("bol", "boleta pagada");
        }
//            Boleta boleta = (Boleta) request.getSession().getAttribute("boletas");
//            Reserva reserva = (Reserva) request.getSession().getAttribute("reserva");
//            int total = boletaFacade.total(reserva.getId());
//            EstadoBoleta estadoBoleta = new EstadoBoleta(1);
//            Boleta bfinal = new Boleta(boleta.getId(), boleta.getCreatedAt(), total, estadoBoleta, mp);
//            boletaFacade.edit(bfinal);
//            Mesa m = (Mesa) request.getSession().getAttribute("mesa");
//            Estado e = new Estado(1);
//            Mesa me = new Mesa(m.getId(), m.getNumero(), m.getSillas(), e);
//            mesaFacade.edit(me);

        response.sendRedirect("cliente.jsp");
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        Reserva r = (Reserva) request.getSession().getAttribute("reserva");
        Reserva reserva = reservaFacade.find(r.getId());
        request.getSession().setAttribute("n", pedidoFacade.valores(reserva.getId()));
        request.getSession().setAttribute("modop", modoPagoFacade.findAll());
    }

    private void transferir(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Service1_Service servicio = new Service1_Service();
        Service1 cliente = servicio.getService1Port();
        String run=request.getParameter("txtRut");
        String pass=request.getParameter("txtPass");
        ModoPago mp = new ModoPago(2);
        Boleta boleta = (Boleta) request.getSession().getAttribute("boletas");
        Reserva reserva = (Reserva) request.getSession().getAttribute("reserva");
        int total = boletaFacade.total(reserva.getId());
        EstadoBoleta estadoBoleta = new EstadoBoleta(1);
        Boleta bfinal = new Boleta(boleta.getId(), boleta.getCreatedAt(), total, estadoBoleta, mp);
        boletaFacade.edit(bfinal);
        Mesa m = (Mesa) request.getSession().getAttribute("mesa");
        Estado e = new Estado(1);
        Mesa me = new Mesa(m.getId(), m.getNumero(), m.getSillas(), e);
        mesaFacade.edit(me);
        int sii = cliente.wStransferencia(run, pass, total);
        int resp = cliente.wssii(reserva.getId());
        if (resp == 1) {
            request.getSession().setAttribute("bol", "boleta pagada");
            request.getSession().setAttribute("nonto",sii);
        }
         response.sendRedirect("cliente.jsp");
    }

}
