/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gersonfrancisco
 */
@Entity
@Table(name = "correlativo_mantenimientos", catalog = "system_ticket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CorrelativoMantenimientos.findAll", query = "SELECT c FROM CorrelativoMantenimientos c"),
    @NamedQuery(name = "CorrelativoMantenimientos.findByCodiCorrMant", query = "SELECT c FROM CorrelativoMantenimientos c WHERE c.correlativoMantenimientosPK.codiCorrMant = :codiCorrMant"),
    @NamedQuery(name = "CorrelativoMantenimientos.findByFechCorrMant", query = "SELECT c FROM CorrelativoMantenimientos c WHERE c.fechCorrMant = :fechCorrMant"),
    @NamedQuery(name = "CorrelativoMantenimientos.findByCodiMant", query = "SELECT c FROM CorrelativoMantenimientos c WHERE c.correlativoMantenimientosPK.codiMant = :codiMant"),
    @NamedQuery(name = "CorrelativoMantenimientos.findByEstaCorrMant", query = "SELECT c FROM CorrelativoMantenimientos c WHERE c.estaCorrMant = :estaCorrMant")})
public class CorrelativoMantenimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CorrelativoMantenimientosPK correlativoMantenimientosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fech_corr_mant")
    @Temporal(TemporalType.DATE)
    private Date fechCorrMant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_corr_mant")
    private boolean estaCorrMant;
    @JoinColumn(name = "codi_mant", referencedColumnName = "codi_mant", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mantenimientos mantenimientos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativoMantenimientos", fetch = FetchType.LAZY)
    private List<ProcesoMantenimientos> procesoMantenimientosList;

    public CorrelativoMantenimientos() {
    }

    public CorrelativoMantenimientos(CorrelativoMantenimientosPK correlativoMantenimientosPK) {
        this.correlativoMantenimientosPK = correlativoMantenimientosPK;
    }

    public CorrelativoMantenimientos(CorrelativoMantenimientosPK correlativoMantenimientosPK, Date fechCorrMant, boolean estaCorrMant) {
        this.correlativoMantenimientosPK = correlativoMantenimientosPK;
        this.fechCorrMant = fechCorrMant;
        this.estaCorrMant = estaCorrMant;
    }

    public CorrelativoMantenimientos(int codiCorrMant, int codiMant) {
        this.correlativoMantenimientosPK = new CorrelativoMantenimientosPK(codiCorrMant, codiMant);
    }

    public CorrelativoMantenimientosPK getCorrelativoMantenimientosPK() {
        return correlativoMantenimientosPK;
    }

    public void setCorrelativoMantenimientosPK(CorrelativoMantenimientosPK correlativoMantenimientosPK) {
        this.correlativoMantenimientosPK = correlativoMantenimientosPK;
    }

    public Date getFechCorrMant() {
        return fechCorrMant;
    }

    public void setFechCorrMant(Date fechCorrMant) {
        this.fechCorrMant = fechCorrMant;
    }

    public boolean getEstaCorrMant() {
        return estaCorrMant;
    }

    public void setEstaCorrMant(boolean estaCorrMant) {
        this.estaCorrMant = estaCorrMant;
    }

    public Mantenimientos getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(Mantenimientos mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    @XmlTransient
    public List<ProcesoMantenimientos> getProcesoMantenimientosList() {
        return procesoMantenimientosList;
    }

    public void setProcesoMantenimientosList(List<ProcesoMantenimientos> procesoMantenimientosList) {
        this.procesoMantenimientosList = procesoMantenimientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativoMantenimientosPK != null ? correlativoMantenimientosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CorrelativoMantenimientos)) {
            return false;
        }
        CorrelativoMantenimientos other = (CorrelativoMantenimientos) object;
        if ((this.correlativoMantenimientosPK == null && other.correlativoMantenimientosPK != null) || (this.correlativoMantenimientosPK != null && !this.correlativoMantenimientosPK.equals(other.correlativoMantenimientosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.CorrelativoMantenimientos[ correlativoMantenimientosPK=" + correlativoMantenimientosPK + " ]";
    }
    
}
