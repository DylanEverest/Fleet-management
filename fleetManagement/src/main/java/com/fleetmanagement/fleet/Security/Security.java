package com.fleetmanagement.fleet.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class Security {

    
    @Bean
    public SecurityFilterChain filterChain ( HttpSecurity http) throws Exception
    {
        //  http
        // .csrf(AbstractHttpConfigurer::disable)
        // // JWT
        // .exceptionHandling()
        // .authenticationEntryPoint(authEntryPoint)
        // .and()
        // .sessionManagement()
        // .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        // .and()
        // .authorizeHttpRequests(
        //    auth -> {
        //             auth.requestMatchers("/fleet/auth/register").permitAll();
        //             auth.requestMatchers("/fleet/auth/login").permitAll();
        //             auth.anyRequest().authenticated();
        //            }
        //    ) ;
        


        return http.build() ;
            
        
    }







}
