package com.flyingStone.security.dao;

import com.flyingStone.security.domain.entity.PermissionEntity;

public interface PermissionEntityMapper {
    int deleteByPrimaryKey(Long permissionId);

    int insert(PermissionEntity record);

    int insertSelective(PermissionEntity record);

    PermissionEntity selectByPrimaryKey(Long permissionId);

    int updateByPrimaryKeySelective(PermissionEntity record);

    int updateByPrimaryKey(PermissionEntity record);
}