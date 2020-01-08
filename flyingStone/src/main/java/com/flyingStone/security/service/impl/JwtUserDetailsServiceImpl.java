package com.flyingStone.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public JwtUserDetailsServiceImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	log.debug("start loadUserByUsername...");
        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        String password=passwordEncoder.encode("user");
        System.out.println(password);
        return new User(username,password,true,true,true,true,authorities);
    }
}
