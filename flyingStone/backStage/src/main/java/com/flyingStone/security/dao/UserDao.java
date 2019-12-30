package com.flyingStone.security.dao;

import com.flyingStone.security.domain.entity.UserEntity;

public interface UserDao {
    UserEntity selectByUsername(String username);
}