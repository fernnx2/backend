/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fer
 */
@Entity
@Table(name = "estado_detalle_mantenimiento", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoDetalleMantenimiento.findAll", query = "SELECT e FROM EstadoDetalleMantenimiento e")
    , @NamedQuery(name = "EstadoDetalleMantenimiento.findByIdEstadoDetalleMantenimiento", query = "SELECT e FROM EstadoDetalleMantenimiento e WHERE e.idEstadoDetalleMantenimiento = :idEstadoDetalleMantenimiento")
    , @NamedQuery(name = "EstadoDetalleMantenimiento.findByEstado", query = "SELECT e FROM EstadoDetalleMantenimiento e WHERE e.estado = :estado")
    , @NamedQuery(name = "EstadoDetalleMantenimiento.findByObservaciones", query = "SELECT e FROM EstadoDetalleMantenimiento e WHERE e.observaciones = :observaciones")})
public class EstadoDetalleMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_detalle_mantenimiento", nullable = false)
    private Integer idEstadoDetalleMantenimiento;
    @Size(max = 45)
    @Column(name = "estado", length = 45)
    private String estado;
    @Size(max = 45)
    @Column(name = "observaciones", length = 45)
    private String observaciones;
    @JoinColumn(name = "detalle_mantenimineto_id_detalle_mantenimineto", referencedColumnName = "id_detalle_mantenimineto", nullable = false)
    @ManyToOne(optional = false)
    private DetalleMantenimineto detalleManteniminetoIdDetalleMantenimineto;
    @JoinColumn(name = "procedimiento_id_procedimiento", referencedColumnName = "id_procedimiento", nullable = false)
    @ManyToOne(optional = false)
    private Procedimiento procedimientoIdProcedimiento;

    public EstadoDetalleMantenimiento() {
    }

    public EstadoDetalleMantenimiento(Integer idEstadoDetalleMantenimiento) {
        this.idEstadoDetalleMantenimiento = idEstadoDetalleMantenimiento;
    }

    public Integer getIdEstadoDetalleMantenimiento() {
        return idEstadoDetalleMantenimiento;
    }

    public void setIdEstadoDetalleMantenimiento(Integer idEstadoDetalleMantenimiento) {
        this.idEstadoDetalleMantenimiento = idEstadoDetalleMantenimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public DetalleMantenimineto getDetalleManteniminetoIdDetalleMantenimineto() {
        return detalleManteniminetoIdDetalleMantenimineto;
    }

    public void setDetalleManteniminetoIdDetalleMantenimineto(DetalleMantenimineto detalleManteniminetoIdDetalleMantenimineto) {
        this.detalleManteniminetoIdDetalleMantenimineto = detalleManteniminetoIdDetalleMantenimineto;
    }

    public Procedimiento getProcedimientoIdProcedimiento() {
        return procedimientoIdProcedimiento;
    }

    public void setProcedimientoIdProcedimiento(Procedimiento procedimientoIdProcedimiento) {
        this.procedimientoIdProcedimiento = procedimientoIdProcedimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoDetalleMantenimiento != null ? idEstadoDetalleMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoDetalleMantenimiento)) {
            return false;
        }
        EstadoDetalleMantenimiento other = (EstadoDetalleMantenimiento) object;
        if ((this.idEstadoDetalleMantenimiento == null && other.idEstadoDetalleMantenimiento != null) || (this.idEstadoDetalleMantenimiento != null && !this.idEstadoDetalleMantenimiento.equals(other.idEstadoDetalleMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EstadoDetalleMantenimiento[ idEstadoDetalleMantenimiento=" + idEstadoDetalleMantenimiento + " ]";
    }
    
}
