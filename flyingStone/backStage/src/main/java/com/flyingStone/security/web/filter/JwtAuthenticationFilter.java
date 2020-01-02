package com.flyingStone.security.web.filter;

import com.flyingStone.security.constant.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component("jwtAuthenticationFilter")
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager webAuthenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.webAuthenticationManager = authenticationManager;
        setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        final String username=request.getParameter("username");
        final String password=request.getParameter("password");
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);
        return webAuthenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        User user= (User) authentication.getPrincipal();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : user.getAuthorities()) {
            String role = grantedAuthority.getAuthority();
            roles.add(role);
        }

        byte[] loginKey = SecurityConstants.JWT_SECRET.getBytes();

        String token= Jwts.builder().signWith(Keys.hmacShaKeyFor(loginKey), SignatureAlgorithm.HS512).setHeaderParam("type",SecurityConstants.TOKEN_TYPE)
                .setIssuer(SecurityConstants.TOKEN_ISSUER)
                .setAudience(SecurityConstants.TOKEN_AUDIENCE)
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.JWT_TOKEN_VALIDITY*1000))
                .claim("role",roles)
                .compact();

        response.addHeader(SecurityConstants.TOKEN_HEADER,SecurityConstants.TOKEN_PREFIX+token);
    }
}
