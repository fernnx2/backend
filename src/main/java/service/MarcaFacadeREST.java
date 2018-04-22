/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.edu.uesocc.ingenieria.tpi.entity.Marca;
import com.edu.uesocc.ingenieria.tpi.facade.MarcaFacadeLocal;
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
@Path("marca")
public class MarcaFacadeREST extends AbstractFacade<Marca> {

    @PersistenceContext(unitName = "com.edu.uesocc.ingenieria.tpi_MantenimientoTpi_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @Inject
    MarcaFacadeLocal mfl;

    public MarcaFacadeREST() {
        super(Marca.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Marca entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Marca entity) {
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
    public Marca find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Marca> findAll() {
        return super.findAll();
    }

    
    @GET
    @Path("marca/{marca}")
    @Produces({MediaType.APPLICATION_JSON})
    public Marca findByName(@PathParam("marca") String nombre){
     if(nombre != null){
     return this.mfl.findByName(nombre);
     }
     else{
     return null;
     }
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
