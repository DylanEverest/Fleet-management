package com.fleetmanagement.fleet.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.fleetmanagement.fleet.Security.UserAuth.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class Security {

    @Autowired
    CustomUserDetailsService customUserDetailsService;
    
    
    @Bean
    public SecurityFilterChain filterChain ( HttpSecurity http) throws Exception
    {
         http
        .csrf().disable()
        .authorizeHttpRequests(
           auth -> {
                    auth.requestMatchers("/fleet/auth/register").permitAll();
                    auth.anyRequest().authenticated();
                   }
           ) ;
        
        return http.build() ;
            
        
    }


    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder ()
    {
        return new BCryptPasswordEncoder() ;
    }
}