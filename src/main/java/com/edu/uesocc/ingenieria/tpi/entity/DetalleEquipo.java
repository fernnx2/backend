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
@Table(name = "detalle_equipo", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleEquipo.findAll", query = "SELECT d FROM DetalleEquipo d")
    , @NamedQuery(name = "DetalleEquipo.findByIdDetalleEquipo", query = "SELECT d FROM DetalleEquipo d WHERE d.idDetalleEquipo = :idDetalleEquipo")
    , @NamedQuery(name = "DetalleEquipo.findByDispositivo", query = "SELECT d FROM DetalleEquipo d WHERE d.dispositivo = :dispositivo")
    , @NamedQuery(name = "DetalleEquipo.findByDescripcion", query = "SELECT d FROM DetalleEquipo d WHERE d.descripcion = :descripcion")})
public class DetalleEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_detalle_equipo", nullable = false)
    private Integer idDetalleEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dispositivo", nullable = false, length = 45)
    private String dispositivo;
    @Size(max = 45)
    @Column(name = "descripcion", length = 45)
    private String descripcion;
    @JoinColumn(name = "equipo_id_equipo", referencedColumnName = "id_equipo", nullable = false)
    @ManyToOne(optional = false)
    private Equipo equipoIdEquipo;
    @JoinColumn(name = "marca_id_marca", referencedColumnName = "id_marca", nullable = false)
    @ManyToOne(optional = false)
    private Marca marcaIdMarca;
    @JoinColumn(name = "modelo_id_modelo", referencedColumnName = "id_modelo", nullable = false)
    @ManyToOne(optional = false)
    private Modelo modeloIdModelo;

    public DetalleEquipo() {
    }

    public DetalleEquipo(Integer idDetalleEquipo) {
        this.idDetalleEquipo = idDetalleEquipo;
    }

    public DetalleEquipo(Integer idDetalleEquipo, String dispositivo) {
        this.idDetalleEquipo = idDetalleEquipo;
        this.dispositivo = dispositivo;
    }

    public Integer getIdDetalleEquipo() {
        return idDetalleEquipo;
    }

    public void setIdDetalleEquipo(Integer idDetalleEquipo) {
        this.idDetalleEquipo = idDetalleEquipo;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Equipo getEquipoIdEquipo() {
        return equipoIdEquipo;
    }

    public void setEquipoIdEquipo(Equipo equipoIdEquipo) {
        this.equipoIdEquipo = equipoIdEquipo;
    }

    public Marca getMarcaIdMarca() {
        return marcaIdMarca;
    }

    public void setMarcaIdMarca(Marca marcaIdMarca) {
        this.marcaIdMarca = marcaIdMarca;
    }

    public Modelo getModeloIdModelo() {
        return modeloIdModelo;
    }

    public void setModeloIdModelo(Modelo modeloIdModelo) {
        this.modeloIdModelo = modeloIdModelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleEquipo != null ? idDetalleEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEquipo)) {
            return false;
        }
        DetalleEquipo other = (DetalleEquipo) object;
        if ((this.idDetalleEquipo == null && other.idDetalleEquipo != null) || (this.idDetalleEquipo != null && !this.idDetalleEquipo.equals(other.idDetalleEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.uesocc.ingenieria.tpi.entity.DetalleEquipo[ idDetalleEquipo=" + idDetalleEquipo + " ]";
    }
    
}
