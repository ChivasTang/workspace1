package com.flyingStone.core.dao;

import com.flyingStone.core.domain.ParamDomain;
import com.flyingStone.core.domain.entity.RoleEntity;

import java.util.List;

public interface RoleDao {
    List<RoleEntity> selectUserRoles(ParamDomain param);
}