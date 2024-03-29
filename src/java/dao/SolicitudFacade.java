/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Solicitud;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class SolicitudFacade extends AbstractFacade<Solicitud> {

    @PersistenceContext(unitName = "web_siglo_xxiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudFacade() {
        super(Solicitud.class);
    }
    
    
     public List<Integer> realizarSolicitud(
            int variosProductos,
            int idProducto,
            int idSolicitud,
            String asunto,
            String mensaje) {

        try {
            StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("PROCEDURE_ENVIAR_SOLICITUD");
            query.setParameter("P_VARIOS_PRODUCTOS", variosProductos);
            query.setParameter("P_ID_PRODUCTO", idProducto);
            query.setParameter("P_ID_SOLICITUD", idSolicitud);
            query.setParameter("P_ASUNTO", asunto);
            query.setParameter("P_MENSAJE", mensaje);
            //query.setParameter("p_Retorno2", variosPlatos);

            query.execute();

            //int detalleVentaId = (int) query.getOutputParameterValue(9);
            int productoId = (int) query.getOutputParameterValue(6);

            List<Integer> resultados = new ArrayList<Integer>();

            //resultados.add(detalleVentaId);
            resultados.add(productoId);
            return resultados;

        } catch (Exception e) {
            System.out.println("errroorrrrr  en Solicitud facade   " + e.getMessage());
            return null;

        }

    }

    public Short ultimaSolicitud() {

        Query query = em.createQuery("SELECT MAX(s.idSolicitud) FROM Solicitud s");

        //System.out.println("variable de la ultima solicitud " + (short) query.getSingleResult());
        return (Short) query.getSingleResult();
    }

    public int ultimaSolicitudInsert() {
        try {

            Query query = em.createQuery("SELECT MAX(s.idSolicitud)+1 FROM Solicitud s");
            return (int) query.getSingleResult();
        } catch (Exception e) {
            return 1;
        }
    }

    public BigDecimal ultimaSolicitudInsertConSequencia() {
        Query query = em.createNativeQuery("SELECT SEQ_ESTADO_SOLICITUD.NEXTVAL FROM DUAL");
        return (BigDecimal) query.getSingleResult();
    }

    
}
