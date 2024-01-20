package com.org.OnlineBusTicketBookingApplication.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtUtil {

    private static final int expireInMs = 300*1000;
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generate(String username){

        return Jwts.builder()
                .setSubject(username)
                .setIssuer("guvi.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireInMs))
                .signWith(key)
                .compact();
    }

    public boolean validate(String token){
        if(getUserName(token)!= null && isExpired(token)){
            return true;
        }return false;
    }

    private boolean isExpired(String token) {
        Claims claims= getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    public String getUserName(String token) {
        Claims claims= getClaims(token);
        return claims.getSubject();
    }

    private Claims getClaims(String token) {

        return Jwts.parser().setSigningKey(key)
                .parseClaimsJwt(token).getBody();
    }


}
