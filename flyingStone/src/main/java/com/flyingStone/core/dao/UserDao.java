package com.flyingStone.core.dao;

import com.flyingStone.core.domain.common.ParamDomain;
import com.flyingStone.core.domain.common.RegisterDomain;
import com.flyingStone.core.domain.entity.UserEntity;

import java.util.List;

public interface UserDao {

    List<UserEntity> selectByUsername(ParamDomain param);
    UserEntity selectByUserId(ParamDomain param);
    void insert(ParamDomain param);
}