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
public interface ModeloFacadeLocal extends InterfaceFacade<Modelo>{
  
  List<Modelo> findAllByName(String nombre);  
}
