package com.fleetmanagement.fleet.Controllers.UserAuth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmanagement.fleet.DTO.User.UserDTO;
import com.fleetmanagement.fleet.Entities.User.User;
import com.fleetmanagement.fleet.Entities.User.UserException;
import com.fleetmanagement.fleet.Security.JWT.utils.JWTGenerator;
import com.fleetmanagement.fleet.Services.Authentification.LoginException;
import com.fleetmanagement.fleet.Services.Authentification.UserAuthentification;
import com.fleetmanagement.fleet.Services.Register.RegisterException;
import com.fleetmanagement.fleet.Services.Register.RegisterService;

@RestController
@RequestMapping("/fleet/auth")
public class UserAuthController 
{
    

    @Autowired
    RegisterService registerService ;


    @Autowired
    private JWTGenerator jwtGenerator;

    @Autowired
    private UserAuthentification userAuthentification ;


    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) 
    {
        try
        {
            User user = userDTO.getUser();

            registerService.registerUser(user);
        }
        catch(RegisterException | UserException e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials");
        }

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);

    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {

        // login check

        User dbUser;

        try 
        {
            dbUser = userAuthentification.login(userDTO);
        } 
        catch (LoginException e) 
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        // Generate token based on email , username , role
        String token = jwtGenerator.generateToken(dbUser.getEmail(), dbUser.getUserName(), dbUser.getRoles().toString());

        // return token to client
        Map<String, String> response = new HashMap<>();
            response.put("accessToken", token);
            response.put("tokenType", "Bearer");
        
        return ResponseEntity.ok(response);

    }


}
