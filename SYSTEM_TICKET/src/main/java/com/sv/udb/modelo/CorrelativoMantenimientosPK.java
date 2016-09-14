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
 * @author gersonfrancisco
 */
@Embeddable
public class CorrelativoMantenimientosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "codi_corr_mant")
    private int codiCorrMant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codi_mant")
    private int codiMant;

    public CorrelativoMantenimientosPK() {
    }

    public CorrelativoMantenimientosPK(int codiCorrMant, int codiMant) {
        this.codiCorrMant = codiCorrMant;
        this.codiMant = codiMant;
    }

    public int getCodiCorrMant() {
        return codiCorrMant;
    }

    public void setCodiCorrMant(int codiCorrMant) {
        this.codiCorrMant = codiCorrMant;
    }

    public int getCodiMant() {
        return codiMant;
    }

    public void setCodiMant(int codiMant) {
        this.codiMant = codiMant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codiCorrMant;
        hash += (int) codiMant;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CorrelativoMantenimientosPK)) {
            return false;
        }
        CorrelativoMantenimientosPK other = (CorrelativoMantenimientosPK) object;
        if (this.codiCorrMant != other.codiCorrMant) {
            return false;
        }
        if (this.codiMant != other.codiMant) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.CorrelativoMantenimientosPK[ codiCorrMant=" + codiCorrMant + ", codiMant=" + codiMant + " ]";
    }
    
}
