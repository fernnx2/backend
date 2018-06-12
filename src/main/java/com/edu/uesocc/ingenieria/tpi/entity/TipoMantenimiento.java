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
@Table(name = "tipo_mantenimiento", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMantenimiento.findAll", query = "SELECT t FROM TipoMantenimiento t")
    , @NamedQuery(name = "TipoMantenimiento.findByIdTipoMantenimiento", query = "SELECT t FROM TipoMantenimiento t WHERE t.idTipoMantenimiento = :idTipoMantenimiento")
    , @NamedQuery(name = "TipoMantenimiento.findByTipoMantenimiento", query = "SELECT t FROM TipoMantenimiento t WHERE t.tipoMantenimiento = :tipoMantenimiento")
    , @NamedQuery(name = "TipoMantenimiento.findByObservaciones", query = "SELECT t FROM TipoMantenimiento t WHERE t.observaciones = :observaciones")})
public class TipoMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_mantenimiento", nullable = false)
    private Integer idTipoMantenimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_mantenimiento", nullable = false, length = 45)
    private String tipoMantenimiento;
    @Size(max = 45)
    @Column(name = "observaciones", length = 45)
    private String observaciones;
    

    public TipoMantenimiento() {
    }

    public TipoMantenimiento(Integer idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public TipoMantenimiento(Integer idTipoMantenimiento, String tipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public Integer getIdTipoMantenimiento() {
        return idTipoMantenimiento;
    }

    public void setIdTipoMantenimiento(Integer idTipoMantenimiento) {
        this.idTipoMantenimiento = idTipoMantenimiento;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMantenimiento != null ? idTipoMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMantenimiento)) {
            return false;
        }
        TipoMantenimiento other = (TipoMantenimiento) object;
        if ((this.idTipoMantenimiento == null && other.idTipoMantenimiento != null) || (this.idTipoMantenimiento != null && !this.idTipoMantenimiento.equals(other.idTipoMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoMantenimiento[ idTipoMantenimiento=" + idTipoMantenimiento + " ]";
    }
    
}
