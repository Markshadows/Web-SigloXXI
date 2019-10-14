/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siglo.siglo21maven.dao;

import com.siglo.siglo21maven.dto.Producto;
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
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "com.siglo_siglo21maven_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    
    
    
    
    
    
    
    
    //peso, Medida, Codigo, nombre, idProveedor, idUsuario))
    
    public boolean IngresarProducto(int peso, String medida, String codigo, String nombre, int idProveedor, int idUsuario) {
        try {
            StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("PROCEDURE_INGRESAR_PRODUCTO");

            query.setParameter("P_PESO", peso);
            query.setParameter("P_MEDIDA", medida);
            query.setParameter("P_CODIGO", codigo);
            query.setParameter("P_NOMBRE", nombre);
            query.setParameter("P_ID_PROVEEDOR", idProveedor);
            query.setParameter("P_ID_USUARIO", idUsuario);

            if (query.execute()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("errroorrrrr  en producto facade // error al intentar ingresar  " + e.getMessage());
            return false;
        }
    }
    
    

    public Producto productoProveedor(Object idProveedor) {
        try {
            Producto p;
            Query q = em.createQuery(
                    "SELECT pro FROM Producto pro WHERE pro.proveedorId =" + idProveedor
            );
            if (q.getResultList().isEmpty()) {
                p = null;
            } else {
                p = (Producto) q.getSingleResult();
            }
            return p;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    
    
    
    
}
