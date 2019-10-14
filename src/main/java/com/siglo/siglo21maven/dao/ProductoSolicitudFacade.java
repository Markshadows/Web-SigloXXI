/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siglo.siglo21maven.dao;

import com.siglo.siglo21maven.dto.ProductoSolicitud;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Betta
 */
@Stateless
public class ProductoSolicitudFacade extends AbstractFacade<ProductoSolicitud> {

    @PersistenceContext(unitName = "com.siglo_siglo21maven_war_1.0-SNAPSHOTPU")
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
    
}
