/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.facade;

import com.edu.uesocc.ingenieria.tpi.entity.Modelo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fer
 */
@Local
public interface ModeloFacadeLocal {

    void create(Modelo modelo);

    void edit(Modelo modelo);

    void remove(Modelo modelo);

    Modelo find(Object id);

    List<Modelo> findAll();

    List<Modelo> findRange(int[] range);

    int count();
    
}
