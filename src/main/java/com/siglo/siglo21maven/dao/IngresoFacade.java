/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siglo.siglo21maven.dao;

import com.siglo.siglo21maven.dto.Ingreso;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Betta
 */
@Stateless
public class IngresoFacade extends AbstractFacade<Ingreso> {

    @PersistenceContext(unitName = "com.siglo_siglo21maven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoFacade() {
        super(Ingreso.class);
    }
    
    
    public BigDecimal ultimoIngreso() {
        Query query = em.createQuery("SELECT MAX(i.id)+1 FROM Ingreso i");
        //System.out.println("variable de la ultima solicitud " + (short) query.getSingleResult());
        return (BigDecimal) query.getSingleResult();
    }
    
     public BigDecimal ultimoIngresoSequencia() {
        Query query = em.createNativeQuery("select SEQ_INGRESO_IDINGRESO.nextval from dual");
        return (BigDecimal) query.getSingleResult();
    }
    
    
}
