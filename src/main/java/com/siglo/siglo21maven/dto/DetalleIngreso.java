/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siglo.siglo21maven.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author Betta
 */
@Entity
@Table(name = "DETALLE_INGRESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleIngreso.findAll", query = "SELECT d FROM DetalleIngreso d"),
    @NamedQuery(name = "DetalleIngreso.findByIdDetalleIngreso", query = "SELECT d FROM DetalleIngreso d WHERE d.idDetalleIngreso = :idDetalleIngreso"),
    @NamedQuery(name = "DetalleIngreso.findByPesoAntiguo", query = "SELECT d FROM DetalleIngreso d WHERE d.pesoAntiguo = :pesoAntiguo"),
    @NamedQuery(name = "DetalleIngreso.findByPesoNuevo", query = "SELECT d FROM DetalleIngreso d WHERE d.pesoNuevo = :pesoNuevo"),
    @NamedQuery(name = "DetalleIngreso.findByPesoIngresado", query = "SELECT d FROM DetalleIngreso d WHERE d.pesoIngresado = :pesoIngresado")})
public class DetalleIngreso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE_INGRESO")
    private BigDecimal idDetalleIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESO_ANTIGUO")
    private BigInteger pesoAntiguo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESO_NUEVO")
    private BigInteger pesoNuevo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PESO_INGRESADO")
    private BigInteger pesoIngresado;
    @JoinColumn(name = "ID_INGRESO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ingreso idIngreso;

    public DetalleIngreso() {
    }

    public DetalleIngreso(BigDecimal idDetalleIngreso) {
        this.idDetalleIngreso = idDetalleIngreso;
    }

    public DetalleIngreso(BigDecimal idDetalleIngreso, BigInteger pesoAntiguo, BigInteger pesoNuevo, BigInteger pesoIngresado) {
        this.idDetalleIngreso = idDetalleIngreso;
        this.pesoAntiguo = pesoAntiguo;
        this.pesoNuevo = pesoNuevo;
        this.pesoIngresado = pesoIngresado;
    }

    public DetalleIngreso(BigDecimal idDetalleIngreso, BigInteger pesoAntiguo, BigInteger pesoNuevo, BigInteger pesoIngresado, Ingreso idIngreso) {
        this.idDetalleIngreso = idDetalleIngreso;
        this.pesoAntiguo = pesoAntiguo;
        this.pesoNuevo = pesoNuevo;
        this.pesoIngresado = pesoIngresado;
        this.idIngreso = idIngreso;
    }
    
    

    public BigDecimal getIdDetalleIngreso() {
        return idDetalleIngreso;
    }

    public void setIdDetalleIngreso(BigDecimal idDetalleIngreso) {
        this.idDetalleIngreso = idDetalleIngreso;
    }

    public BigInteger getPesoAntiguo() {
        return pesoAntiguo;
    }

    public void setPesoAntiguo(BigInteger pesoAntiguo) {
        this.pesoAntiguo = pesoAntiguo;
    }

    public BigInteger getPesoNuevo() {
        return pesoNuevo;
    }

    public void setPesoNuevo(BigInteger pesoNuevo) {
        this.pesoNuevo = pesoNuevo;
    }

    public BigInteger getPesoIngresado() {
        return pesoIngresado;
    }

    public void setPesoIngresado(BigInteger pesoIngresado) {
        this.pesoIngresado = pesoIngresado;
    }

    public Ingreso getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(Ingreso idIngreso) {
        this.idIngreso = idIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleIngreso != null ? idDetalleIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleIngreso)) {
            return false;
        }
        DetalleIngreso other = (DetalleIngreso) object;
        if ((this.idDetalleIngreso == null && other.idDetalleIngreso != null) || (this.idDetalleIngreso != null && !this.idDetalleIngreso.equals(other.idDetalleIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siglo.siglo21maven.dto.DetalleIngreso[ idDetalleIngreso=" + idDetalleIngreso + " ]";
    }
    
}
