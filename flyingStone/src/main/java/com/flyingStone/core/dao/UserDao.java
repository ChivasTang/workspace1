package com.flyingStone.core.dao;

import com.flyingStone.core.domain.entity.UserEntity;

import java.util.List;

public interface UserDao {

    List<UserEntity> selectByUsername();
    UserEntity selectByUserId();
}