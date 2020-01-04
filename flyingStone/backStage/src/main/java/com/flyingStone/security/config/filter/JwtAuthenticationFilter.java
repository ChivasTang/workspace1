package com.flyingStone.security.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.flyingStone.security.constant.SecurityConstants;
import com.flyingStone.security.util.JwtUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService jwtUserDetailsService;
    
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
    	log.debug("Start "+this.getClass().getName());
        try{
            String token=getJwtFromRequest(request);
            if(StringUtils.isNotEmpty(token) && jwtUtils.validateToken(token)){
                String username=jwtUtils.getUsernameFromToken(token);
                UserDetails userDetails=jwtUserDetailsService.loadUserByUsername(username);
                // ユーザ情報をauthenticationに保存
                UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // authenticationをcontextに保存
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        chain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(SecurityConstants.TOKEN_HEADER);
        if(StringUtils.isNotEmpty(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, SecurityConstants.TOKEN_PREFIX.length());
        }
        return null;
    }
}
