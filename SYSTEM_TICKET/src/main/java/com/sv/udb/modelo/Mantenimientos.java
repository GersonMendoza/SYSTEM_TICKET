/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gersonfrancisco
 */
@Entity
@Table(name = "mantenimientos", catalog = "system_ticket", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimientos.findAll", query = "SELECT m FROM Mantenimientos m"),
    @NamedQuery(name = "Mantenimientos.findByCodiMant", query = "SELECT m FROM Mantenimientos m WHERE m.mantenimientosPK.codiMant = :codiMant"),
    @NamedQuery(name = "Mantenimientos.findByContDiasMant", query = "SELECT m FROM Mantenimientos m WHERE m.contDiasMant = :contDiasMant"),
    @NamedQuery(name = "Mantenimientos.findByCodiDepa", query = "SELECT m FROM Mantenimientos m WHERE m.mantenimientosPK.codiDepa = :codiDepa"),
    @NamedQuery(name = "Mantenimientos.findByCodiUbi", query = "SELECT m FROM Mantenimientos m WHERE m.codiUbi = :codiUbi"),
    @NamedQuery(name = "Mantenimientos.findByCodiTipoMant", query = "SELECT m FROM Mantenimientos m WHERE m.mantenimientosPK.codiTipoMant = :codiTipoMant"),
    @NamedQuery(name = "Mantenimientos.findByEstaMantPrev", query = "SELECT m FROM Mantenimientos m WHERE m.estaMantPrev = :estaMantPrev")})
public class Mantenimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MantenimientosPK mantenimientosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cont_dias_mant")
    private int contDiasMant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codi_ubi")
    private int codiUbi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_mant_prev")
    private boolean estaMantPrev;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mantenimientos", fetch = FetchType.LAZY)
    private List<CorrelativoMantenimientos> correlativoMantenimientosList;
    @JoinColumn(name = "codi_depa", referencedColumnName = "codi_depa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departamentos departamentos;
    @JoinColumn(name = "codi_tipo_mant", referencedColumnName = "codi_tipo_mant", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoMantenimientos tipoMantenimientos;

    public Mantenimientos() {
    }

    public Mantenimientos(MantenimientosPK mantenimientosPK) {
        this.mantenimientosPK = mantenimientosPK;
    }

    public Mantenimientos(MantenimientosPK mantenimientosPK, int contDiasMant, int codiUbi, boolean estaMantPrev) {
        this.mantenimientosPK = mantenimientosPK;
        this.contDiasMant = contDiasMant;
        this.codiUbi = codiUbi;
        this.estaMantPrev = estaMantPrev;
    }

    public Mantenimientos(int codiMant, int codiDepa, int codiTipoMant) {
        this.mantenimientosPK = new MantenimientosPK(codiMant, codiDepa, codiTipoMant);
    }

    public MantenimientosPK getMantenimientosPK() {
        return mantenimientosPK;
    }

    public void setMantenimientosPK(MantenimientosPK mantenimientosPK) {
        this.mantenimientosPK = mantenimientosPK;
    }

    public int getContDiasMant() {
        return contDiasMant;
    }

    public void setContDiasMant(int contDiasMant) {
        this.contDiasMant = contDiasMant;
    }

    public int getCodiUbi() {
        return codiUbi;
    }

    public void setCodiUbi(int codiUbi) {
        this.codiUbi = codiUbi;
    }

    public boolean getEstaMantPrev() {
        return estaMantPrev;
    }

    public void setEstaMantPrev(boolean estaMantPrev) {
        this.estaMantPrev = estaMantPrev;
    }

    @XmlTransient
    public List<CorrelativoMantenimientos> getCorrelativoMantenimientosList() {
        return correlativoMantenimientosList;
    }

    public void setCorrelativoMantenimientosList(List<CorrelativoMantenimientos> correlativoMantenimientosList) {
        this.correlativoMantenimientosList = correlativoMantenimientosList;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public TipoMantenimientos getTipoMantenimientos() {
        return tipoMantenimientos;
    }

    public void setTipoMantenimientos(TipoMantenimientos tipoMantenimientos) {
        this.tipoMantenimientos = tipoMantenimientos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mantenimientosPK != null ? mantenimientosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimientos)) {
            return false;
        }
        Mantenimientos other = (Mantenimientos) object;
        if ((this.mantenimientosPK == null && other.mantenimientosPK != null) || (this.mantenimientosPK != null && !this.mantenimientosPK.equals(other.mantenimientosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Mantenimientos[ mantenimientosPK=" + mantenimientosPK + " ]";
    }
    
}
