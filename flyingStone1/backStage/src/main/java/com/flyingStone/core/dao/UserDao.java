package com.flyingStone.core.dao;

import com.flyingStone.core.domain.ParamDomain;
import com.flyingStone.core.domain.entity.UserEntity;

import java.util.List;

public interface UserDao {
    UserEntity selectByUserId(ParamDomain param);
    List<UserEntity> selectByUsername(ParamDomain param);
}