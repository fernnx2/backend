/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.facade;

import com.edu.uesocc.ingenieria.tpi.entity.OrdenTrabajoPorTrabajadores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fer
 */
@Stateless
public class OrdenTrabajoPorTrabajadoresFacade extends AbstractFacade<OrdenTrabajoPorTrabajadores> implements OrdenTrabajoPorTrabajadoresFacadeLocal {

    @PersistenceContext(unitName = "com.edu.uesocc.ingenieria.tpi_MantenimientoTpi_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenTrabajoPorTrabajadoresFacade() {
        super(OrdenTrabajoPorTrabajadores.class);
    }
    
}
