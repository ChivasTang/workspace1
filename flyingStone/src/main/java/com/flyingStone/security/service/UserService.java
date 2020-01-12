package com.flyingStone.security.service;

import com.flyingStone.core.domain.common.RegisterDomain;

public interface UserService {
    boolean registerUser(RegisterDomain registerDomain);
}
