/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.Tipomantenimientos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface TipomantenimientosFacadeLocal {

    void create(Tipomantenimientos tipomantenimientos);

    void edit(Tipomantenimientos tipomantenimientos);

    void remove(Tipomantenimientos tipomantenimientos);

    Tipomantenimientos find(Object id);

    List<Tipomantenimientos> findAll();

    List<Tipomantenimientos> findRange(int[] range);

    int count();
    
}
