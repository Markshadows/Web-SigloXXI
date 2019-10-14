/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import dao.UsuarioFacade;
import dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
public class servletLogin extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;



  
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        HttpSession sesion = request.getSession();
//        sesion.invalidate();
        //response.sendRedirect("index.jsp");

        String opcion = request.getParameter("btnAccion");

        if (opcion.equals("ingresar")) {
            ingresar(request, response);
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

    private void ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException  {
            //   HttpSession sesion = request.getSession();
        String user = request.getParameter("txtCorreo");
        String pass = request.getParameter("txtPass");

        Usuario usu = usuarioFacade.IniciarSesion(user, pass);
        request.getSession().setAttribute("usuarios", usu);
//
        switch (usu.getRolId().getId()) {
            case 1:
                response.sendRedirect("administrador.jsp");
            
                break;
            case 3:
                response.sendRedirect("mesa.jsp");
                break;
            case 6:
                response.sendRedirect("reservas.jsp");
                break;
            default:
                request.getRequestDispatcher("login.jsp");
                request.setAttribute("error", "no ingreso");
                break;
        }
    }

}
