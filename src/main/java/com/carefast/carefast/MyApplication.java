/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carefast.carefast;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import org.eclipse.jetty.servlets.CrossOriginFilter;

/**
 *
 * @author Ghazi
 */

public class MyApplication extends Application<MyConfiguration> {
    
        public static void main(String[] args) throws Exception {
            new MyApplication().run(args);
        }
        
        @Override
        public String getName(){
            return "Hello World!";
        }
        
        @Override
        public void initialize(Bootstrap<MyConfiguration> bootstrap) {
        // nothing to do yet
        }
        
        private void configureCors(Environment environment) {
            FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
            filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
            filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
            filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
            filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
            filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
            filter.setInitParameter("allowCredentials", "true");
        }
        
        @Override
        public void run(MyConfiguration configuration,
                        Environment environment) {
            configureCors(environment);
            MyResource resource = new MyResource(        
                    configuration.getTemplate(),
                    configuration.getDefaultName()
            );
            DatabaseResourceFactory dbResource = new DatabaseResourceFactory();

            environment.jersey().register(dbResource);
        }
}
