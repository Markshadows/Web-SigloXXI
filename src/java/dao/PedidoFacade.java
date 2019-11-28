/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Pedido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Asus
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext(unitName = "web_siglo_xxiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }

    public List<Object> carrito(int v) {
        try {
            Query query = em.createQuery("SELECT  m.nombre, e.nombre,m.precio,m.url FROM Pedido p JOIN p.menuId m JOIN p.estadoId e  JOIN p.reservaId re WHERE re.id =" + v + "");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Object> valores(int v) {
        try {
            Query query = em.createQuery("SELECT sum(M.precio*0.81),sum(M.precio*0.19) ,sum(M.precio) FROM Pedido p JOIN p.menuId m JOIN p.estadoId e  JOIN p.reservaId re  WHERE re.id=" + v + "");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

        public List<Object> pedidoListo(int v) {
        try {
            Query query = em.createQuery("SELECT sum(M.precio*0.81),sum(M.precio*0.19) ,sum(M.precio) FROM Pedido p JOIN p.menuId m JOIN p.estadoId e  JOIN p.reservaId re  WHERE re.id=" + v + "");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public int ultimoId() {
        Query query = em.createQuery("SELECT MAX(b.id)+1 FROM Pedido b");
        return (int) query.getSingleResult();
    }

   


}
