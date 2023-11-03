package com.fleetmanagement.fleet.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {
    
    @Bean
    public SecurityFilterChain filterChain ( HttpSecurity http) throws Exception
    {
        return http.authorizeHttpRequests(
            auth -> {
                        auth.requestMatchers("/admin").hasRole("ADMIN");
                        auth.requestMatchers("/user").hasRole("USER");
                        auth.anyRequest().authenticated();
                    }
            ).
            
            formLogin(Customizer.withDefaults()).build();
        
    }

    @Bean
    public UserDetailsService users()
    {
        UserDetails user = User.builder().username("user").password(passwordEncoder().encode("123")).roles("USER").build() ;
        UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("123")).roles("ADMIN").build() ;

        return new InMemoryUserDetailsManager(user ,admin);

    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder ()
    {
        return new BCryptPasswordEncoder() ;
    }
}
