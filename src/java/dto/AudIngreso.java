/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
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
 * @author Asus
 */
@Entity
@Table(name = "AUD_INGRESO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AudIngreso.findAll", query = "SELECT a FROM AudIngreso a")
    , @NamedQuery(name = "AudIngreso.findById", query = "SELECT a FROM AudIngreso a WHERE a.id = :id")
    , @NamedQuery(name = "AudIngreso.findByIdMetrica", query = "SELECT a FROM AudIngreso a WHERE a.idMetrica = :idMetrica")
    , @NamedQuery(name = "AudIngreso.findByFechaIngreso", query = "SELECT a FROM AudIngreso a WHERE a.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "AudIngreso.findByMetricaAntigua", query = "SELECT a FROM AudIngreso a WHERE a.metricaAntigua = :metricaAntigua")
    , @NamedQuery(name = "AudIngreso.findByMetricaNueva", query = "SELECT a FROM AudIngreso a WHERE a.metricaNueva = :metricaNueva")
    , @NamedQuery(name = "AudIngreso.findByDiferenciaMetrica", query = "SELECT a FROM AudIngreso a WHERE a.diferenciaMetrica = :diferenciaMetrica")})
public class AudIngreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_METRICA")
    private short idMetrica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "METRICA_ANTIGUA")
    private String metricaAntigua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "METRICA_NUEVA")
    private String metricaNueva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DIFERENCIA_METRICA")
    private String diferenciaMetrica;

    public AudIngreso() {
    }

    public AudIngreso(Short id) {
        this.id = id;
    }

    public AudIngreso(Short id, short idMetrica, Date fechaIngreso, String metricaAntigua, String metricaNueva, String diferenciaMetrica) {
        this.id = id;
        this.idMetrica = idMetrica;
        this.fechaIngreso = fechaIngreso;
        this.metricaAntigua = metricaAntigua;
        this.metricaNueva = metricaNueva;
        this.diferenciaMetrica = diferenciaMetrica;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public short getIdMetrica() {
        return idMetrica;
    }

    public void setIdMetrica(short idMetrica) {
        this.idMetrica = idMetrica;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getMetricaAntigua() {
        return metricaAntigua;
    }

    public void setMetricaAntigua(String metricaAntigua) {
        this.metricaAntigua = metricaAntigua;
    }

    public String getMetricaNueva() {
        return metricaNueva;
    }

    public void setMetricaNueva(String metricaNueva) {
        this.metricaNueva = metricaNueva;
    }

    public String getDiferenciaMetrica() {
        return diferenciaMetrica;
    }

    public void setDiferenciaMetrica(String diferenciaMetrica) {
        this.diferenciaMetrica = diferenciaMetrica;
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
        if (!(object instanceof AudIngreso)) {
            return false;
        }
        AudIngreso other = (AudIngreso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.AudIngreso[ id=" + id + " ]";
    }
    
}
