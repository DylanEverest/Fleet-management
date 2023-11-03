package com.fleetmanagement.fleet.Controllers.UserAuth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmanagement.fleet.Entities.User.Roles;
import com.fleetmanagement.fleet.Entities.User.User;
import com.fleetmanagement.fleet.Repositories.User.RolesRepository;
import com.fleetmanagement.fleet.Repositories.User.UserRepository;

@RestController
@RequestMapping("/fleet/auth")
public class UserAuthController 
{
    
    @Autowired
    private AuthenticationManager authenticationManager ;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userRepository.existsByUserName(user.getUserName())) 
        {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        Roles roles = roleRepository.findByRoleName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody User user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                user.getUserName(),
                user.getPassword()));
                
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

}
