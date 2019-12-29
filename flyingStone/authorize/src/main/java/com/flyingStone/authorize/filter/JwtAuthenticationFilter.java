package com.flyingStone.authorize.filter;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //リクエストの判断
    }

    private boolean checkIgnores(HttpServletRequest request){
        String method=request.getMethod();
        HttpMethod httpMethod=HttpMethod.resolve(method);
        if(ObjectUtils.isNotEmpty(httpMethod)){
            httpMethod=HttpMethod.GET;
        }

        Set<String> ignores=new HashSet<>();
        switch (httpMethod){
            case GET:
                break;
        }

    }
}
