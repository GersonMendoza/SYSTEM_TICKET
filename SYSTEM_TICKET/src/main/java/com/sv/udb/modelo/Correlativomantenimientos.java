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
 * @author root
 */
@Entity
@Table(name = "Correlativo_mantenimientos", catalog = "system_ticket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correlativomantenimientos.findAll", query = "SELECT c FROM Correlativomantenimientos c"),
    @NamedQuery(name = "Correlativomantenimientos.findByCodiCorrMant", query = "SELECT c FROM Correlativomantenimientos c WHERE c.correlativomantenimientosPK.codiCorrMant = :codiCorrMant"),
    @NamedQuery(name = "Correlativomantenimientos.findByFechCorrMant", query = "SELECT c FROM Correlativomantenimientos c WHERE c.fechCorrMant = :fechCorrMant"),
    @NamedQuery(name = "Correlativomantenimientos.findByCodiMant", query = "SELECT c FROM Correlativomantenimientos c WHERE c.correlativomantenimientosPK.codiMant = :codiMant"),
    @NamedQuery(name = "Correlativomantenimientos.findByEstaCorrMant", query = "SELECT c FROM Correlativomantenimientos c WHERE c.estaCorrMant = :estaCorrMant")})
public class Correlativomantenimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CorrelativomantenimientosPK correlativomantenimientosPK;
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
    @ManyToOne(optional = false)
    private Mantenimientos mantenimientos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "correlativomantenimientos")
    private List<Procesomantenimientos> procesomantenimientosList;

    public Correlativomantenimientos() {
    }

    public Correlativomantenimientos(CorrelativomantenimientosPK correlativomantenimientosPK) {
        this.correlativomantenimientosPK = correlativomantenimientosPK;
    }

    public Correlativomantenimientos(CorrelativomantenimientosPK correlativomantenimientosPK, Date fechCorrMant, boolean estaCorrMant) {
        this.correlativomantenimientosPK = correlativomantenimientosPK;
        this.fechCorrMant = fechCorrMant;
        this.estaCorrMant = estaCorrMant;
    }

    public Correlativomantenimientos(int codiCorrMant, int codiMant) {
        this.correlativomantenimientosPK = new CorrelativomantenimientosPK(codiCorrMant, codiMant);
    }

    public CorrelativomantenimientosPK getCorrelativomantenimientosPK() {
        return correlativomantenimientosPK;
    }

    public void setCorrelativomantenimientosPK(CorrelativomantenimientosPK correlativomantenimientosPK) {
        this.correlativomantenimientosPK = correlativomantenimientosPK;
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
    public List<Procesomantenimientos> getProcesomantenimientosList() {
        return procesomantenimientosList;
    }

    public void setProcesomantenimientosList(List<Procesomantenimientos> procesomantenimientosList) {
        this.procesomantenimientosList = procesomantenimientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativomantenimientosPK != null ? correlativomantenimientosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correlativomantenimientos)) {
            return false;
        }
        Correlativomantenimientos other = (Correlativomantenimientos) object;
        if ((this.correlativomantenimientosPK == null && other.correlativomantenimientosPK != null) || (this.correlativomantenimientosPK != null && !this.correlativomantenimientosPK.equals(other.correlativomantenimientosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Correlativomantenimientos[ correlativomantenimientosPK=" + correlativomantenimientosPK + " ]";
    }
    
}
