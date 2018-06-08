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
@Table(name = "procedimiento", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedimiento.findAll", query = "SELECT p FROM Procedimiento p")
    , @NamedQuery(name = "Procedimiento.findByIdProcedimiento", query = "SELECT p FROM Procedimiento p WHERE p.idProcedimiento = :idProcedimiento")
    , @NamedQuery(name = "Procedimiento.findByTipoProcedimiento", query = "SELECT p FROM Procedimiento p WHERE p.tipoProcedimiento = :tipoProcedimiento")})
public class Procedimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_procedimiento", nullable = false)
    private Integer idProcedimiento;
    @Size(max = 45)
    @Column(name = "tipo_procedimiento", length = 45)
    private String tipoProcedimiento;
    @JoinColumn(name = "pasos_id_paso", referencedColumnName = "id_paso", nullable = false)
    @ManyToOne(optional = false)
    private Pasos pasosIdPaso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedimientoIdProcedimiento")
    private List<Diagnostico> diagnosticoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedimientoIdProcedimiento")
    private List<EstadoDetalleMantenimiento> estadoDetalleMantenimientoList;

    public Procedimiento() {
    }

    public Procedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public Integer getIdProcedimiento() {
        return idProcedimiento;
    }

    public void setIdProcedimiento(Integer idProcedimiento) {
        this.idProcedimiento = idProcedimiento;
    }

    public String getTipoProcedimiento() {
        return tipoProcedimiento;
    }

    public void setTipoProcedimiento(String tipoProcedimiento) {
        this.tipoProcedimiento = tipoProcedimiento;
    }

    public Pasos getPasosIdPaso() {
        return pasosIdPaso;
    }

    public void setPasosIdPaso(Pasos pasosIdPaso) {
        this.pasosIdPaso = pasosIdPaso;
    }

    @XmlTransient
    public List<Diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<Diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
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
        hash += (idProcedimiento != null ? idProcedimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimiento)) {
            return false;
        }
        Procedimiento other = (Procedimiento) object;
        if ((this.idProcedimiento == null && other.idProcedimiento != null) || (this.idProcedimiento != null && !this.idProcedimiento.equals(other.idProcedimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Procedimiento[ idProcedimiento=" + idProcedimiento + " ]";
    }
    
}
