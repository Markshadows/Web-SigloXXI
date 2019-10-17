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

        //DATOS CLIENTE
        //
        int id = clienteFacade.ultimoId();
        String rut = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre");
        Estado est = new Estado(1);
        Cliente cliente = new Cliente(id, rut, nombre, est);
        Cliente test = clienteFacade.existe(rut);
        //RESERVA DATOS
        //
        int idReserva = reservaFacade.ultimoId();
        java.util.Date hoy = new Date();
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarios");
        Usuario usuarioGuardado = usuarioFacade.find(usuario.getId());
        Mesa mesa = (Mesa) request.getSession().getAttribute("mesa");
        Mesa mesese = mesaFacade.find(mesa.getId());
        //  Mesa mesa2 = new Mesa(1);
        //
        int idBoleta = boletaFacade.ultimoId();
        ModoPago pago = new ModoPago(1);
        EstadoBoleta eb = new EstadoBoleta(1);
        ///se declaran las variables a nivel metodo se pregunta si el cliente existe
        try {
            if (test == null) {
                //si el cliente no existe se genera uno nuevo 
                clienteFacade.create(cliente);
                request.getSession().setAttribute("clientes", cliente);
                //int id, String nombre, Date createdAt, Cliente clienteId, Estado estado, Mesa mesaId, Usuario usuario
                Reserva reserva = new Reserva(idReserva, nombre, hoy, cliente, est, mesese, usuarioGuardado);
                reservaFacade.create(reserva);
                //(int id, Date createdAt, int total, EstadoBoleta estadoId, ModoPago modoPagoId
                request.getSession().setAttribute("rese", reserva);
                Boleta boleta = new Boleta(idBoleta, hoy, 0, eb, pago);
                boletaFacade.create(boleta);
                request.getSession().setAttribute("boleta", boleta);

                response.sendRedirect("pedido.jsp");
            } else {
                //si el cliente existe se busca y se almacena por sesiones 
                request.getSession().setAttribute("clientes", test);
                Reserva reserva = new Reserva(idReserva, nombre, hoy, test, est, mesese, usuario);
                reservaFacade.create(reserva);
                //(int id, Date createdAt, int total, EstadoBoleta estadoId, ModoPago modoPagoId
                Boleta boleta = new Boleta(idBoleta, hoy, 0, eb, pago);
                boletaFacade.create(boleta);
                request.getSession().setAttribute("boleta", boleta);
                response.sendRedirect("pedido.jsp");
            }

        } catch (IOException ex) {
            response.sendRedirect("cliente.jsp");
        }

    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
