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
@Table(name = "diagnostico", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d")
    , @NamedQuery(name = "Diagnostico.findByIdDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.idDiagnostico = :idDiagnostico")
    , @NamedQuery(name = "Diagnostico.findByDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.diagnostico = :diagnostico")})
public class Diagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_diagnostico", nullable = false)
    private Integer idDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "diagnostico", nullable = false, length = 45)
    private String diagnostico;
    @JoinColumn(name = "diagnostico_parte_id_diagnostico_parte", referencedColumnName = "id_diagnostico_parte", nullable = false)
    @ManyToOne(optional = false)
    private DiagnosticoParte diagnosticoParteIdDiagnosticoParte;
    @JoinColumn(name = "procedimiento_id_procedimiento", referencedColumnName = "id_procedimiento", nullable = false)
    @ManyToOne(optional = false)
    private Procedimiento procedimientoIdProcedimiento;

    public Diagnostico() {
    }

    public Diagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Diagnostico(Integer idDiagnostico, String diagnostico) {
        this.idDiagnostico = idDiagnostico;
        this.diagnostico = diagnostico;
    }

    public Integer getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public DiagnosticoParte getDiagnosticoParteIdDiagnosticoParte() {
        return diagnosticoParteIdDiagnosticoParte;
    }

    public void setDiagnosticoParteIdDiagnosticoParte(DiagnosticoParte diagnosticoParteIdDiagnosticoParte) {
        this.diagnosticoParteIdDiagnosticoParte = diagnosticoParteIdDiagnosticoParte;
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
        hash += (idDiagnostico != null ? idDiagnostico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.idDiagnostico == null && other.idDiagnostico != null) || (this.idDiagnostico != null && !this.idDiagnostico.equals(other.idDiagnostico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Diagnostico[ idDiagnostico=" + idDiagnostico + " ]";
    }
    
}
