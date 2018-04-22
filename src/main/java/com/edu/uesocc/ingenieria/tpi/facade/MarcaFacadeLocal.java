/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.facade;

import com.edu.uesocc.ingenieria.tpi.entity.Marca;
import javax.ejb.Local;

/**
 *
 * @author fer
 */
@Local
public interface MarcaFacadeLocal extends InterfaceFacade<Marca>{

    Marca findByName(String nombre);
    
}
