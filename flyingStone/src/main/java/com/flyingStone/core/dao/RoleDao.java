package com.flyingStone.core.dao;

import com.flyingStone.core.domain.common.ParamDomain;
import com.flyingStone.core.domain.entity.RoleEntity;

import java.util.List;

public interface RoleDao {

    List<RoleEntity> getRolesByUserId(ParamDomain param);
}