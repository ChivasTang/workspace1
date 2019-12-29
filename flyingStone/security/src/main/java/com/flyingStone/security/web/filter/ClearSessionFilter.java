package com.flyingStone.security.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

public class ClearSessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(!(request instanceof HttpServletRequest)){
            chain.doFilter(request,response);
            return;
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // clear session if session id in URL
        if(httpRequest.isRequestedSessionIdFromURL()){
            HttpSession session = httpRequest.getSession();
            if(session!=null){
                session.invalidate();
            }
        }

        HttpServletResponseWrapper responseWrapper=new HttpServletResponseWrapper(httpResponse){
            @Override
            public String encodeURL(String url) {
                return url;
            }

            @Override
            public String encodeRedirectURL(String url) {
                return url;
            }
        };

        // process next request in chain
        chain.doFilter(request,responseWrapper);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }
}
