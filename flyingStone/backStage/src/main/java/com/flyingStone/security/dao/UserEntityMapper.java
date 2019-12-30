package com.flyingStone.security.dao;

import com.flyingStone.security.domain.entity.UserEntity;

public interface UserEntityMapper {

    UserEntity selectByUsername(String username);

    int deleteByPrimaryKey(Long userId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}