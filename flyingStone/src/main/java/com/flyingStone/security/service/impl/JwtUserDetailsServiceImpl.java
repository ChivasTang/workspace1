package com.flyingStone.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.flyingStone.core.dao.RoleDao;
import com.flyingStone.core.dao.UserDao;
import com.flyingStone.core.domain.common.AuthDomain;
import com.flyingStone.core.domain.common.ParamDomain;
import com.flyingStone.core.domain.entity.RoleEntity;
import com.flyingStone.core.domain.entity.UserEntity;
import com.flyingStone.security.domain.JwtUser;
import com.flyingStone.security.service.JwtUserDetailsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public JwtUserDetailsServiceImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	AuthDomain auth=getAuthDomainByUsername(username);
        String password=passwordEncoder.encode(auth.getUser().getPassword());
        System.out.println(password);
        return new User(username,password,true,true,true,true,auth.getAuthorities());
    }

    @Override
    public JwtUser loadUserByUserId(Long userId) throws UsernameNotFoundException {
        AuthDomain auth=getAuthDomainByUseId(userId);
        return new JwtUser(auth.getUser().getUserId(),auth.getUser().getUsername(),auth.getUser().getPassword(),auth.getAuthorities());
    }

    private AuthDomain getAuthDomainByUseId(Long userId) throws UsernameNotFoundException{
        log.debug("start loadUserByUsername...");
        ParamDomain paramDomain=new ParamDomain(userId);
        return new AuthDomain(userDao.selectByUserId(paramDomain),getAuthorities(paramDomain));

    }

    private AuthDomain getAuthDomainByUsername(String username) throws UsernameNotFoundException{
        log.debug("start loadUserByUsername...");
        ParamDomain paramDomain=new ParamDomain(username);
        if(StringUtils.isEmpty(username)){
            throw new UsernameNotFoundException("user is not found...");
        }
        List<UserEntity> userEntities=userDao.selectByUsername(paramDomain);
        if(userEntities.size()!=1){
            throw new UsernameNotFoundException("User not found...");
        }
        UserEntity userEntity=userEntities.get(0);
        paramDomain.setId(userEntity.getUserId());
        List<GrantedAuthority> authorities=getAuthorities(paramDomain);
        return new AuthDomain(userEntity,authorities);
    }

    private List<GrantedAuthority> getAuthorities(ParamDomain paramDomain){
        if(paramDomain.getId()==null || paramDomain.getId()==0L){
            throw new RuntimeException("No Id error...");
        }
        List<RoleEntity> roles=roleDao.getRolesByUserId(paramDomain);
        if(roles.size()<1){
            throw new RuntimeException("Roles not found...");
        }
        List<GrantedAuthority> authorities=new ArrayList<>();
        for(RoleEntity role: roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
        }
        return authorities;
    }
}
