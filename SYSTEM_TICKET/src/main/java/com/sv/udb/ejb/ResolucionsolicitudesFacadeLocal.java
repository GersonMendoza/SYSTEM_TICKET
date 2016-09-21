/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.ejb;

import com.sv.udb.modelo.Resolucionsolicitudes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ResolucionsolicitudesFacadeLocal {

    void create(Resolucionsolicitudes resolucionsolicitudes);

    void edit(Resolucionsolicitudes resolucionsolicitudes);

    void remove(Resolucionsolicitudes resolucionsolicitudes);

    Resolucionsolicitudes find(Object id);

    List<Resolucionsolicitudes> findAll();

    List<Resolucionsolicitudes> findRange(int[] range);

    int count();
    
}
