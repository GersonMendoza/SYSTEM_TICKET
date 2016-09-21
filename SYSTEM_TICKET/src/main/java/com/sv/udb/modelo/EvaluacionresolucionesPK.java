/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class EvaluacionresolucionesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codi_eval_reso")
    private int codiEvalReso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codi_reso_soli")
    private int codiResoSoli;

    public EvaluacionresolucionesPK() {
    }

    public EvaluacionresolucionesPK(int codiEvalReso, int codiResoSoli) {
        this.codiEvalReso = codiEvalReso;
        this.codiResoSoli = codiResoSoli;
    }

    public int getCodiEvalReso() {
        return codiEvalReso;
    }

    public void setCodiEvalReso(int codiEvalReso) {
        this.codiEvalReso = codiEvalReso;
    }

    public int getCodiResoSoli() {
        return codiResoSoli;
    }

    public void setCodiResoSoli(int codiResoSoli) {
        this.codiResoSoli = codiResoSoli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codiEvalReso;
        hash += (int) codiResoSoli;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluacionresolucionesPK)) {
            return false;
        }
        EvaluacionresolucionesPK other = (EvaluacionresolucionesPK) object;
        if (this.codiEvalReso != other.codiEvalReso) {
            return false;
        }
        if (this.codiResoSoli != other.codiResoSoli) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.EvaluacionresolucionesPK[ codiEvalReso=" + codiEvalReso + ", codiResoSoli=" + codiResoSoli + " ]";
    }
    
}
