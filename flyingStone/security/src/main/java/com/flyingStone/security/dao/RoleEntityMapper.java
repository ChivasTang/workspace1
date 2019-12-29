package com.flyingStone.security.dao;

import com.flyingStone.security.domain.entity.RoleEntity;

import java.util.List;

public interface RoleEntityMapper {

    List<RoleEntity> selectByUserId(Long userId);

    int deleteByPrimaryKey(Long roleId);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);
}