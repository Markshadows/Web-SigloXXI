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
@Table(name = "SOLICITUD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud")
    , @NamedQuery(name = "Solicitud.findByAsunto", query = "SELECT s FROM Solicitud s WHERE s.asunto = :asunto")
    , @NamedQuery(name = "Solicitud.findByMensaje", query = "SELECT s FROM Solicitud s WHERE s.mensaje = :mensaje")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOLICITUD")
    private Short idSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ASUNTO")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MENSAJE")
    private String mensaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudIdSolicitud")
    private Collection<ProductoSolicitud> productoSolicitudCollection;
    @JoinColumn(name = "ESTADO_SOLICITUD", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false)
    private EstadoSolicitud estadoSolicitud;

    public Solicitud() {
    }

    public Solicitud(Short idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitud(Short idSolicitud, String asunto, String mensaje) {
        this.idSolicitud = idSolicitud;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public Short getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Short idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @XmlTransient
    public Collection<ProductoSolicitud> getProductoSolicitudCollection() {
        return productoSolicitudCollection;
    }

    public void setProductoSolicitudCollection(Collection<ProductoSolicitud> productoSolicitudCollection) {
        this.productoSolicitudCollection = productoSolicitudCollection;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Solicitud[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
