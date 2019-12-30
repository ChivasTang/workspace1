package com.flyingStone.security.dao;

import com.flyingStone.security.domain.entity.RolePermissionEntity;

public interface RolePermissionEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RolePermissionEntity record);

    int insertSelective(RolePermissionEntity record);

    RolePermissionEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermissionEntity record);

    int updateByPrimaryKey(RolePermissionEntity record);
}