package com.flyingStone.core.dao;

import java.util.List;

import com.flyingStone.core.domain.common.ParamDomain;
import com.flyingStone.core.domain.entity.RoleEntity;

public interface RoleDao {

    List<RoleEntity> selectUserRoles(ParamDomain param);
}