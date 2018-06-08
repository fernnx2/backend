/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fer
 */
@Entity
@Table(name = "orden_trabajo", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajo.findAll", query = "SELECT o FROM OrdenTrabajo o")
    , @NamedQuery(name = "OrdenTrabajo.findByIdOrdenTrabajo", query = "SELECT o FROM OrdenTrabajo o WHERE o.idOrdenTrabajo = :idOrdenTrabajo")
    , @NamedQuery(name = "OrdenTrabajo.findByFechaInicio", query = "SELECT o FROM OrdenTrabajo o WHERE o.fechaInicio = :fechaInicio")
        , @NamedQuery(name = "OrdenTrabajo.findByIdSolicitud", query = "SELECT o FROM OrdenTrabajo o WHERE o.solicitudIdSolicitud = :solicitudIdSolicitud")
    , @NamedQuery(name = "OrdenTrabajo.findByPrioridad", query = "SELECT o FROM OrdenTrabajo o WHERE o.prioridad = :prioridad")})
public class OrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden_trabajo", nullable = false)
    private Integer idOrdenTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prioridad", nullable = false, length = 45)
    private String prioridad;
    @JoinColumn(name = "calendario_id_calendario", referencedColumnName = "id_calendario", nullable = false)
    @ManyToOne(optional = false)
    private Calendario calendarioIdCalendario;
    @JoinColumn(name = "solicitud_id_solicitud", referencedColumnName = "id_solicitud", nullable = false)
    @ManyToOne(optional = false)
    private Solicitud solicitudIdSolicitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenTrabajo")
    private List<OrdenTrabajoPorTrabajadores> ordenTrabajoPorTrabajadoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenTrabajoIdOrdenTrabajo")
    private List<DetalleMantenimineto> detalleManteniminetoList;

    public OrdenTrabajo() {
    }

    public OrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public OrdenTrabajo(Integer idOrdenTrabajo, Date fechaInicio, String prioridad) {
        this.idOrdenTrabajo = idOrdenTrabajo;
        this.fechaInicio = fechaInicio;
        this.prioridad = prioridad;
    }

    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Calendario getCalendarioIdCalendario() {
        return calendarioIdCalendario;
    }

    public void setCalendarioIdCalendario(Calendario calendarioIdCalendario) {
        this.calendarioIdCalendario = calendarioIdCalendario;
    }

    public Solicitud getSolicitudIdSolicitud() {
        return solicitudIdSolicitud;
    }

    public void setSolicitudIdSolicitud(Solicitud solicitudIdSolicitud) {
        this.solicitudIdSolicitud = solicitudIdSolicitud;
    }

    @XmlTransient
    public List<OrdenTrabajoPorTrabajadores> getOrdenTrabajoPorTrabajadoresList() {
        return ordenTrabajoPorTrabajadoresList;
    }

    public void setOrdenTrabajoPorTrabajadoresList(List<OrdenTrabajoPorTrabajadores> ordenTrabajoPorTrabajadoresList) {
        this.ordenTrabajoPorTrabajadoresList = ordenTrabajoPorTrabajadoresList;
    }

    @XmlTransient
    public List<DetalleMantenimineto> getDetalleManteniminetoList() {
        return detalleManteniminetoList;
    }

    public void setDetalleManteniminetoList(List<DetalleMantenimineto> detalleManteniminetoList) {
        this.detalleManteniminetoList = detalleManteniminetoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenTrabajo != null ? idOrdenTrabajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajo)) {
            return false;
        }
        OrdenTrabajo other = (OrdenTrabajo) object;
        if ((this.idOrdenTrabajo == null && other.idOrdenTrabajo != null) || (this.idOrdenTrabajo != null && !this.idOrdenTrabajo.equals(other.idOrdenTrabajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdenTrabajo[ idOrdenTrabajo=" + idOrdenTrabajo + " ]";
    }
    
}
