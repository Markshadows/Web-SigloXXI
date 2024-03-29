/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "INGRESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingreso.findAll", query = "SELECT i FROM Ingreso i")
    , @NamedQuery(name = "Ingreso.findById", query = "SELECT i FROM Ingreso i WHERE i.id = :id")
    , @NamedQuery(name = "Ingreso.findByIngreso", query = "SELECT i FROM Ingreso i WHERE i.ingreso = :ingreso")})

@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "sp_ingreso_promedio",
            procedureName = "sp_ingreso_promedio",
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = Void.class, name = "p_promedio")}
    )
})


public class Ingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ingreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIngreso")
    private Collection<DetalleIngreso> detalleIngresoCollection;
    @JoinColumn(name = "PRODUCTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Producto productoId;
    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Ingreso() {
    }

    public Ingreso(BigDecimal id) {
        this.id = id;
    }
    
     public Ingreso(BigDecimal id, Date ingreso, Producto productoId, Usuario usuarioId) {
        this.id = id;
        this.ingreso = ingreso;
        this.productoId = productoId;
        this.usuarioId = usuarioId;
    }

    public Ingreso(BigDecimal id, Producto productoId, Usuario usuarioId) {
        this.id = id;
        this.productoId = productoId;
        this.usuarioId = usuarioId;
    }

    public Ingreso(BigDecimal id, Date ingreso) {
        this.id = id;
        this.ingreso = ingreso;
    }


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    @XmlTransient
    public Collection<DetalleIngreso> getDetalleIngresoCollection() {
        return detalleIngresoCollection;
    }

    public void setDetalleIngresoCollection(Collection<DetalleIngreso> detalleIngresoCollection) {
        this.detalleIngresoCollection = detalleIngresoCollection;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingreso)) {
            return false;
        }
        Ingreso other = (Ingreso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Ingreso[ id=" + id + " ]";
    }
    
}
