package com.olo.internalauthlibrari.security;

import com.olo.internalauthlibrari.exceptions.tokens.InvalidTokenTypeException;
import com.olo.internalauthlibrari.permissions.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {

    @Value("${jwt.secret.key}")
    private String secretKey;

    private SecretKey key;

    @PostConstruct
    public void init() {
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    protected <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claimsResolver.apply(claims);
    }

    public String getTokenType(String token) {
        return extractClaim(token, claims -> claims.get("type", String.class));
    }

    public List<Role> getRoles(String token) {
        validAccessType(token);
        List<String> stringRoles = extractClaim(token, claims -> claims.get("roles", List.class));
        return stringRoles.stream().map(Role::fromString).collect(Collectors.toList());
    }

    public List<Title> getTitles(String token) {
        validAccessType(token);
        List<String> stringRoles = extractClaim(token, claims -> claims.get("titles", List.class));
        return stringRoles.stream().map(Title::fromString).collect(Collectors.toList());
    }

    public List<String> getAuthorities(String token) {
        validAccessType(token);
        List<Role> roles = getRoles(token);
        List<Title> titles = getTitles(token);
        List<String> authorities = new ArrayList<>();
        for (Title title : titles) {
            if (roles.contains(title.getRole())) {
                authorities.add(authorityFormat(title.getRole(), title));
            }
        }

        return authorities;
    }

    private String authorityFormat(Role role, Title title) {
        return String.format("%s::%s", role.name(), title.name());
    }

    private void validAccessType(String token) {
        if (!getTokenType(token).equals("access_token")) {
            throw new InvalidTokenTypeException("Invalid token type");
        }
    }
}
