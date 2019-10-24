/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.BoletaFacade;
import dao.ModoPagoFacade;
import dao.PedidoFacade;
import dao.ReservaFacade;
import dto.Boleta;
import dto.ModoPago;
import dto.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class servletBoleta extends HttpServlet {

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
            case "ingresar":
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

    private void pagar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
    Reserva r = (Reserva)request.getSession().getAttribute("reserva");
    Reserva reserva = reservaFacade.find(r.getId());
    request.getSession().setAttribute("n",pedidoFacade.valores(reserva.getId()));
    Boleta b = (Boleta)request.getSession().getAttribute("boletas");
    request.getSession().setAttribute("modop", modoPagoFacade.findAll());
    }

}
