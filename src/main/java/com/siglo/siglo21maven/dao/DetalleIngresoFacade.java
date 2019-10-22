/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siglo.siglo21maven.dao;

import com.siglo.siglo21maven.dto.DetalleIngreso;
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
public class DetalleIngresoFacade extends AbstractFacade<DetalleIngreso> {

    @PersistenceContext(unitName = "com.siglo_siglo21maven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleIngresoFacade() {
        super(DetalleIngreso.class);
    }

    public BigDecimal ultimoDetalleIngreso() {
        Query query = em.createQuery("SELECT MAX(d.idDetalleIngreso)+1 FROM DetalleIngreso d");
        return (BigDecimal) query.getSingleResult();
    }
    

    public BigDecimal ultimoIngresoSequencia() {
        Query query = em.createNativeQuery("select SEQ_DETALLES_IDDETALLE.nextval FROM DUAL");
        return (BigDecimal) query.getSingleResult();
    }

}