/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.rest;

import com.adsi.modelo.Customer;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ricardo
 */
@Stateless
@Path("customer")
public class CustomerFacadeREST extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "restAPIPU")
    private EntityManager em;

    public CustomerFacadeREST() {
        super(Customer.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Customer entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Customer entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("/id/{id}")
    @Produces({MediaType.APPLICATION_XML})
    public Customer find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("/query")
    @Produces({MediaType.APPLICATION_XML})
    public Customer findQuery(@QueryParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Path("list")
    @Produces({MediaType.APPLICATION_XML})
    public List<Customer> findAll() {
        return super.findAll();
    }
    
    //
    @GET
    @Path("/discount/{codigo}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Customer> findByDiscountCode( @PathParam("codigo")  String codigo ) {
        return  em.createNamedQuery("Customer.findByDiscountCode")
                .setParameter("codigo", codigo)
                .getResultList()   ;
    }
    
    
    //
    @GET
    @Path("/like/{nombre}")
    @Produces({MediaType.APPLICATION_XML})
    public List<Customer> findByLikeName( @PathParam("nombre")  String nombre ) {
        return  em.createNamedQuery("Customer.findByLikeName")
                .setParameter("nombre", '%'+nombre+'%')
                .getResultList()   ;
    }
    
    

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Customer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
