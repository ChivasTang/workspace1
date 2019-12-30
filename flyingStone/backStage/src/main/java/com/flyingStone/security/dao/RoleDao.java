package com.flyingStone.security.dao;

import com.flyingStone.security.domain.entity.RoleEntity;

import java.util.List;

public interface RoleDao {
    List<RoleEntity> selectByUserId(Long userId);
}