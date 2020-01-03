package com.flyingStone.core.dao;

import com.flyingStone.core.domain.ParamDomain;
import com.flyingStone.core.domain.entity.UserEntity;

public interface UserDao {
    UserEntity selectByUsername(ParamDomain param);
}