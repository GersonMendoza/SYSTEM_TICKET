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
@Table(name = "proceso_solicitudes", catalog = "system_ticket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoSolicitudes.findAll", query = "SELECT p FROM ProcesoSolicitudes p"),
    @NamedQuery(name = "ProcesoSolicitudes.findByCodiProcSoli", query = "SELECT p FROM ProcesoSolicitudes p WHERE p.procesoSolicitudesPK.codiProcSoli = :codiProcSoli"),
    @NamedQuery(name = "ProcesoSolicitudes.findByFechProcSoli", query = "SELECT p FROM ProcesoSolicitudes p WHERE p.fechProcSoli = :fechProcSoli"),
    @NamedQuery(name = "ProcesoSolicitudes.findByCodiSoli", query = "SELECT p FROM ProcesoSolicitudes p WHERE p.procesoSolicitudesPK.codiSoli = :codiSoli"),
    @NamedQuery(name = "ProcesoSolicitudes.findByEstaProcSoli", query = "SELECT p FROM ProcesoSolicitudes p WHERE p.estaProcSoli = :estaProcSoli")})
public class ProcesoSolicitudes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesoSolicitudesPK procesoSolicitudesPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "desc_proc_soli")
    private String descProcSoli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fech_proc_soli")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechProcSoli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_proc_soli")
    private boolean estaProcSoli;
    @JoinColumn(name = "codi_soli", referencedColumnName = "codi_soli", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Solicitudes solicitudes;

    public ProcesoSolicitudes() {
    }

    public ProcesoSolicitudes(ProcesoSolicitudesPK procesoSolicitudesPK) {
        this.procesoSolicitudesPK = procesoSolicitudesPK;
    }

    public ProcesoSolicitudes(ProcesoSolicitudesPK procesoSolicitudesPK, String descProcSoli, Date fechProcSoli, boolean estaProcSoli) {
        this.procesoSolicitudesPK = procesoSolicitudesPK;
        this.descProcSoli = descProcSoli;
        this.fechProcSoli = fechProcSoli;
        this.estaProcSoli = estaProcSoli;
    }

    public ProcesoSolicitudes(int codiProcSoli, int codiSoli) {
        this.procesoSolicitudesPK = new ProcesoSolicitudesPK(codiProcSoli, codiSoli);
    }

    public ProcesoSolicitudesPK getProcesoSolicitudesPK() {
        return procesoSolicitudesPK;
    }

    public void setProcesoSolicitudesPK(ProcesoSolicitudesPK procesoSolicitudesPK) {
        this.procesoSolicitudesPK = procesoSolicitudesPK;
    }

    public String getDescProcSoli() {
        return descProcSoli;
    }

    public void setDescProcSoli(String descProcSoli) {
        this.descProcSoli = descProcSoli;
    }

    public Date getFechProcSoli() {
        return fechProcSoli;
    }

    public void setFechProcSoli(Date fechProcSoli) {
        this.fechProcSoli = fechProcSoli;
    }

    public boolean getEstaProcSoli() {
        return estaProcSoli;
    }

    public void setEstaProcSoli(boolean estaProcSoli) {
        this.estaProcSoli = estaProcSoli;
    }

    public Solicitudes getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Solicitudes solicitudes) {
        this.solicitudes = solicitudes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (procesoSolicitudesPK != null ? procesoSolicitudesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoSolicitudes)) {
            return false;
        }
        ProcesoSolicitudes other = (ProcesoSolicitudes) object;
        if ((this.procesoSolicitudesPK == null && other.procesoSolicitudesPK != null) || (this.procesoSolicitudesPK != null && !this.procesoSolicitudesPK.equals(other.procesoSolicitudesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.ProcesoSolicitudes[ procesoSolicitudesPK=" + procesoSolicitudesPK + " ]";
    }
    
}
