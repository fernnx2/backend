/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.facade;

import com.edu.uesocc.ingenieria.tpi.entity.Modelo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.powermock.reflect.Whitebox;

/**
 *
 * @author fer
 */
public class ModeloFacadeTest {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Modelo m1,m2,m3;
    
    public ModeloFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("mantenimientoTestPU");
        em = emf.createEntityManager();
        m1 = new Modelo(1,"hp","asdf");
        m2 = new Modelo(2,"dell","desc");
        m3 = new Modelo(3,"lenovo","asdc");
    }
    
    @AfterClass
    public static void tearDownClass() {
        em.clear();
        em.close();
        emf.close();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

 

    /**
     * Test of findByName method, of class ModeloFacade.
     */
    @Test
    public void testFindByName() throws Exception {
        System.out.println("findByName");
        String modelo = "dell";
        ModeloFacade instance = new ModeloFacade();
        Whitebox.setInternalState(instance,"em", em);
        //insertando
        instance.getEntityManager().getTransaction().begin();
        instance.create(m1);
        instance.create(m2);
        instance.create(m3);
        instance.getEntityManager().getTransaction().commit();
        Modelo expResult = m2;
        Modelo result = instance.findByName(modelo);
        assertEquals(expResult, result);
        System.out.println("Modelo esperado" + expResult.getModelo()+ " Modelo obtenido" + result.getModelo());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
