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
@Table(name = "Proceso_solicitudes", catalog = "system_ticket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procesosolicitudes.findAll", query = "SELECT p FROM Procesosolicitudes p"),
    @NamedQuery(name = "Procesosolicitudes.findByCodiProcSoli", query = "SELECT p FROM Procesosolicitudes p WHERE p.procesosolicitudesPK.codiProcSoli = :codiProcSoli"),
    @NamedQuery(name = "Procesosolicitudes.findByFechProcSoli", query = "SELECT p FROM Procesosolicitudes p WHERE p.fechProcSoli = :fechProcSoli"),
    @NamedQuery(name = "Procesosolicitudes.findByCodiSoli", query = "SELECT p FROM Procesosolicitudes p WHERE p.procesosolicitudesPK.codiSoli = :codiSoli"),
    @NamedQuery(name = "Procesosolicitudes.findByEstaProcSoli", query = "SELECT p FROM Procesosolicitudes p WHERE p.estaProcSoli = :estaProcSoli")})
public class Procesosolicitudes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcesosolicitudesPK procesosolicitudesPK;
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
    @ManyToOne(optional = false)
    private Solicitudes solicitudes;

    public Procesosolicitudes() {
    }

    public Procesosolicitudes(ProcesosolicitudesPK procesosolicitudesPK) {
        this.procesosolicitudesPK = procesosolicitudesPK;
    }

    public Procesosolicitudes(ProcesosolicitudesPK procesosolicitudesPK, String descProcSoli, Date fechProcSoli, boolean estaProcSoli) {
        this.procesosolicitudesPK = procesosolicitudesPK;
        this.descProcSoli = descProcSoli;
        this.fechProcSoli = fechProcSoli;
        this.estaProcSoli = estaProcSoli;
    }

    public Procesosolicitudes(int codiProcSoli, int codiSoli) {
        this.procesosolicitudesPK = new ProcesosolicitudesPK(codiProcSoli, codiSoli);
    }

    public ProcesosolicitudesPK getProcesosolicitudesPK() {
        return procesosolicitudesPK;
    }

    public void setProcesosolicitudesPK(ProcesosolicitudesPK procesosolicitudesPK) {
        this.procesosolicitudesPK = procesosolicitudesPK;
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
        hash += (procesosolicitudesPK != null ? procesosolicitudesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procesosolicitudes)) {
            return false;
        }
        Procesosolicitudes other = (Procesosolicitudes) object;
        if ((this.procesosolicitudesPK == null && other.procesosolicitudesPK != null) || (this.procesosolicitudesPK != null && !this.procesosolicitudesPK.equals(other.procesosolicitudesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Procesosolicitudes[ procesosolicitudesPK=" + procesosolicitudesPK + " ]";
    }
    
}
