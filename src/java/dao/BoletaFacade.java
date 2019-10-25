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
        try {
            Query query = em.createQuery("SELECT MAX(b.id)+1 FROM Boleta b");
            return (int) query.getSingleResult();
        } catch (Exception e) {
            return 0;
        }

    }

    public int neto(int v) {
        Query query = em.createQuery("SELECT sum(M.precio*0.81)FROM Pedido p JOIN p.menuId m JOIN p.estadoId e  JOIN p.reservaId re  WHERE re.id=" + v + "");
        return (int) query.getSingleResult();
    }

    public int iva(int v) {

        Query query = em.createQuery("SELECT sum(M.precio*0.19) FROM Pedido p JOIN p.menuId m JOIN p.estadoId e  JOIN p.reservaId re  WHERE re.id=" + v + "");
        return (int) query.getSingleResult();

    }

    public int total(int v) {
        try {
            Query query = em.createQuery("SELECT sum(M.precio) FROM Pedido p JOIN p.menuId m JOIN p.estadoId e  JOIN p.reservaId re  WHERE re.id="+v+"");
        return (int)query.getSingleResult();
        } catch (Exception e) {
            return 5000;
        }


        

    }
}
