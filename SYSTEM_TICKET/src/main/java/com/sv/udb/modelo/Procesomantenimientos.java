/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author root
 */
@Entity
@Table(name = "Proceso_mantenimientos", catalog = "system_ticket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procesomantenimientos.findAll", query = "SELECT p FROM Procesomantenimientos p"),
    @NamedQuery(name = "Procesomantenimientos.findByCodiProcMant", query = "SELECT p FROM Procesomantenimientos p WHERE p.procesomantenimientosPK.codiProcMant = :codiProcMant"),
    @NamedQuery(name = "Procesomantenimientos.findByFechProcMant", query = "SELECT p FROM Procesomantenimientos p WHERE p.fechProcMant = :fechProcMant"),
    @NamedQuery(name = "Procesomantenimientos.findByCodiUsua", query = "SELECT p FROM Procesomantenimientos p WHERE p.codiUsua = :codiUsua"),
    @NamedQuery(name = "Procesomantenimientos.findByCodiCorrMant", query = "SELECT p FROM Procesomantenimientos p WHERE p.procesomantenimientosPK.codiCorrMant = :codiCorrMant"),
    @NamedQuery(name = "Procesomantenimientos.findByEstaProcMant", query = "SELECT p FROM Procesomantenimientos p WHERE p.estaProcMant = :estaProcMant")})
public class Procesomantenimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesomantenimientosPK procesomantenimientosPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "desc_proc_mant")
    private String descProcMant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fech_proc_mant")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechProcMant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codi_usua")
    private int codiUsua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_proc_mant")
    private boolean estaProcMant;
    @JoinColumn(name = "codi_corr_mant", referencedColumnName = "codi_corr_mant", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Correlativomantenimientos correlativomantenimientos;

    public Procesomantenimientos() {
    }

    public Procesomantenimientos(ProcesomantenimientosPK procesomantenimientosPK) {
        this.procesomantenimientosPK = procesomantenimientosPK;
    }

    public Procesomantenimientos(ProcesomantenimientosPK procesomantenimientosPK, String descProcMant, Date fechProcMant, int codiUsua, boolean estaProcMant) {
        this.procesomantenimientosPK = procesomantenimientosPK;
        this.descProcMant = descProcMant;
        this.fechProcMant = fechProcMant;
        this.codiUsua = codiUsua;
        this.estaProcMant = estaProcMant;
    }

    public Procesomantenimientos(int codiProcMant, int codiCorrMant) {
        this.procesomantenimientosPK = new ProcesomantenimientosPK(codiProcMant, codiCorrMant);
    }

    public ProcesomantenimientosPK getProcesomantenimientosPK() {
        return procesomantenimientosPK;
    }

    public void setProcesomantenimientosPK(ProcesomantenimientosPK procesomantenimientosPK) {
        this.procesomantenimientosPK = procesomantenimientosPK;
    }

    public String getDescProcMant() {
        return descProcMant;
    }

    public void setDescProcMant(String descProcMant) {
        this.descProcMant = descProcMant;
    }

    public Date getFechProcMant() {
        return fechProcMant;
    }

    public void setFechProcMant(Date fechProcMant) {
        this.fechProcMant = fechProcMant;
    }

    public int getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(int codiUsua) {
        this.codiUsua = codiUsua;
    }

    public boolean getEstaProcMant() {
        return estaProcMant;
    }

    public void setEstaProcMant(boolean estaProcMant) {
        this.estaProcMant = estaProcMant;
    }

    public Correlativomantenimientos getCorrelativomantenimientos() {
        return correlativomantenimientos;
    }

    public void setCorrelativomantenimientos(Correlativomantenimientos correlativomantenimientos) {
        this.correlativomantenimientos = correlativomantenimientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesomantenimientosPK != null ? procesomantenimientosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesomantenimientos)) {
            return false;
        }
        Procesomantenimientos other = (Procesomantenimientos) object;
        if ((this.procesomantenimientosPK == null && other.procesomantenimientosPK != null) || (this.procesomantenimientosPK != null && !this.procesomantenimientosPK.equals(other.procesomantenimientosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Procesomantenimientos[ procesomantenimientosPK=" + procesomantenimientosPK + " ]";
    }
    
}
