/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Ingreso;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Asus
 */
@Stateless
public class IngresoFacade extends AbstractFacade<Ingreso> {

    @PersistenceContext(unitName = "web_siglo_xxiPU")
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

    
    
    
    public List<Object[]> promedioIngreso() {
        try {

            StoredProcedureQuery q = this.em.createNamedStoredProcedureQuery("sp_ingreso_promedio");
            q.execute();
            List<Object[]> promedios = q.getResultList();
            return promedios;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
