/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.Evaluacionresoluciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EvaluacionresolucionesFacadeLocal {

    void create(Evaluacionresoluciones evaluacionresoluciones);

    void edit(Evaluacionresoluciones evaluacionresoluciones);

    void remove(Evaluacionresoluciones evaluacionresoluciones);

    Evaluacionresoluciones find(Object id);

    List<Evaluacionresoluciones> findAll();

    List<Evaluacionresoluciones> findRange(int[] range);

    int count();
    
}
