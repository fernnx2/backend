/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fer
 */
@Entity
@Table(name = "orden_trabajo_por_trabajadores", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenTrabajoPorTrabajadores.findAll", query = "SELECT o FROM OrdenTrabajoPorTrabajadores o")
    , @NamedQuery(name = "OrdenTrabajoPorTrabajadores.findByOrdenTrabajoIdOrdenTrabajo", query = "SELECT o FROM OrdenTrabajoPorTrabajadores o WHERE o.ordenTrabajoPorTrabajadoresPK.ordenTrabajoIdOrdenTrabajo = :ordenTrabajoIdOrdenTrabajo")
    , @NamedQuery(name = "OrdenTrabajoPorTrabajadores.findByTrabajadoresIdTrabajador", query = "SELECT o FROM OrdenTrabajoPorTrabajadores o WHERE o.ordenTrabajoPorTrabajadoresPK.trabajadoresIdTrabajador = :trabajadoresIdTrabajador")})
public class OrdenTrabajoPorTrabajadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenTrabajoPorTrabajadoresPK ordenTrabajoPorTrabajadoresPK;
    @Lob
    @Size(max = 65535)
    @Column(name = "detalle_", length = 65535)
    private String detalle;
    @JoinColumn(name = "orden_trabajo_id_orden_trabajo", referencedColumnName = "id_orden_trabajo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrdenTrabajo ordenTrabajo;
    @JoinColumn(name = "trabajadores_id_trabajador", referencedColumnName = "id_trabajador", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trabajadores trabajadores;

    public OrdenTrabajoPorTrabajadores() {
    }

    public OrdenTrabajoPorTrabajadores(OrdenTrabajoPorTrabajadoresPK ordenTrabajoPorTrabajadoresPK) {
        this.ordenTrabajoPorTrabajadoresPK = ordenTrabajoPorTrabajadoresPK;
    }

    public OrdenTrabajoPorTrabajadores(int ordenTrabajoIdOrdenTrabajo, int trabajadoresIdTrabajador) {
        this.ordenTrabajoPorTrabajadoresPK = new OrdenTrabajoPorTrabajadoresPK(ordenTrabajoIdOrdenTrabajo, trabajadoresIdTrabajador);
    }

    public OrdenTrabajoPorTrabajadoresPK getOrdenTrabajoPorTrabajadoresPK() {
        return ordenTrabajoPorTrabajadoresPK;
    }

    public void setOrdenTrabajoPorTrabajadoresPK(OrdenTrabajoPorTrabajadoresPK ordenTrabajoPorTrabajadoresPK) {
        this.ordenTrabajoPorTrabajadoresPK = ordenTrabajoPorTrabajadoresPK;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public Trabajadores getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Trabajadores trabajadores) {
        this.trabajadores = trabajadores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenTrabajoPorTrabajadoresPK != null ? ordenTrabajoPorTrabajadoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoPorTrabajadores)) {
            return false;
        }
        OrdenTrabajoPorTrabajadores other = (OrdenTrabajoPorTrabajadores) object;
        if ((this.ordenTrabajoPorTrabajadoresPK == null && other.ordenTrabajoPorTrabajadoresPK != null) || (this.ordenTrabajoPorTrabajadoresPK != null && !this.ordenTrabajoPorTrabajadoresPK.equals(other.ordenTrabajoPorTrabajadoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdenTrabajoPorTrabajadores[ ordenTrabajoPorTrabajadoresPK=" + ordenTrabajoPorTrabajadoresPK + " ]";
    }
    
}
