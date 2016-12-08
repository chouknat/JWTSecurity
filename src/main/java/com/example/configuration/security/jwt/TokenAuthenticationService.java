package com.example.configuration.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by a576097 on 06/12/2016.
 */
public class TokenAuthenticationService {

    private static final long EXPIRATIONTIME = 1000 * 60 * 60; // 1 hours
    private static final String SECRET = "ThisIsASecret";
    private static final String HEADER_STRING = "Authorization";

    public String addAuthentication(String username) {
        // We generate a token now.
        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return jwtToken;
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        String[] splited = token.split("\\s+");
        if (token != null) {
            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(splited[1])
                    .getBody()
                    .getSubject();
            if (username != null) // we managed to retrieve a user
            {
                return new AuthenticatedUser(username);
            }
        }
        return null;
    }
}
