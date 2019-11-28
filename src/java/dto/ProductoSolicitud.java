/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "PRODUCTO_SOLICITUD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoSolicitud.findAll", query = "SELECT p FROM ProductoSolicitud p")
    , @NamedQuery(name = "ProductoSolicitud.findByProductoSolicitudId", query = "SELECT p FROM ProductoSolicitud p WHERE p.productoSolicitudId = :productoSolicitudId")})
public class ProductoSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTO_SOLICITUD_ID")
    private Short productoSolicitudId;
    @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Producto productoId;
    @JoinColumn(name = "SOLICITUD_ID_SOLICITUD", referencedColumnName = "ID_SOLICITUD")
    @ManyToOne(optional = false)
    private Solicitud solicitudIdSolicitud;

    public ProductoSolicitud() {
    }

    
    public ProductoSolicitud(Short productoSolicitudId, Producto productoId, Solicitud solicitudIdSolicitud) {
        this.productoSolicitudId = productoSolicitudId;
        this.productoId = productoId;
        this.solicitudIdSolicitud = solicitudIdSolicitud;
    }

    public ProductoSolicitud(Short productoSolicitudId) {
        this.productoSolicitudId = productoSolicitudId;
    }

    public Short getProductoSolicitudId() {
        return productoSolicitudId;
    }

    public void setProductoSolicitudId(Short productoSolicitudId) {
        this.productoSolicitudId = productoSolicitudId;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

    public Solicitud getSolicitudIdSolicitud() {
        return solicitudIdSolicitud;
    }

    public void setSolicitudIdSolicitud(Solicitud solicitudIdSolicitud) {
        this.solicitudIdSolicitud = solicitudIdSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoSolicitudId != null ? productoSolicitudId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoSolicitud)) {
            return false;
        }
        ProductoSolicitud other = (ProductoSolicitud) object;
        if ((this.productoSolicitudId == null && other.productoSolicitudId != null) || (this.productoSolicitudId != null && !this.productoSolicitudId.equals(other.productoSolicitudId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.ProductoSolicitud[ productoSolicitudId=" + productoSolicitudId + " ]";
    }

}
