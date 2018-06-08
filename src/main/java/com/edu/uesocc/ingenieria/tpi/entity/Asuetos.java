/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.entity;

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
 * @author fer
 */
@Entity
@Table(name = "asuetos", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asuetos.findAll", query = "SELECT a FROM Asuetos a")
    , @NamedQuery(name = "Asuetos.findByIdAsuetos", query = "SELECT a FROM Asuetos a WHERE a.idAsuetos = :idAsuetos")
    , @NamedQuery(name = "Asuetos.findByFecha", query = "SELECT a FROM Asuetos a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Asuetos.findByDescripcion", query = "SELECT a FROM Asuetos a WHERE a.descripcion = :descripcion")})
public class Asuetos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_asuetos", nullable = false)
    private Integer idAsuetos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "descripcion", length = 45)
    private String descripcion;

    public Asuetos() {
    }

    public Asuetos(Integer idAsuetos) {
        this.idAsuetos = idAsuetos;
    }

    public Asuetos(Integer idAsuetos, Date fecha) {
        this.idAsuetos = idAsuetos;
        this.fecha = fecha;
    }

    public Integer getIdAsuetos() {
        return idAsuetos;
    }

    public void setIdAsuetos(Integer idAsuetos) {
        this.idAsuetos = idAsuetos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsuetos != null ? idAsuetos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asuetos)) {
            return false;
        }
        Asuetos other = (Asuetos) object;
        if ((this.idAsuetos == null && other.idAsuetos != null) || (this.idAsuetos != null && !this.idAsuetos.equals(other.idAsuetos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asuetos[ idAsuetos=" + idAsuetos + " ]";
    }
    
}
