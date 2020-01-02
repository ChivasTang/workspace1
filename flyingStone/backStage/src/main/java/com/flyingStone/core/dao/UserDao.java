package com.flyingStone.core.dao;

import com.flyingStone.core.entity.UserEntity;

public interface UserDao {
    UserEntity selectByUsername(String username);
}