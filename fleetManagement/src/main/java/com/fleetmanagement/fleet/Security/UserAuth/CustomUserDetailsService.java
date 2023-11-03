package com.fleetmanagement.fleet.Security.UserAuth;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fleetmanagement.fleet.Entities.User.Roles;
import com.fleetmanagement.fleet.Entities.User.User;
import com.fleetmanagement.fleet.Repositories.User.UserRepository;



@Service
public class CustomUserDetailsService  implements UserDetailsService
{

    @Autowired
    UserRepository userRepository ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("User not found")) ;

        return new org.springframework.security.core.userdetails.User
            (
                user.getUserName(),
                user.getPassword() ,
                mapRolesToAuthorities(user.getRoles())
            ) ;

    }


    private Collection<GrantedAuthority> mapRolesToAuthorities(List <Roles> roles) 
    {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
    
}
