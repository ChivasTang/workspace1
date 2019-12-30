package com.flyingStone.security.dao;

import com.flyingStone.security.domain.entity.UserRoleEntity;

public interface UserRoleEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRoleEntity record);

    int insertSelective(UserRoleEntity record);

    UserRoleEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRoleEntity record);

    int updateByPrimaryKey(UserRoleEntity record);
}