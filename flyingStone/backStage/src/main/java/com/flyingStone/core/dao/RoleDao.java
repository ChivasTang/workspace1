package com.flyingStone.core.dao;

import com.flyingStone.core.entity.RoleEntity;

import java.util.List;

public interface RoleDao {
    List<RoleEntity> selectByUserId(Long userId);
}