/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carefast.carefast;

import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ghazi
 */
@Path("hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public MyResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @Path("/hello-world")
    @POST
    public Response sayHello() {        
        String s = "Hello World"; 
        return Response.ok(s).build();
    }
    
    @Path("/hello2")
    @GET
    public Response sayHello2() {        
        String s = "Hello World versi 2"; 
        return Response.ok(s).build();
    }
    
}
