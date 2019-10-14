/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siglo.siglo21maven.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Betta
 */
@Entity
@Table(name = "BOLETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleta.findAll", query = "SELECT b FROM Boleta b"),
    @NamedQuery(name = "Boleta.findById", query = "SELECT b FROM Boleta b WHERE b.id = :id"),
    @NamedQuery(name = "Boleta.findByCreatedAt", query = "SELECT b FROM Boleta b WHERE b.createdAt = :createdAt"),
    @NamedQuery(name = "Boleta.findByTotal", query = "SELECT b FROM Boleta b WHERE b.total = :total")})
public class Boleta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private BigInteger total;
    @JoinColumn(name = "ESTADO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EstadoBoleta estadoId;
    @JoinColumn(name = "MODO_PAGO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ModoPago modoPagoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boletaId")
    private List<Pedido> pedidoList;

    public Boleta() {
    }

    public Boleta(BigDecimal id) {
        this.id = id;
    }

    public Boleta(BigDecimal id, Date createdAt, BigInteger total) {
        this.id = id;
        this.createdAt = createdAt;
        this.total = total;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public EstadoBoleta getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(EstadoBoleta estadoId) {
        this.estadoId = estadoId;
    }

    public ModoPago getModoPagoId() {
        return modoPagoId;
    }

    public void setModoPagoId(ModoPago modoPagoId) {
        this.modoPagoId = modoPagoId;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
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
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siglo.siglo21maven.dto.Boleta[ id=" + id + " ]";
    }
    
}
