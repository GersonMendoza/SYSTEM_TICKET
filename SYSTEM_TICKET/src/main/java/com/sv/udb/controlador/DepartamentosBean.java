/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Departamentos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.primefaces.context.RequestContext;

/**
 *
 * @author gersonfrancisco
 */
@Named(value = "departamentosBean")
@ViewScoped
public class DepartamentosBean {
    private Departamentos objeDepa;
    private List<Departamentos> listDepa;
    private boolean guardar;

    public Departamentos getObjeDepa() {
        return objeDepa;
    }

    public void setObjeDepa(Departamentos objeDepa) {
        this.objeDepa = objeDepa;
    }
    
    public boolean isGuardar() {
        return guardar;
    }

    public List<Departamentos> getListDepa() {
        return listDepa;
    }
    
    /**
     * Creates a new instance of AlumnosBean
     */
    
    public DepartamentosBean() {
    }
    
    @PostConstruct
    public void init()
    {
        this.objeDepa = new Departamentos();
        this.guardar = true;
        this.consTodo();
    }
    public void limpForm()
    {
        this.objeDepa = new Departamentos();
        this.guardar = true;        
    }
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PILETPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(this.objeDepa);
            tx.commit();
            this.guardar = true;
            this.listDepa.add(this.objeDepa); //Agrega el objeto a la lista para poderse mostrar en tabla
            this.objeDepa = new Departamentos(); // Limpiar
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos guardados')");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al guardar ')");
            tx.rollback();
        }
        finally
        {
            em.close();
            emf.close();            
        }
    }
    
    public void consTodo()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PILETPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            this.listDepa = em.createNamedQuery("Departamentos.findAll", Departamentos.class).getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
    }
}
