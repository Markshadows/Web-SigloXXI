/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Asus
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "web_siglo_xxiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public int ultimoId() {
        try {
            Query query = em.createQuery("SELECT MAX(c.id)+1 FROM Cliente c");
            return (int) query.getSingleResult();
        } catch (Exception e) {
            return 0;
        }

    }

    public Cliente existe(String rut) {
        try {
            Query q = em.createQuery("SELECT C FROM Cliente C WHERE c.rut='" + rut + "'");
            return (Cliente) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

}
