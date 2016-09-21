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
@Table(name = "Evaluacion_resoluciones", catalog = "system_ticket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacionresoluciones.findAll", query = "SELECT e FROM Evaluacionresoluciones e"),
    @NamedQuery(name = "Evaluacionresoluciones.findByCodiEvalReso", query = "SELECT e FROM Evaluacionresoluciones e WHERE e.evaluacionresolucionesPK.codiEvalReso = :codiEvalReso"),
    @NamedQuery(name = "Evaluacionresoluciones.findByOpinEvalReso", query = "SELECT e FROM Evaluacionresoluciones e WHERE e.opinEvalReso = :opinEvalReso"),
    @NamedQuery(name = "Evaluacionresoluciones.findByCodiResoSoli", query = "SELECT e FROM Evaluacionresoluciones e WHERE e.evaluacionresolucionesPK.codiResoSoli = :codiResoSoli"),
    @NamedQuery(name = "Evaluacionresoluciones.findByFechEvalReso", query = "SELECT e FROM Evaluacionresoluciones e WHERE e.fechEvalReso = :fechEvalReso"),
    @NamedQuery(name = "Evaluacionresoluciones.findByEstaEvalReso", query = "SELECT e FROM Evaluacionresoluciones e WHERE e.estaEvalReso = :estaEvalReso")})
public class Evaluacionresoluciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EvaluacionresolucionesPK evaluacionresolucionesPK;
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
    @OneToOne(optional = false)
    private Resolucionsolicitudes resolucionsolicitudes;

    public Evaluacionresoluciones() {
    }

    public Evaluacionresoluciones(EvaluacionresolucionesPK evaluacionresolucionesPK) {
        this.evaluacionresolucionesPK = evaluacionresolucionesPK;
    }

    public Evaluacionresoluciones(EvaluacionresolucionesPK evaluacionresolucionesPK, String opinEvalReso, Date fechEvalReso, boolean estaEvalReso) {
        this.evaluacionresolucionesPK = evaluacionresolucionesPK;
        this.opinEvalReso = opinEvalReso;
        this.fechEvalReso = fechEvalReso;
        this.estaEvalReso = estaEvalReso;
    }

    public Evaluacionresoluciones(int codiEvalReso, int codiResoSoli) {
        this.evaluacionresolucionesPK = new EvaluacionresolucionesPK(codiEvalReso, codiResoSoli);
    }

    public EvaluacionresolucionesPK getEvaluacionresolucionesPK() {
        return evaluacionresolucionesPK;
    }

    public void setEvaluacionresolucionesPK(EvaluacionresolucionesPK evaluacionresolucionesPK) {
        this.evaluacionresolucionesPK = evaluacionresolucionesPK;
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

    public Resolucionsolicitudes getResolucionsolicitudes() {
        return resolucionsolicitudes;
    }

    public void setResolucionsolicitudes(Resolucionsolicitudes resolucionsolicitudes) {
        this.resolucionsolicitudes = resolucionsolicitudes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluacionresolucionesPK != null ? evaluacionresolucionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacionresoluciones)) {
            return false;
        }
        Evaluacionresoluciones other = (Evaluacionresoluciones) object;
        if ((this.evaluacionresolucionesPK == null && other.evaluacionresolucionesPK != null) || (this.evaluacionresolucionesPK != null && !this.evaluacionresolucionesPK.equals(other.evaluacionresolucionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Evaluacionresoluciones[ evaluacionresolucionesPK=" + evaluacionresolucionesPK + " ]";
    }
    
}
