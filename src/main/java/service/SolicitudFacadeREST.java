/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.edu.uesocc.ingenieria.tpi.entity.OrdenTrabajo;
import com.edu.uesocc.ingenieria.tpi.entity.Solicitud;
import com.edu.uesocc.ingenieria.tpi.facade.EstadoSolicitud;
import com.edu.uesocc.ingenieria.tpi.facade.Ticket;
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
@Path("solicitud")
public class SolicitudFacadeREST extends AbstractFacade<Solicitud> {

    @PersistenceContext(unitName = "com.edu.uesocc.ingenieria.tpi_MantenimientoTpi_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public SolicitudFacadeREST() {
        super(Solicitud.class);
    }
    
    @GET
    @Path("generarticket")
    @Produces({MediaType.APPLICATION_JSON})
    public Ticket generarTicket(){
        Ticket t = new Ticket();
    t.setTicket(1+em.createNativeQuery("select  max(solicitud.id_solicitud) as maximo from solicitud").getResultList().get(0).hashCode());
    return t;
    }
    
    
    @GET
    @Path("idSolicitud/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public EstadoSolicitud findSolicitud(@PathParam("id") Integer id){
     EstadoSolicitud e= new EstadoSolicitud();
     List<OrdenTrabajo> o ;
     o = em.createNamedQuery("OrdenTrabajo.findByIdSolicitud").setParameter("IdSolicitud", id).getResultList();
     if(o.isEmpty()){
         e.setEstado("Solicitud aun No Aprobada!");
     return e;
     }
     else{
         e.setEstado("Solicitud Aprobada!");
     return e;
     }
     
     
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public Solicitud create(Solicitud entity) {
       return super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Solicitud entity) {
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
    public Solicitud find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Solicitud> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Solicitud> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
