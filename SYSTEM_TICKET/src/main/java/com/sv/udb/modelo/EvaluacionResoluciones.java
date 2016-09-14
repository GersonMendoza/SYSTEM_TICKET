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
@Table(name = "evaluacion_resoluciones", catalog = "system_ticket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluacionResoluciones.findAll", query = "SELECT e FROM EvaluacionResoluciones e"),
    @NamedQuery(name = "EvaluacionResoluciones.findByCodiEvalReso", query = "SELECT e FROM EvaluacionResoluciones e WHERE e.evaluacionResolucionesPK.codiEvalReso = :codiEvalReso"),
    @NamedQuery(name = "EvaluacionResoluciones.findByOpinEvalReso", query = "SELECT e FROM EvaluacionResoluciones e WHERE e.opinEvalReso = :opinEvalReso"),
    @NamedQuery(name = "EvaluacionResoluciones.findByCodiResoSoli", query = "SELECT e FROM EvaluacionResoluciones e WHERE e.evaluacionResolucionesPK.codiResoSoli = :codiResoSoli"),
    @NamedQuery(name = "EvaluacionResoluciones.findByFechEvalReso", query = "SELECT e FROM EvaluacionResoluciones e WHERE e.fechEvalReso = :fechEvalReso"),
    @NamedQuery(name = "EvaluacionResoluciones.findByEstaEvalReso", query = "SELECT e FROM EvaluacionResoluciones e WHERE e.estaEvalReso = :estaEvalReso")})
public class EvaluacionResoluciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluacionResolucionesPK evaluacionResolucionesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "opin_eval_reso")
    private String opinEvalReso;
    @Lob
    @Size(max = 65535)
    @Column(name = "obse_eval_reso")
    private String obseEvalReso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fech_eval_reso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechEvalReso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_eval_reso")
    private boolean estaEvalReso;
    @JoinColumn(name = "codi_reso_soli", referencedColumnName = "codi_reso_soli", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ResolucionSolicitudes resolucionSolicitudes;

    public EvaluacionResoluciones() {
    }

    public EvaluacionResoluciones(EvaluacionResolucionesPK evaluacionResolucionesPK) {
        this.evaluacionResolucionesPK = evaluacionResolucionesPK;
    }

    public EvaluacionResoluciones(EvaluacionResolucionesPK evaluacionResolucionesPK, String opinEvalReso, Date fechEvalReso, boolean estaEvalReso) {
        this.evaluacionResolucionesPK = evaluacionResolucionesPK;
        this.opinEvalReso = opinEvalReso;
        this.fechEvalReso = fechEvalReso;
        this.estaEvalReso = estaEvalReso;
    }

    public EvaluacionResoluciones(int codiEvalReso, int codiResoSoli) {
        this.evaluacionResolucionesPK = new EvaluacionResolucionesPK(codiEvalReso, codiResoSoli);
    }

    public EvaluacionResolucionesPK getEvaluacionResolucionesPK() {
        return evaluacionResolucionesPK;
    }

    public void setEvaluacionResolucionesPK(EvaluacionResolucionesPK evaluacionResolucionesPK) {
        this.evaluacionResolucionesPK = evaluacionResolucionesPK;
    }

    public String getOpinEvalReso() {
        return opinEvalReso;
    }

    public void setOpinEvalReso(String opinEvalReso) {
        this.opinEvalReso = opinEvalReso;
    }

    public String getObseEvalReso() {
        return obseEvalReso;
    }

    public void setObseEvalReso(String obseEvalReso) {
        this.obseEvalReso = obseEvalReso;
    }

    public Date getFechEvalReso() {
        return fechEvalReso;
    }

    public void setFechEvalReso(Date fechEvalReso) {
        this.fechEvalReso = fechEvalReso;
    }

    public boolean getEstaEvalReso() {
        return estaEvalReso;
    }

    public void setEstaEvalReso(boolean estaEvalReso) {
        this.estaEvalReso = estaEvalReso;
    }

    public ResolucionSolicitudes getResolucionSolicitudes() {
        return resolucionSolicitudes;
    }

    public void setResolucionSolicitudes(ResolucionSolicitudes resolucionSolicitudes) {
        this.resolucionSolicitudes = resolucionSolicitudes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluacionResolucionesPK != null ? evaluacionResolucionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionResoluciones)) {
            return false;
        }
        EvaluacionResoluciones other = (EvaluacionResoluciones) object;
        if ((this.evaluacionResolucionesPK == null && other.evaluacionResolucionesPK != null) || (this.evaluacionResolucionesPK != null && !this.evaluacionResolucionesPK.equals(other.evaluacionResolucionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.EvaluacionResoluciones[ evaluacionResolucionesPK=" + evaluacionResolucionesPK + " ]";
    }
    
}
