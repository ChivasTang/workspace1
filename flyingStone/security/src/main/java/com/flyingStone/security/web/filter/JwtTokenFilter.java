package com.flyingStone.security.web.filter;

import com.flyingStone.security.Exception.TokenValidationException;
import com.flyingStone.security.web.Provider.JwtTokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

    // ログを設定
    private Logger logger= LoggerFactory.getLogger(getClass());

    private JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtTokenProvider.resolveToken(request);
        try{
            if(token!=null && jwtTokenProvider.validateToken(token)){
                Authentication auth=jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }catch (TokenValidationException e){
            SecurityContextHolder.clearContext();
            response.sendError(e.getHttpStatus().value(),e.getMessage());
            return;
        }

        filterChain.doFilter(request,response);
    }
}
