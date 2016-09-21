/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.Correlativomantenimientos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface CorrelativomantenimientosFacadeLocal {

    void create(Correlativomantenimientos correlativomantenimientos);

    void edit(Correlativomantenimientos correlativomantenimientos);

    void remove(Correlativomantenimientos correlativomantenimientos);

    Correlativomantenimientos find(Object id);

    List<Correlativomantenimientos> findAll();

    List<Correlativomantenimientos> findRange(int[] range);

    int count();
    
}
