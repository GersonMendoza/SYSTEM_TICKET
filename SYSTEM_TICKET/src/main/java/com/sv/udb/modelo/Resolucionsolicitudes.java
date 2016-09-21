/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "Resolucion_solicitudes", catalog = "system_ticket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resolucionsolicitudes.findAll", query = "SELECT r FROM Resolucionsolicitudes r"),
    @NamedQuery(name = "Resolucionsolicitudes.findByCodiResoSoli", query = "SELECT r FROM Resolucionsolicitudes r WHERE r.resolucionsolicitudesPK.codiResoSoli = :codiResoSoli"),
    @NamedQuery(name = "Resolucionsolicitudes.findByFechResoSoli", query = "SELECT r FROM Resolucionsolicitudes r WHERE r.fechResoSoli = :fechResoSoli"),
    @NamedQuery(name = "Resolucionsolicitudes.findByTipoTrabSoli", query = "SELECT r FROM Resolucionsolicitudes r WHERE r.tipoTrabSoli = :tipoTrabSoli"),
    @NamedQuery(name = "Resolucionsolicitudes.findByCodiSoli", query = "SELECT r FROM Resolucionsolicitudes r WHERE r.resolucionsolicitudesPK.codiSoli = :codiSoli"),
    @NamedQuery(name = "Resolucionsolicitudes.findByEstaResoSoli", query = "SELECT r FROM Resolucionsolicitudes r WHERE r.estaResoSoli = :estaResoSoli")})
public class Resolucionsolicitudes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResolucionsolicitudesPK resolucionsolicitudesPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "desc_reso_soli")
    private String descResoSoli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fech_reso_soli")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechResoSoli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_trab_soli")
    private String tipoTrabSoli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_reso_soli")
    private int estaResoSoli;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "resolucionsolicitudes")
    private Evaluacionresoluciones evaluacionresoluciones;
    @JoinColumn(name = "codi_soli", referencedColumnName = "codi_soli", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Solicitudes solicitudes;

    public Resolucionsolicitudes() {
    }

    public Resolucionsolicitudes(ResolucionsolicitudesPK resolucionsolicitudesPK) {
        this.resolucionsolicitudesPK = resolucionsolicitudesPK;
    }

    public Resolucionsolicitudes(ResolucionsolicitudesPK resolucionsolicitudesPK, String descResoSoli, Date fechResoSoli, String tipoTrabSoli, int estaResoSoli) {
        this.resolucionsolicitudesPK = resolucionsolicitudesPK;
        this.descResoSoli = descResoSoli;
        this.fechResoSoli = fechResoSoli;
        this.tipoTrabSoli = tipoTrabSoli;
        this.estaResoSoli = estaResoSoli;
    }

    public Resolucionsolicitudes(int codiResoSoli, int codiSoli) {
        this.resolucionsolicitudesPK = new ResolucionsolicitudesPK(codiResoSoli, codiSoli);
    }

    public ResolucionsolicitudesPK getResolucionsolicitudesPK() {
        return resolucionsolicitudesPK;
    }

    public void setResolucionsolicitudesPK(ResolucionsolicitudesPK resolucionsolicitudesPK) {
        this.resolucionsolicitudesPK = resolucionsolicitudesPK;
    }

    public String getDescResoSoli() {
        return descResoSoli;
    }

    public void setDescResoSoli(String descResoSoli) {
        this.descResoSoli = descResoSoli;
    }

    public Date getFechResoSoli() {
        return fechResoSoli;
    }

    public void setFechResoSoli(Date fechResoSoli) {
        this.fechResoSoli = fechResoSoli;
    }

    public String getTipoTrabSoli() {
        return tipoTrabSoli;
    }

    public void setTipoTrabSoli(String tipoTrabSoli) {
        this.tipoTrabSoli = tipoTrabSoli;
    }

    public int getEstaResoSoli() {
        return estaResoSoli;
    }

    public void setEstaResoSoli(int estaResoSoli) {
        this.estaResoSoli = estaResoSoli;
    }

    public Evaluacionresoluciones getEvaluacionresoluciones() {
        return evaluacionresoluciones;
    }

    public void setEvaluacionresoluciones(Evaluacionresoluciones evaluacionresoluciones) {
        this.evaluacionresoluciones = evaluacionresoluciones;
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
        hash += (resolucionsolicitudesPK != null ? resolucionsolicitudesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resolucionsolicitudes)) {
            return false;
        }
        Resolucionsolicitudes other = (Resolucionsolicitudes) object;
        if ((this.resolucionsolicitudesPK == null && other.resolucionsolicitudesPK != null) || (this.resolucionsolicitudesPK != null && !this.resolucionsolicitudesPK.equals(other.resolucionsolicitudesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Resolucionsolicitudes[ resolucionsolicitudesPK=" + resolucionsolicitudesPK + " ]";
    }
    
}
