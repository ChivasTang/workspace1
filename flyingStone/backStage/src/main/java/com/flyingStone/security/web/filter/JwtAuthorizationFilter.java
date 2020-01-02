package com.flyingStone.security.web.filter;

import com.flyingStone.security.constant.SecurityConstants;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        super.doFilterInternal(request, response, chain);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        String token=request.getHeader(SecurityConstants.TOKEN_HEADER);
        if(StringUtils.isNotEmpty(token) && token.startsWith(SecurityConstants.TOKEN_PREFIX)){
            try{
                byte[] loginKey=SecurityConstants.JWT_SECRET.getBytes();
                Jwt<Header, Claims> parsedToken= Jwts.parser().setSigningKey(loginKey).parseClaimsJwt(token.replace(SecurityConstants.TOKEN_PREFIX,""));
                String username=parsedToken.getBody().getSubject();
                List<GrantedAuthority> authorities=((List<?>)parsedToken.getBody().get("role")).stream().map(authority->new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());
                if(StringUtils.isNotEmpty(username)){
                    return new UsernamePasswordAuthenticationToken(username,null,authorities);
                }
            }catch (ExpiredJwtException exception) {
                log.warn("Request to parse expired JWT : {} failed : {}", token, exception.getMessage());
            } catch (UnsupportedJwtException exception) {
                log.warn("Request to parse unsupported JWT : {} failed : {}", token, exception.getMessage());
            } catch (MalformedJwtException exception) {
                log.warn("Request to parse invalid JWT : {} failed : {}", token, exception.getMessage());
            } catch (SignatureException exception) {
                log.warn("Request to parse JWT with invalid signature : {} failed : {}", token, exception.getMessage());
            } catch (IllegalArgumentException exception) {
                log.warn("Request to parse empty or null JWT : {} failed : {}", token, exception.getMessage());
            }
        }
        return null;
    }
}
