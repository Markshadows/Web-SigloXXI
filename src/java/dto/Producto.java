/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id")
    , @NamedQuery(name = "Producto.findByCodigo", query = "SELECT p FROM Producto p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private Collection<ProductoSolicitud> productoSolicitudCollection;
    @JoinColumn(name = "METRICA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Metrica metricaId;
    @JoinColumn(name = "PROVEEDOR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Proveedor proveedorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private Collection<Ingrediente> ingredienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private Collection<Ingreso> ingresoCollection;

    public Producto() {
    }

    public Producto(Short id) {
        this.id = id;
    }

    public Producto(Short id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<ProductoSolicitud> getProductoSolicitudCollection() {
        return productoSolicitudCollection;
    }

    public void setProductoSolicitudCollection(Collection<ProductoSolicitud> productoSolicitudCollection) {
        this.productoSolicitudCollection = productoSolicitudCollection;
    }

    public Metrica getMetricaId() {
        return metricaId;
    }

    public void setMetricaId(Metrica metricaId) {
        this.metricaId = metricaId;
    }

    public Proveedor getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Proveedor proveedorId) {
        this.proveedorId = proveedorId;
    }

    @XmlTransient
    public Collection<Ingrediente> getIngredienteCollection() {
        return ingredienteCollection;
    }

    public void setIngredienteCollection(Collection<Ingrediente> ingredienteCollection) {
        this.ingredienteCollection = ingredienteCollection;
    }

    @XmlTransient
    public Collection<Ingreso> getIngresoCollection() {
        return ingresoCollection;
    }

    public void setIngresoCollection(Collection<Ingreso> ingresoCollection) {
        this.ingresoCollection = ingresoCollection;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Producto[ id=" + id + " ]";
    }
    
}
