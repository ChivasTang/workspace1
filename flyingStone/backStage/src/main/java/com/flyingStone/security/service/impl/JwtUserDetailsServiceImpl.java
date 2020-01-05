package com.flyingStone.security.service.impl;

import java.util.List;

import com.flyingStone.security.domain.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.flyingStone.core.dao.RoleDao;
import com.flyingStone.core.dao.UserDao;
import com.flyingStone.core.domain.ParamDomain;
import com.flyingStone.core.domain.entity.RoleEntity;
import com.flyingStone.core.domain.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    /**
     * ユーザ名でユーザ情報を取得
     * @param username ユーザ名
     * @return 認証情報
     * @throws UsernameNotFoundException ユーザ存在しない
     */
    @Override
    @Transactional
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
        return JwtUser.create(user,roles);
    }

    /**
     * ユーザIdでユーザ情報を取得
     * @param userId ユーザId
     * @return 認証情報
     * @throws UsernameNotFoundException ユーザ存在しない
     */
    @Override
    public UserDetails loadUserByUserId(Long userId) throws UsernameNotFoundException {
        // ユーザを検索
        ParamDomain param=new ParamDomain();
        param.setId(userId);
        UserEntity user = userDao.selectByUserId(param);
        List<RoleEntity> roles=roleDao.selectUserRoles(param);
        if(roles.size()==0){
            throw new RuntimeException(String.format("No Role found with username '%s'.", user.getUsername()));
        }

        return JwtUser.create(user,roles);
    }
}
