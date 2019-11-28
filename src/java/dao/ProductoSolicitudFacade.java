/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ProductoSolicitud;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Asus
 */
@Stateless
public class ProductoSolicitudFacade extends AbstractFacade<ProductoSolicitud> {

    @PersistenceContext(unitName = "web_siglo_xxiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoSolicitudFacade() {
        super(ProductoSolicitud.class);
    }
    
     public int ultimaProductoSolicitudInsert() {

        Query query = em.createQuery("SELECT MAX(ps.productoSolicitudId)+1 FROM ProductoSolicitud ps");
        //System.out.println("variable de la ultima solicitud " + (short) query.getSingleResult());
        return (int) query.getSingleResult();
    }
    
     public BigDecimal ultimaProductoSolicitudSeq() {
        Query query = em.createNativeQuery("select SEQ_PRODUCTO_SOLICITUD.nextval FROM DUAL");
        return (BigDecimal) query.getSingleResult();
    }
     
    
    
}
