/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.Procesomantenimientos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ProcesomantenimientosFacadeLocal {

    void create(Procesomantenimientos procesomantenimientos);

    void edit(Procesomantenimientos procesomantenimientos);

    void remove(Procesomantenimientos procesomantenimientos);

    Procesomantenimientos find(Object id);

    List<Procesomantenimientos> findAll();

    List<Procesomantenimientos> findRange(int[] range);

    int count();
    
}
