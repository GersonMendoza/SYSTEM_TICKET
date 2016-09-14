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
import javax.persistence.FetchType;
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
 * @author gersonfrancisco
 */
@Entity
@Table(name = "resolucion_solicitudes", catalog = "system_ticket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResolucionSolicitudes.findAll", query = "SELECT r FROM ResolucionSolicitudes r"),
    @NamedQuery(name = "ResolucionSolicitudes.findByCodiResoSoli", query = "SELECT r FROM ResolucionSolicitudes r WHERE r.resolucionSolicitudesPK.codiResoSoli = :codiResoSoli"),
    @NamedQuery(name = "ResolucionSolicitudes.findByFechResoSoli", query = "SELECT r FROM ResolucionSolicitudes r WHERE r.fechResoSoli = :fechResoSoli"),
    @NamedQuery(name = "ResolucionSolicitudes.findByTipoTrabSoli", query = "SELECT r FROM ResolucionSolicitudes r WHERE r.tipoTrabSoli = :tipoTrabSoli"),
    @NamedQuery(name = "ResolucionSolicitudes.findByCodiSoli", query = "SELECT r FROM ResolucionSolicitudes r WHERE r.resolucionSolicitudesPK.codiSoli = :codiSoli"),
    @NamedQuery(name = "ResolucionSolicitudes.findByEstaResoSoli", query = "SELECT r FROM ResolucionSolicitudes r WHERE r.estaResoSoli = :estaResoSoli")})
public class ResolucionSolicitudes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResolucionSolicitudesPK resolucionSolicitudesPK;
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "resolucionSolicitudes", fetch = FetchType.LAZY)
    private EvaluacionResoluciones evaluacionResoluciones;
    @JoinColumn(name = "codi_soli", referencedColumnName = "codi_soli", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Solicitudes solicitudes;

    public ResolucionSolicitudes() {
    }

    public ResolucionSolicitudes(ResolucionSolicitudesPK resolucionSolicitudesPK) {
        this.resolucionSolicitudesPK = resolucionSolicitudesPK;
    }

    public ResolucionSolicitudes(ResolucionSolicitudesPK resolucionSolicitudesPK, String descResoSoli, Date fechResoSoli, String tipoTrabSoli, int estaResoSoli) {
        this.resolucionSolicitudesPK = resolucionSolicitudesPK;
        this.descResoSoli = descResoSoli;
        this.fechResoSoli = fechResoSoli;
        this.tipoTrabSoli = tipoTrabSoli;
        this.estaResoSoli = estaResoSoli;
    }

    public ResolucionSolicitudes(int codiResoSoli, int codiSoli) {
        this.resolucionSolicitudesPK = new ResolucionSolicitudesPK(codiResoSoli, codiSoli);
    }

    public ResolucionSolicitudesPK getResolucionSolicitudesPK() {
        return resolucionSolicitudesPK;
    }

    public void setResolucionSolicitudesPK(ResolucionSolicitudesPK resolucionSolicitudesPK) {
        this.resolucionSolicitudesPK = resolucionSolicitudesPK;
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

    public EvaluacionResoluciones getEvaluacionResoluciones() {
        return evaluacionResoluciones;
    }

    public void setEvaluacionResoluciones(EvaluacionResoluciones evaluacionResoluciones) {
        this.evaluacionResoluciones = evaluacionResoluciones;
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
        hash += (resolucionSolicitudesPK != null ? resolucionSolicitudesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResolucionSolicitudes)) {
            return false;
        }
        ResolucionSolicitudes other = (ResolucionSolicitudes) object;
        if ((this.resolucionSolicitudesPK == null && other.resolucionSolicitudesPK != null) || (this.resolucionSolicitudesPK != null && !this.resolucionSolicitudesPK.equals(other.resolucionSolicitudesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.ResolucionSolicitudes[ resolucionSolicitudesPK=" + resolucionSolicitudesPK + " ]";
    }
    
}
