package com.flyingStone.security.config.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.DigestUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("Start "+this.getClass().getName());
        //authenticationからユーザ名とパスワードを取得
        String username=authentication.getName();
        String password=authentication.getCredentials().toString();

        //ユーザ名でDBからユーザを検索
        UserDetails userDetails=jwtUserDetailsService.loadUserByUsername(username);

        //パスワードを判断
        String dbPassword=userDetails.getPassword();
        String encodedPassword= DigestUtils.md5DigestAsHex(password.getBytes());
        if(!dbPassword.equals(encodedPassword)){
            log.error("パスワードは間違っている。");
            // TODO
            throw new RuntimeException();
        }

        return new UsernamePasswordAuthenticationToken(username,password,authentication.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        log.debug("Start "+this.getClass().getName());
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
