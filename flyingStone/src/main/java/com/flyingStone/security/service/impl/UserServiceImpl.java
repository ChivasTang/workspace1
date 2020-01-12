package com.flyingStone.security.service.impl;

import com.flyingStone.core.dao.UserDao;
import com.flyingStone.core.domain.common.ParamDomain;
import com.flyingStone.core.domain.common.RegisterDomain;
import com.flyingStone.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public boolean registerUser(RegisterDomain registerDomain) {
        ParamDomain param=new ParamDomain();
        param.setUsername(registerDomain.getUsername());
        param.setPassword(passwordEncoder.encode(registerDomain.getPassword()));
        param.setEmail(registerDomain.getEmail());
        param.setCreateUser(registerDomain.getUsername());
        userDao.insert(param);
        return true;
    }
}
