/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.Procesosolicitudes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ProcesosolicitudesFacadeLocal {

    void create(Procesosolicitudes procesosolicitudes);

    void edit(Procesosolicitudes procesosolicitudes);

    void remove(Procesosolicitudes procesosolicitudes);

    Procesosolicitudes find(Object id);

    List<Procesosolicitudes> findAll();

    List<Procesosolicitudes> findRange(int[] range);

    int count();
    
}
