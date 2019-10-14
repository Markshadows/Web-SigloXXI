/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Boleta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Asus
 */
@Stateless
public class BoletaFacade extends AbstractFacade<Boleta> {

    @PersistenceContext(unitName = "web_siglo_xxiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BoletaFacade() {
        super(Boleta.class);
    }
    
     public int ultimoId() {
        Query query = em.createQuery("SELECT MAX(b.id)+1 FROM Boleta b");
        return (int) query.getSingleResult();
    }
}
