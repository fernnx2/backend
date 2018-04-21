/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.facade;

import java.util.List;

/**
 *
 * @author fer
 */
public interface InterfaceFacade<T> {
    
   T create(T entity);
    
   T edit(T entity);
    
   T remove(T entity);
    
   T find(Object a);
    
   List<T> findAll();
    
   List<T> findRange(int[] range) ;
    
   int count();
    
}
