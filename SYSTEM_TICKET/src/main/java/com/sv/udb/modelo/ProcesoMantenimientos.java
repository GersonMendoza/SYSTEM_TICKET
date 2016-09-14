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
import javax.persistence.FetchType;
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
 * @author gersonfrancisco
 */
@Entity
@Table(name = "proceso_mantenimientos", catalog = "system_ticket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoMantenimientos.findAll", query = "SELECT p FROM ProcesoMantenimientos p"),
    @NamedQuery(name = "ProcesoMantenimientos.findByCodiProcMant", query = "SELECT p FROM ProcesoMantenimientos p WHERE p.procesoMantenimientosPK.codiProcMant = :codiProcMant"),
    @NamedQuery(name = "ProcesoMantenimientos.findByFechProcMant", query = "SELECT p FROM ProcesoMantenimientos p WHERE p.fechProcMant = :fechProcMant"),
    @NamedQuery(name = "ProcesoMantenimientos.findByCodiUsua", query = "SELECT p FROM ProcesoMantenimientos p WHERE p.codiUsua = :codiUsua"),
    @NamedQuery(name = "ProcesoMantenimientos.findByCodiCorrMant", query = "SELECT p FROM ProcesoMantenimientos p WHERE p.procesoMantenimientosPK.codiCorrMant = :codiCorrMant"),
    @NamedQuery(name = "ProcesoMantenimientos.findByEstaProcMant", query = "SELECT p FROM ProcesoMantenimientos p WHERE p.estaProcMant = :estaProcMant")})
public class ProcesoMantenimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesoMantenimientosPK procesoMantenimientosPK;
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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CorrelativoMantenimientos correlativoMantenimientos;

    public ProcesoMantenimientos() {
    }

    public ProcesoMantenimientos(ProcesoMantenimientosPK procesoMantenimientosPK) {
        this.procesoMantenimientosPK = procesoMantenimientosPK;
    }

    public ProcesoMantenimientos(ProcesoMantenimientosPK procesoMantenimientosPK, String descProcMant, Date fechProcMant, int codiUsua, boolean estaProcMant) {
        this.procesoMantenimientosPK = procesoMantenimientosPK;
        this.descProcMant = descProcMant;
        this.fechProcMant = fechProcMant;
        this.codiUsua = codiUsua;
        this.estaProcMant = estaProcMant;
    }

    public ProcesoMantenimientos(int codiProcMant, int codiCorrMant) {
        this.procesoMantenimientosPK = new ProcesoMantenimientosPK(codiProcMant, codiCorrMant);
    }

    public ProcesoMantenimientosPK getProcesoMantenimientosPK() {
        return procesoMantenimientosPK;
    }

    public void setProcesoMantenimientosPK(ProcesoMantenimientosPK procesoMantenimientosPK) {
        this.procesoMantenimientosPK = procesoMantenimientosPK;
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

    public CorrelativoMantenimientos getCorrelativoMantenimientos() {
        return correlativoMantenimientos;
    }

    public void setCorrelativoMantenimientos(CorrelativoMantenimientos correlativoMantenimientos) {
        this.correlativoMantenimientos = correlativoMantenimientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesoMantenimientosPK != null ? procesoMantenimientosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoMantenimientos)) {
            return false;
        }
        ProcesoMantenimientos other = (ProcesoMantenimientos) object;
        if ((this.procesoMantenimientosPK == null && other.procesoMantenimientosPK != null) || (this.procesoMantenimientosPK != null && !this.procesoMantenimientosPK.equals(other.procesoMantenimientosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.ProcesoMantenimientos[ procesoMantenimientosPK=" + procesoMantenimientosPK + " ]";
    }
    
}
