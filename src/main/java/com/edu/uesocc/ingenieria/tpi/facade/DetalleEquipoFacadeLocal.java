/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.facade;

import com.edu.uesocc.ingenieria.tpi.entity.DetalleEquipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fer
 */
@Local
public interface DetalleEquipoFacadeLocal {

    void create(DetalleEquipo detalleEquipo);

    void edit(DetalleEquipo detalleEquipo);

    void remove(DetalleEquipo detalleEquipo);

    DetalleEquipo find(Object id);

    List<DetalleEquipo> findAll();

    List<DetalleEquipo> findRange(int[] range);

    int count();
    
}
