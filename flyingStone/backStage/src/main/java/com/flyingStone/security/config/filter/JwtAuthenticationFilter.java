package com.flyingStone.security.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyingStone.security.domain.JwtUser;
import com.flyingStone.security.service.impl.JwtUserDetailsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.flyingStone.security.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        try{
            String token=jwtUtils.getJwtFromRequest(request);
            if(StringUtils.isNotEmpty(token) && jwtUtils.validateToken(token)){
                JwtUser jwtUser=jwtUtils.getJwtUserFromToken(token);
                String username=jwtUser.getUsername();
                UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(jwtUser.getUsername());
                // ユーザ情報をauthenticationに保存
                UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // 新しいtokenを設定
                jwtUtils.setJwtTokenToResponse(response,jwtUtils.generateToken(jwtUser));
                // authenticationをcontextに保存
                log.debug("authorized user '{}', setting security context", userDetails.getUsername());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                log.debug("checking authentication for user '{}'", username);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }

        chain.doFilter(request, response);
    }
}
