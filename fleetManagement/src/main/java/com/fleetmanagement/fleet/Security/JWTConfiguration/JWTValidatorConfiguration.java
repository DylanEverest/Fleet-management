package com.fleetmanagement.fleet.Security.JWTConfiguration;

import org.springframework.stereotype.Component;

import com.fleetmanagement.fleet.Security.JWT.JWTValidator;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JWTValidatorConfiguration extends JWTValidator{
    
    public String getUsernameFromJWT(String token)
    {
        try 
        {
            Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    
            String username = claims.get("username", String.class);
            return username;
        } 
        catch (SignatureException e) 
        {
            return null;
        }
    }
    
    public Double getRoleFromJWT(String token) {
        
        try 
        {
            Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    
            String role = claims.get("role", String.class);

            return Double.parseDouble(role);
        } 
        catch (SignatureException e) 
        {
            return null;
        }    
    }
}
