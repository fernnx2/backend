/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.edu.uesocc.ingenieria.tpi.entity.Modelo;
import com.edu.uesocc.ingenieria.tpi.facade.ModeloFacadeLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fer
 */
@Stateless
@Path("modelo")
public class ModeloFacadeREST extends AbstractFacade<Modelo> {

    @PersistenceContext(unitName = "com.edu.uesocc.ingenieria.tpi_MantenimientoTpi_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @Inject
    private ModeloFacadeLocal mfl;
    
    public ModeloFacadeREST() {
        super(Modelo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Modelo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Modelo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Modelo find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("modelo/{modelo}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modelo> findByName(@PathParam("modelo") String modelo){
        if( modelo != null) {
        return this.mfl.findAllByName(modelo);
        }
        else{
        return null;
        }
    
    }
    

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modelo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Modelo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
