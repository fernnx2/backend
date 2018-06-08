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
@Table(name = "trabajadores", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajadores.findAll", query = "SELECT t FROM Trabajadores t")
    , @NamedQuery(name = "Trabajadores.findByIdTrabajador", query = "SELECT t FROM Trabajadores t WHERE t.idTrabajador = :idTrabajador")
    , @NamedQuery(name = "Trabajadores.findByNombres", query = "SELECT t FROM Trabajadores t WHERE t.nombres = :nombres")
    , @NamedQuery(name = "Trabajadores.findByApellidos", query = "SELECT t FROM Trabajadores t WHERE t.apellidos = :apellidos")
    , @NamedQuery(name = "Trabajadores.findByEmail", query = "SELECT t FROM Trabajadores t WHERE t.email = :email")})
public class Trabajadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_trabajador", nullable = false)
    private Integer idTrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email", length = 45)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajadores")
    private List<OrdenTrabajoPorTrabajadores> ordenTrabajoPorTrabajadoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajadoresIdTrabajador")
    private List<Cargo> cargoList;

    public Trabajadores() {
    }

    public Trabajadores(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Trabajadores(Integer idTrabajador, String nombres, String apellidos) {
        this.idTrabajador = idTrabajador;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<OrdenTrabajoPorTrabajadores> getOrdenTrabajoPorTrabajadoresList() {
        return ordenTrabajoPorTrabajadoresList;
    }

    public void setOrdenTrabajoPorTrabajadoresList(List<OrdenTrabajoPorTrabajadores> ordenTrabajoPorTrabajadoresList) {
        this.ordenTrabajoPorTrabajadoresList = ordenTrabajoPorTrabajadoresList;
    }

    @XmlTransient
    public List<Cargo> getCargoList() {
        return cargoList;
    }

    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajador != null ? idTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajadores)) {
            return false;
        }
        Trabajadores other = (Trabajadores) object;
        if ((this.idTrabajador == null && other.idTrabajador != null) || (this.idTrabajador != null && !this.idTrabajador.equals(other.idTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trabajadores[ idTrabajador=" + idTrabajador + " ]";
    }
    
}
