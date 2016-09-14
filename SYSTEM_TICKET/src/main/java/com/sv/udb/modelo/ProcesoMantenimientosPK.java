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
public class ProcesoMantenimientosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "codi_proc_mant")
    private int codiProcMant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codi_corr_mant")
    private int codiCorrMant;

    public ProcesoMantenimientosPK() {
    }

    public ProcesoMantenimientosPK(int codiProcMant, int codiCorrMant) {
        this.codiProcMant = codiProcMant;
        this.codiCorrMant = codiCorrMant;
    }

    public int getCodiProcMant() {
        return codiProcMant;
    }

    public void setCodiProcMant(int codiProcMant) {
        this.codiProcMant = codiProcMant;
    }

    public int getCodiCorrMant() {
        return codiCorrMant;
    }

    public void setCodiCorrMant(int codiCorrMant) {
        this.codiCorrMant = codiCorrMant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codiProcMant;
        hash += (int) codiCorrMant;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoMantenimientosPK)) {
            return false;
        }
        ProcesoMantenimientosPK other = (ProcesoMantenimientosPK) object;
        if (this.codiProcMant != other.codiProcMant) {
            return false;
        }
        if (this.codiCorrMant != other.codiCorrMant) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.ProcesoMantenimientosPK[ codiProcMant=" + codiProcMant + ", codiCorrMant=" + codiCorrMant + " ]";
    }
    
}
