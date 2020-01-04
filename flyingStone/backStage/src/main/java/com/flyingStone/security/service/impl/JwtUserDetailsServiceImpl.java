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

import com.flyingStone.core.dao.RoleDao;
import com.flyingStone.core.dao.UserDao;
import com.flyingStone.core.domain.ParamDomain;
import com.flyingStone.core.domain.entity.RoleEntity;
import com.flyingStone.core.domain.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * ユーザ名でユーザ情報を取得
     * @param username ユーザ名
     * @return 認証情報
     * @throws UsernameNotFoundException ユーザ存在しない
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        log.debug("Authenticating user '{}'", username);
        // ユーザを検索
        ParamDomain param=new ParamDomain();
        param.setUsername(username);
        List<UserEntity> userEntities=userDao.selectByUsername(param);

        if(userEntities.size()==0){
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }

        // ユーザのロールを検索
        UserEntity user=userEntities.get(0);
        param.setId(user.getUserId());
        List<RoleEntity> roles=roleDao.selectUserRoles(param);
        if(roles.size()==0){
            throw new RuntimeException(String.format("No Role found with username '%s'.", username));
        }
        //Authentication情報
        List<GrantedAuthority> authorities=new ArrayList<>();
        for (RoleEntity role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        String encodedPassword=passwordEncoder.encode("123456");
        System.out.println(encodedPassword);
        return User.withUsername(username)
                .password(passwordEncoder.encode(user.getPassword()))
                .authorities(authorities) // ユーザの権限
                .build();
    }
}
