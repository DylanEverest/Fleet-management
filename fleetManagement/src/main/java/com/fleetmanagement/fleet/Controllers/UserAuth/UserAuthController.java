package com.fleetmanagement.fleet.Controllers.UserAuth;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmanagement.fleet.Entities.User.Roles;
import com.fleetmanagement.fleet.Entities.User.User;
import com.fleetmanagement.fleet.Repositories.User.RolesRepository;
import com.fleetmanagement.fleet.Repositories.User.UserRepository;
import com.fleetmanagement.fleet.Security.JWT.JWTGenerator;
import com.fleetmanagement.fleet.Services.Authentification.UserAuthentification;

@RestController
@RequestMapping("/fleet/auth")
public class UserAuthController 
{
    

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTGenerator jwtGenerator;

    @Autowired
    private UserAuthentification userAuthentification ;


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userRepository.existsByUserName(user.getUserName())) 
        {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Roles roles = roleRepository.findByRoleName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        // login check
        User dbUser = userAuthentification.login(user);

        if ( dbUser!=null ) 
        {
            String token = jwtGenerator.generateToken(dbUser.getEmail(), dbUser.getUserName(), dbUser.getRo());

            // Renvoyez le token JWT dans la réponse
            Map<String, String> response = new HashMap<>();
            response.put("accessToken", token);
            response.put("tokenType", "Bearer");

            return ResponseEntity.ok(response);
        } else {
            // Informations d'identification non valides, renvoyez une réponse d'erreur
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // @PostMapping("login")
    // public ResponseEntity<?> login(@RequestBody User user){

    //     Authentication authentication = null ;
    //     try 
    //     {
    //         authentication = authenticationManager.authenticate(
    //             new UsernamePasswordAuthenticationToken(
    //             user.getUserName(),
    //             user.getPassword()));            
    //     } 
    //     catch (AuthenticationException e) 
    //     {
    //         return new ResponseEntity<>( null ,HttpStatus.BAD_REQUEST);
    //     }


    //     SecurityContextHolder.getContext().setAuthentication(authentication);
    //     // return new ResponseEntity<String>("User signed success", HttpStatus.OK);
    //     String token = jwtGenerator.generateToken(authentication);

    //     return new ResponseEntity<AuthResponseDTO>(new AuthResponseDTO(token), HttpStatus.OK);
    // }

}
