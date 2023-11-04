package com.fleetmanagement.fleet.Security.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTValidator 
{

    @Value("${jwt.secret}") 
    private String secretKey;


    public Claims validateToken(String token) 
    {
        try 
        {
            Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();

            if (isTokenExpired(claims.getExpiration())) 
            {
                return null; // Le token a expiré
            }

            return claims;
        } 
        catch (ExpiredJwtException | MalformedJwtException |  SignatureException e) {
            return null; // La validation a échoué
        }
    }

    private boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}
