package com.flyingStone.security.service.impl;

import com.flyingStone.security.domain.UserRolesDomain;
import com.flyingStone.security.domain.entity.RoleEntity;
import com.flyingStone.security.domain.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    //ログ設定
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("--Start-- "+getClass().getName());
        UserRolesDomain userRoles=new UserRolesDomain();

        logger.debug("ログインユーザは、"+username);
        String encodedPassword=passwordEncoder.encode(userRoles.getUser().getPassword());
        logger.debug("ログインパスワードは、"+encodedPassword);

        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
        for(RoleEntity role : userRoles.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        User.UserBuilder builder=User.withUsername(username)
                .password(encodedPassword)
                .authorities(grantedAuthorities)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false);
        logger.debug("--End-- "+getClass().getName());
        return builder.build();
    }
}
