/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adsi.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Ricardo
 */
@javax.ws.rs.ApplicationPath("resources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.adsi.rest.CustomerFacadeREST.class);
        resources.add(com.adsi.rest.DiscountCodeFacadeREST.class);
        resources.add(com.adsi.rest.ManufacturerFacadeREST.class);
        resources.add(com.adsi.rest.MicroMarketFacadeREST.class);
        resources.add(com.adsi.rest.ProductCodeFacadeREST.class);
        resources.add(com.adsi.rest.ProductFacadeREST.class);
        resources.add(com.adsi.rest.PurchaseOrderFacadeREST.class);
    }
    
}
