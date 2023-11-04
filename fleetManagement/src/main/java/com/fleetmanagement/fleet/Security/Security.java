package com.fleetmanagement.fleet.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fleetmanagement.fleet.Security.JWT.JWTAuthenticationFilter;
import com.fleetmanagement.fleet.Security.JWT.JwtAuthEntryPoint;
import com.fleetmanagement.fleet.Security.UserAuth.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class Security {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    JwtAuthEntryPoint authEntryPoint ;
    
    @Bean
    @SuppressWarnings("removal")
    public SecurityFilterChain filterChain ( HttpSecurity http) throws Exception
    {
         http
        .csrf(AbstractHttpConfigurer::disable)
        // JWT
        .exceptionHandling()
        .authenticationEntryPoint(authEntryPoint)
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeHttpRequests(
           auth -> {
                    auth.requestMatchers("/fleet/auth/register").permitAll();
                    auth.requestMatchers("/fleet/auth/login").permitAll();
                    auth.anyRequest().authenticated();
                   }
           ) ;
        

           http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

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

    @Bean
    public  JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }
}
