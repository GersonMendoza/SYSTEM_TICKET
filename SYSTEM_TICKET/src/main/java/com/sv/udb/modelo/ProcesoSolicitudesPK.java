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
public class ProcesoSolicitudesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "codi_proc_soli")
    private int codiProcSoli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codi_soli")
    private int codiSoli;

    public ProcesoSolicitudesPK() {
    }

    public ProcesoSolicitudesPK(int codiProcSoli, int codiSoli) {
        this.codiProcSoli = codiProcSoli;
        this.codiSoli = codiSoli;
    }

    public int getCodiProcSoli() {
        return codiProcSoli;
    }

    public void setCodiProcSoli(int codiProcSoli) {
        this.codiProcSoli = codiProcSoli;
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
        hash += (int) codiProcSoli;
        hash += (int) codiSoli;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoSolicitudesPK)) {
            return false;
        }
        ProcesoSolicitudesPK other = (ProcesoSolicitudesPK) object;
        if (this.codiProcSoli != other.codiProcSoli) {
            return false;
        }
        if (this.codiSoli != other.codiSoli) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.ProcesoSolicitudesPK[ codiProcSoli=" + codiProcSoli + ", codiSoli=" + codiSoli + " ]";
    }
    
}
