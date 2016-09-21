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
public class ResolucionsolicitudesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codi_reso_soli")
    private int codiResoSoli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codi_soli")
    private int codiSoli;

    public ResolucionsolicitudesPK() {
    }

    public ResolucionsolicitudesPK(int codiResoSoli, int codiSoli) {
        this.codiResoSoli = codiResoSoli;
        this.codiSoli = codiSoli;
    }

    public int getCodiResoSoli() {
        return codiResoSoli;
    }

    public void setCodiResoSoli(int codiResoSoli) {
        this.codiResoSoli = codiResoSoli;
    }

    public int getCodiSoli() {
        return codiSoli;
    }

    public void setCodiSoli(int codiSoli) {
        this.codiSoli = codiSoli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codiResoSoli;
        hash += (int) codiSoli;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResolucionsolicitudesPK)) {
            return false;
        }
        ResolucionsolicitudesPK other = (ResolucionsolicitudesPK) object;
        if (this.codiResoSoli != other.codiResoSoli) {
            return false;
        }
        if (this.codiSoli != other.codiSoli) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.ResolucionsolicitudesPK[ codiResoSoli=" + codiResoSoli + ", codiSoli=" + codiSoli + " ]";
    }
    
}
