/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uesocc.ingenieria.tpi.facade;

import com.edu.uesocc.ingenieria.tpi.entity.Marca;
import java.util.List;
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
public class AbstractFacadeTest {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Marca m1,m2,m3;
    
    public AbstractFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        emf = Persistence.createEntityManagerFactory("mantenimientoTestPU");
        em = emf.createEntityManager();
        m1 = new Marca(1,"hp","asdf");
        m2 = new Marca(2,"dell","desc");
        m3 = new Marca(3,"lenovo","asdc");
        
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


    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        MarcaFacade instance = new MarcaFacade();
        Whitebox.setInternalState(instance,"em" , em);
        //insertando las entitis en la bd
        instance.getEntityManager().getTransaction().begin();
        Marca result = instance.create(m1);
        Marca result2 = instance.create(m2);
        Marca result3 = instance.create(m3);
        instance.getEntityManager().getTransaction().commit();
        
        assertNotNull(result);
        assertNotNull(result2);
        assertNotNull(result3);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    
    @Test
    public void testCreate_null(){
    
        System.out.println("create null error");
        MarcaFacade instance = new MarcaFacade();
        Whitebox.setInternalState(instance,"em" , em);
        //insertando las entitis en la bd
        
        instance.getEntityManager().getTransaction().begin();
        Marca result = instance.create(null);
        Marca result2 = instance.create(null);
        Marca result3 = instance.create(null);
        instance.getEntityManager().getTransaction().commit();
        
        assertNull(result);
        assertNull(result2);
        assertNull(result3);
        
    }
    
    
    /**
     * Test of edit method, of class MarcaFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        MarcaFacade instance = new MarcaFacade();
        Whitebox.setInternalState(instance,"em" , em);
        Marca entity = new Marca(2,"acer","desc");
        Marca expResult = new Marca(2,"acer","desc");
        //insertando
        instance.getEntityManager().getTransaction().begin();
        instance.create(m1);
        instance.create(m2);
        instance.create(m3);
        instance.getEntityManager().getTransaction().commit();
        //editando
        instance.getEntityManager().getTransaction().begin();
        Marca resultEdit = instance.edit(entity);
        instance.getEntityManager().getTransaction().commit();
        assertEquals(expResult, resultEdit);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
        @Test
    public void testEdit_null() {
        System.out.println("edit");
        MarcaFacade instance = new MarcaFacade();
        Whitebox.setInternalState(instance,"em" , em);
        Marca expResult = null;
        //insertando
        instance.getEntityManager().getTransaction().begin();
        instance.create(m1);
        instance.create(m2);
        instance.create(m3);
        instance.getEntityManager().getTransaction().commit();
        //editando
        instance.getEntityManager().getTransaction().begin();
        Marca resultEdit = instance.edit(null);
        instance.getEntityManager().getTransaction().commit();
        assertEquals(expResult, resultEdit);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
    
    
//
//    /**
//     * Test of remove method, of class MarcaFacade.
//     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Marca entity = new Marca(1,"dell","desc");
        Marca expResult = new Marca(1,"dell","desc");
        MarcaFacade instance = new MarcaFacade();
        Whitebox.setInternalState(instance,"em",em);
        //insertando
        instance.getEntityManager().getTransaction().begin();
        instance.create(m1);
        instance.create(m2);
        instance.create(m3);
        instance.getEntityManager().getTransaction().commit();
        //editando
        instance.getEntityManager().getTransaction().begin();
        Marca resultRemove = instance.remove(entity);
        instance.getEntityManager().getTransaction().commit();
        assertEquals(resultRemove,expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
      @Test
    public void testRemove_null() {
        System.out.println("remove");
        
        Marca expResult = null;
        MarcaFacade instance = new MarcaFacade();
        Whitebox.setInternalState(instance,"em",em);
        //insertando
        instance.getEntityManager().getTransaction().begin();
        instance.create(m1);
        instance.create(m2);
        instance.create(m3);
        instance.getEntityManager().getTransaction().commit();
        //editando
        instance.getEntityManager().getTransaction().begin();
        Marca resultRemove = instance.remove(null);
        instance.getEntityManager().getTransaction().commit();
        assertEquals(resultRemove,expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
//
//    /**
//     * Test of find method, of class MarcaFacade.
//     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = 3;
        MarcaFacade instance = new MarcaFacade();
        Whitebox.setInternalState(instance,"em", em);
        //insertando
        instance.getEntityManager().getTransaction().begin();
        instance.create(m1);
        instance.create(m2);
        instance.create(m3);
        instance.getEntityManager().getTransaction().commit();
        //buscando
        Marca expResult = new Marca(3,"lenovo","asdc");
        Marca result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    
//
//    /**
//     * Test of findAll method, of class MarcaFacade.
//     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        MarcaFacade instance = new MarcaFacade();
        Whitebox.setInternalState(instance,"em", em);
        instance.getEntityManager().getTransaction().begin();
        instance.create(m1);
        instance.create(m2);
        instance.create(m3);
        instance.getEntityManager().getTransaction().commit();
        int expResult = 3;
        List<Marca> result = instance.findAll();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of findRange method, of class MarcaFacade.
//     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = {1,2};
        MarcaFacade instance = new MarcaFacade();
        Whitebox.setInternalState(instance,"em", em);
        instance.getEntityManager().getTransaction().begin();
        instance.create(m1);
        instance.create(m2);
        instance.create(m3);
        instance.getEntityManager().getTransaction().commit();
        int expResult = 2;
        List<Marca> result = instance.findRange(range);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of count method, of class MarcaFacade.
//     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        MarcaFacade instance = new MarcaFacade();
        Whitebox.setInternalState(instance, "em", em);
        instance.getEntityManager().getTransaction().begin();
        instance.create(m1);
        instance.create(m2);
        instance.create(m3);
        instance.getEntityManager().getTransaction().commit();
        int expResult = 3;
        int result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    

   
    
}
