/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id")
    , @NamedQuery(name = "Pedido.findByCreatedAt", query = "SELECT p FROM Pedido p WHERE p.createdAt = :createdAt")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "BOLETA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Boleta boletaId;
    @JoinColumn(name = "ESTADO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Estado estadoId;
    @JoinColumn(name = "MENU_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Menu menuId;
    @JoinColumn(name = "RESERVA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Reserva reservaId;

    public Pedido() {
    }

    public Pedido(int id) {
        this.id = id;
    }

    public Pedido(int id, Date createdAt, Boleta boletaId, Estado estadoId, Menu menuId, Reserva reservaId) {
        this.id = id;
        this.createdAt = createdAt;
        this.boletaId = boletaId;
        this.estadoId = estadoId;
        this.menuId = menuId;
        this.reservaId = reservaId;
    }
    

    public Pedido(int id, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boleta getBoletaId() {
        return boletaId;
    }

    public void setBoletaId(Boleta boletaId) {
        this.boletaId = boletaId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    public Reserva getReservaId() {
        return reservaId;
    }

    public void setReservaId(Reserva reservaId) {
        this.reservaId = reservaId;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Pedido)) {
//            return false;
//        }
//        Pedido other = (Pedido) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "dto.Pedido[ id=" + id + " ]";
    }
    
}
