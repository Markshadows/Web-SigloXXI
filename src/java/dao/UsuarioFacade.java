/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Asus
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "web_siglo_xxiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario IniciarSesion(String user, String pass) {
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.correo = '" + user + "' AND u.password = '" + pass + "'");
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("error iniciar sesion: " + e.getMessage());
            return null;
        }
    }
    
    
    

}
