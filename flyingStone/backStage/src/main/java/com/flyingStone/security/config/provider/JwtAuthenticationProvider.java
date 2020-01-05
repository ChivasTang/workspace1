package com.flyingStone.security.config.provider;

import com.flyingStone.security.domain.JwtUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("Start "+this.getClass().getName());

        //authenticationからユーザ名とパスワードを取得
        String username=authentication.getName();
        if(StringUtils.isBlank(username)){
            throw new UsernameNotFoundException("ユーザ名は空ではならない。");
        }
        String password=authentication.getCredentials().toString();
        if(StringUtils.isBlank(password)){
            log.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException("Bad credentials");
        }

        //パスワードを判断
        JwtUser user = (JwtUser) jwtUserDetailsService.loadUserByUsername(username);
        if(!passwordEncoder.matches(passwordEncoder.encode(password),user.getPassword())){
            log.debug("Authentication failed: password does not match stored value");
            throw new BadCredentialsException("Bad credentials");
        }

        return new UsernamePasswordAuthenticationToken(username,password,authentication.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        log.debug("Start "+this.getClass().getName());
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
