package com.flyingStone.security.domain;

import com.flyingStone.security.domain.entity.RoleEntity;
import com.flyingStone.security.domain.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * UserRole
 */
@Setter
@Getter
@ToString(callSuper = true)
public class UserRolesDomain {
    private UserEntity user;
    private List<RoleEntity> roles;
}
