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
public class SolicitudesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "codi_soli")
    private int codiSoli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codi_depa")
    private int codiDepa;

    public SolicitudesPK() {
    }

    public SolicitudesPK(int codiSoli, int codiDepa) {
        this.codiSoli = codiSoli;
        this.codiDepa = codiDepa;
    }

    public int getCodiSoli() {
        return codiSoli;
    }

    public void setCodiSoli(int codiSoli) {
        this.codiSoli = codiSoli;
    }

    public int getCodiDepa() {
        return codiDepa;
    }

    public void setCodiDepa(int codiDepa) {
        this.codiDepa = codiDepa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codiSoli;
        hash += (int) codiDepa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudesPK)) {
            return false;
        }
        SolicitudesPK other = (SolicitudesPK) object;
        if (this.codiSoli != other.codiSoli) {
            return false;
        }
        if (this.codiDepa != other.codiDepa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.SolicitudesPK[ codiSoli=" + codiSoli + ", codiDepa=" + codiDepa + " ]";
    }
    
}
