package com.fleetmanagement.fleet.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fleetmanagement.fleet.Security.JWT.Filter.JWTAuthorizationFilter;

@Component
public class FilterSecurityConfiguration 
{
    @Autowired
    private JWTAuthorizationFilter jwtAuthorizationFilter;


    @Bean
    public FilterRegistrationBean<JWTAuthorizationFilter> filterConfiguration(){
        FilterRegistrationBean<JWTAuthorizationFilter> registrationBean 
              = new FilterRegistrationBean<>();
            
        registrationBean.setFilter(jwtAuthorizationFilter);
     
        registrationBean.addUrlPatterns(

                             "/fleet/car", 
                                            "/fleet/car/*" ,
                                            "/fleet/user/*",
                                            "/fleet/user",
                                            "/fleet/carMileage",
                                            "/fleet/carMileage/*"
                                       );
        
        registrationBean.setOrder(1);

        return registrationBean;    
    }
}
