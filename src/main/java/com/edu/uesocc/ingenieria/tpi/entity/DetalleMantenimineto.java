/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author fer
 */
@Entity
@Table(name = "detalle_mantenimineto", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleMantenimineto.findAll", query = "SELECT d FROM DetalleMantenimineto d")
    , @NamedQuery(name = "DetalleMantenimineto.findByIdDetalleMantenimineto", query = "SELECT d FROM DetalleMantenimineto d WHERE d.idDetalleMantenimineto = :idDetalleMantenimineto")
    , @NamedQuery(name = "DetalleMantenimineto.findBySotfware", query = "SELECT d FROM DetalleMantenimineto d WHERE d.sotfware = :sotfware")})
public class DetalleMantenimineto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_detalle_mantenimineto", nullable = false)
    private Integer idDetalleMantenimineto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sotfware", nullable = false, length = 45)
    private String sotfware;
    @Lob
    @Size(max = 65535)
    @Column(name = "detalle_sotfware", length = 65535)
    private String detalleSotfware;
    @Lob
    @Size(max = 65535)
    @Column(name = "detalle_hardware", length = 65535)
    private String detalleHardware;
    @JoinColumn(name = "orden_trabajo_id_orden_trabajo", referencedColumnName = "id_orden_trabajo", nullable = false)
    @ManyToOne(optional = false)
    private OrdenTrabajo ordenTrabajoIdOrdenTrabajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleManteniminetoIdDetalleMantenimineto")
    private List<EstadoDetalleMantenimiento> estadoDetalleMantenimientoList;

    public DetalleMantenimineto() {
    }

    public DetalleMantenimineto(Integer idDetalleMantenimineto) {
        this.idDetalleMantenimineto = idDetalleMantenimineto;
    }

    public DetalleMantenimineto(Integer idDetalleMantenimineto, String sotfware) {
        this.idDetalleMantenimineto = idDetalleMantenimineto;
        this.sotfware = sotfware;
    }

    public Integer getIdDetalleMantenimineto() {
        return idDetalleMantenimineto;
    }

    public void setIdDetalleMantenimineto(Integer idDetalleMantenimineto) {
        this.idDetalleMantenimineto = idDetalleMantenimineto;
    }

    public String getSotfware() {
        return sotfware;
    }

    public void setSotfware(String sotfware) {
        this.sotfware = sotfware;
    }

    public String getDetalleSotfware() {
        return detalleSotfware;
    }

    public void setDetalleSotfware(String detalleSotfware) {
        this.detalleSotfware = detalleSotfware;
    }

    public String getDetalleHardware() {
        return detalleHardware;
    }

    public void setDetalleHardware(String detalleHardware) {
        this.detalleHardware = detalleHardware;
    }

    public OrdenTrabajo getOrdenTrabajoIdOrdenTrabajo() {
        return ordenTrabajoIdOrdenTrabajo;
    }

    public void setOrdenTrabajoIdOrdenTrabajo(OrdenTrabajo ordenTrabajoIdOrdenTrabajo) {
        this.ordenTrabajoIdOrdenTrabajo = ordenTrabajoIdOrdenTrabajo;
    }

    @XmlTransient
    public List<EstadoDetalleMantenimiento> getEstadoDetalleMantenimientoList() {
        return estadoDetalleMantenimientoList;
    }

    public void setEstadoDetalleMantenimientoList(List<EstadoDetalleMantenimiento> estadoDetalleMantenimientoList) {
        this.estadoDetalleMantenimientoList = estadoDetalleMantenimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleMantenimineto != null ? idDetalleMantenimineto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMantenimineto)) {
            return false;
        }
        DetalleMantenimineto other = (DetalleMantenimineto) object;
        if ((this.idDetalleMantenimineto == null && other.idDetalleMantenimineto != null) || (this.idDetalleMantenimineto != null && !this.idDetalleMantenimineto.equals(other.idDetalleMantenimineto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleMantenimineto[ idDetalleMantenimineto=" + idDetalleMantenimineto + " ]";
    }
    
}
