/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "METRICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metrica.findAll", query = "SELECT m FROM Metrica m")
    , @NamedQuery(name = "Metrica.findById", query = "SELECT m FROM Metrica m WHERE m.id = :id")
    , @NamedQuery(name = "Metrica.findByPeso", query = "SELECT m FROM Metrica m WHERE m.peso = :peso")
    , @NamedQuery(name = "Metrica.findByMedida", query = "SELECT m FROM Metrica m WHERE m.medida = :medida")})
public class Metrica implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESO")
    private BigInteger peso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MEDIDA")
    private String medida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metricaId")
    private Collection<Producto> productoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metricaId")
    private Collection<Ingrediente> ingredienteCollection;

    public Metrica() {
    }

    public Metrica(BigDecimal id) {
        this.id = id;
    }

    public Metrica(BigDecimal id, BigInteger peso, String medida) {
        this.id = id;
        this.peso = peso;
        this.medida = medida;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getPeso() {
        return peso;
    }

    public void setPeso(BigInteger peso) {
        this.peso = peso;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @XmlTransient
    public Collection<Ingrediente> getIngredienteCollection() {
        return ingredienteCollection;
    }

    public void setIngredienteCollection(Collection<Ingrediente> ingredienteCollection) {
        this.ingredienteCollection = ingredienteCollection;
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
        if (!(object instanceof Metrica)) {
            return false;
        }
        Metrica other = (Metrica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Metrica[ id=" + id + " ]";
    }
    
}
