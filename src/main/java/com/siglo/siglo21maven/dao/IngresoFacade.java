/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siglo.siglo21maven.dao;

import com.siglo.siglo21maven.dto.Ingreso;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

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

    public List<Object> promedioIngreso() {
        try {
            Query query = em.createNativeQuery("SELECT p FROM promedio p");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /*
    
    public List<Object> promedioIngreso() {
        try {
            Query query = em.createQuery("SELECT i.productoId.nombre, AVG( i.ingreso)  FROM Ingreso i GROUP BY i.productoId.nombre");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
     */
 /*
    public String promedioIngreso() {
        try {
            StoredProcedureQuery q = this.em.createNamedStoredProcedureQuery("sp_ingreso_promedio");
            q.execute();

            List<Object> a = new ArrayList<>();
            
            Long i = (Long) q.getOutputParameterValue("p_promedio");
            System.out.println("aaaaaaaaaaaaaaaaaaaaa"+i);
               
            List<Object> b = (List<Object>) q.getResultList();
            for (Object o : b) {
                String c = String.valueOf(o);
                a.add(c);
                //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+o);
                //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+a);
            }
            
            

            //String producto=(String);
            //Object a = q.getOutputParameterValue("p_promedio");
            //System.out.println("elementos +++++++++++++++++++++++++++++++"+a);
            //for(Object x : q.getOutputParameterValue(1)){}
            //List<Object>resultados=new ArrayList<Object>((Collection<? extends Object>) q.getOutputParameterValue("producto"));
            //resultados.add(producto);
            //return resultados;
            return "se ejecuto";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
     */
}
