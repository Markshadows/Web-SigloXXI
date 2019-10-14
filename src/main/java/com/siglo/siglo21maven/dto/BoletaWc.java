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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Betta
 */
@Entity
@Table(name = "BOLETA_WC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BoletaWc.findAll", query = "SELECT b FROM BoletaWc b"),
    @NamedQuery(name = "BoletaWc.findById", query = "SELECT b FROM BoletaWc b WHERE b.id = :id"),
    @NamedQuery(name = "BoletaWc.findByRut", query = "SELECT b FROM BoletaWc b WHERE b.rut = :rut"),
    @NamedQuery(name = "BoletaWc.findByNombre", query = "SELECT b FROM BoletaWc b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "BoletaWc.findByFecha", query = "SELECT b FROM BoletaWc b WHERE b.fecha = :fecha"),
    @NamedQuery(name = "BoletaWc.findByNeto", query = "SELECT b FROM BoletaWc b WHERE b.neto = :neto"),
    @NamedQuery(name = "BoletaWc.findByIva", query = "SELECT b FROM BoletaWc b WHERE b.iva = :iva"),
    @NamedQuery(name = "BoletaWc.findByTotal", query = "SELECT b FROM BoletaWc b WHERE b.total = :total")})
public class BoletaWc implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RUT")
    private String rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NETO")
    private BigInteger neto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IVA")
    private BigInteger iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private BigInteger total;

    public BoletaWc() {
    }

    public BoletaWc(BigDecimal id) {
        this.id = id;
    }

    public BoletaWc(BigDecimal id, String rut, String nombre, Date fecha, BigInteger neto, BigInteger iva, BigInteger total) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.fecha = fecha;
        this.neto = neto;
        this.iva = iva;
        this.total = total;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getNeto() {
        return neto;
    }

    public void setNeto(BigInteger neto) {
        this.neto = neto;
    }

    public BigInteger getIva() {
        return iva;
    }

    public void setIva(BigInteger iva) {
        this.iva = iva;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
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
        if (!(object instanceof BoletaWc)) {
            return false;
        }
        BoletaWc other = (BoletaWc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siglo.siglo21maven.dto.BoletaWc[ id=" + id + " ]";
    }
    
}
