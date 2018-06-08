/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fer
 */
@Embeddable
public class OrdenTrabajoPorTrabajadoresPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "orden_trabajo_id_orden_trabajo", nullable = false)
    private int ordenTrabajoIdOrdenTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trabajadores_id_trabajador", nullable = false)
    private int trabajadoresIdTrabajador;

    public OrdenTrabajoPorTrabajadoresPK() {
    }

    public OrdenTrabajoPorTrabajadoresPK(int ordenTrabajoIdOrdenTrabajo, int trabajadoresIdTrabajador) {
        this.ordenTrabajoIdOrdenTrabajo = ordenTrabajoIdOrdenTrabajo;
        this.trabajadoresIdTrabajador = trabajadoresIdTrabajador;
    }

    public int getOrdenTrabajoIdOrdenTrabajo() {
        return ordenTrabajoIdOrdenTrabajo;
    }

    public void setOrdenTrabajoIdOrdenTrabajo(int ordenTrabajoIdOrdenTrabajo) {
        this.ordenTrabajoIdOrdenTrabajo = ordenTrabajoIdOrdenTrabajo;
    }

    public int getTrabajadoresIdTrabajador() {
        return trabajadoresIdTrabajador;
    }

    public void setTrabajadoresIdTrabajador(int trabajadoresIdTrabajador) {
        this.trabajadoresIdTrabajador = trabajadoresIdTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ordenTrabajoIdOrdenTrabajo;
        hash += (int) trabajadoresIdTrabajador;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajoPorTrabajadoresPK)) {
            return false;
        }
        OrdenTrabajoPorTrabajadoresPK other = (OrdenTrabajoPorTrabajadoresPK) object;
        if (this.ordenTrabajoIdOrdenTrabajo != other.ordenTrabajoIdOrdenTrabajo) {
            return false;
        }
        if (this.trabajadoresIdTrabajador != other.trabajadoresIdTrabajador) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdenTrabajoPorTrabajadoresPK[ ordenTrabajoIdOrdenTrabajo=" + ordenTrabajoIdOrdenTrabajo + ", trabajadoresIdTrabajador=" + trabajadoresIdTrabajador + " ]";
    }
    
}
