/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.edu.uesocc.ingenieria.tpi.entity.EstadoDetalleMantenimiento;
import java.util.List;
import javax.ejb.Stateless;
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
@Path("estadodetallemantenimiento")
public class EstadoDetalleMantenimientoFacadeREST extends AbstractFacade<EstadoDetalleMantenimiento> {

    @PersistenceContext(unitName = "com.edu.uesocc.ingenieria.tpi_MantenimientoTpi_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public EstadoDetalleMantenimientoFacadeREST() {
        super(EstadoDetalleMantenimiento.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public EstadoDetalleMantenimiento create(EstadoDetalleMantenimiento entity) {
        return super.create(entity);
    }
    
    @GET
    @Path("mantenimientoterminado")
    @Produces({MediaType.APPLICATION_JSON})
    public List<EstadoDetalleMantenimiento> mantenimientoTerminado(){
    return em.createNamedQuery("EstadoDetalleMantenimiento.findByEstado").setParameter("estado", "terminado").getResultList();
    }
    
    @GET
    @Path("mantenimientonoterminado")
    @Produces({MediaType.APPLICATION_JSON})
    public List<EstadoDetalleMantenimiento> mantenimientoNoTerminado(){
    return em.createNamedQuery("EstadoDetalleMantenimiento.findByEstado").setParameter("estado", "en proceso").getResultList();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, EstadoDetalleMantenimiento entity) {
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
    public EstadoDetalleMantenimiento find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<EstadoDetalleMantenimiento> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<EstadoDetalleMantenimiento> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
