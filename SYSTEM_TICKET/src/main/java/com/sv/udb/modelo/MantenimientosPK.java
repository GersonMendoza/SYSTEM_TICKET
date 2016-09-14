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
public class MantenimientosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "codi_mant")
    private int codiMant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codi_depa")
    private int codiDepa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codi_tipo_mant")
    private int codiTipoMant;

    public MantenimientosPK() {
    }

    public MantenimientosPK(int codiMant, int codiDepa, int codiTipoMant) {
        this.codiMant = codiMant;
        this.codiDepa = codiDepa;
        this.codiTipoMant = codiTipoMant;
    }

    public int getCodiMant() {
        return codiMant;
    }

    public void setCodiMant(int codiMant) {
        this.codiMant = codiMant;
    }

    public int getCodiDepa() {
        return codiDepa;
    }

    public void setCodiDepa(int codiDepa) {
        this.codiDepa = codiDepa;
    }

    public int getCodiTipoMant() {
        return codiTipoMant;
    }

    public void setCodiTipoMant(int codiTipoMant) {
        this.codiTipoMant = codiTipoMant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codiMant;
        hash += (int) codiDepa;
        hash += (int) codiTipoMant;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MantenimientosPK)) {
            return false;
        }
        MantenimientosPK other = (MantenimientosPK) object;
        if (this.codiMant != other.codiMant) {
            return false;
        }
        if (this.codiDepa != other.codiDepa) {
            return false;
        }
        if (this.codiTipoMant != other.codiTipoMant) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.MantenimientosPK[ codiMant=" + codiMant + ", codiDepa=" + codiDepa + ", codiTipoMant=" + codiTipoMant + " ]";
    }
    
}
