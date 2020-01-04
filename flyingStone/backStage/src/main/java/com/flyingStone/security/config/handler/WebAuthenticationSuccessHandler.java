package com.flyingStone.security.config.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class WebAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        log.debug("ログイン成功しました。");

        if (response.isCommitted()) {
            log.info("Response has already been committed.");
            return;
        }

        response.setStatus(HttpStatus.OK.value());
        clearAuthenticationAttributes(request);
    }



    private void clearAuthenticationAttributes(HttpServletRequest request){

        HttpSession session = request.getSession(false);

        if(session==null){
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
