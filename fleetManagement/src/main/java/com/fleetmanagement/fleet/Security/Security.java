package com.fleetmanagement.fleet.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.fleetmanagement.fleet.Security.JWT.Filter.JWTAuthorizationFilter;


@Configuration
@EnableWebSecurity
public class Security 
{
    @Autowired
    private JWTAuthorizationFilter jwtAuthorizationFilter;

    
    @Bean
    @SuppressWarnings("removal")
    public SecurityFilterChain filterChain ( HttpSecurity http) throws Exception
    {
         http
        //  required
        .csrf(AbstractHttpConfigurer::disable)
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        // routes
        .authorizeHttpRequests(
           auth -> {
                        // we authorize any request but filter will manage the authentification
                        // and authorization for different request
                        auth.anyRequest().permitAll() ;
                   }
           ) ;

        return http.build() ;
        
    }


// required
    @Bean
    public BCryptPasswordEncoder passwordEncoder ()
    {
        return new BCryptPasswordEncoder() ;
    }

    @Bean
    public FilterRegistrationBean<JWTAuthorizationFilter> filterConfiguration(){
        FilterRegistrationBean<JWTAuthorizationFilter> registrationBean 
              = new FilterRegistrationBean<>();
            
        registrationBean.setFilter(jwtAuthorizationFilter);
     
        registrationBean.addUrlPatterns("/fleet/car", "/fleet/car/*");
        
        registrationBean.setOrder(1);

        return registrationBean;    
    }



}
