package com.flyingStone.security.domain.entity;

import com.flyingStone.core.entity.ParentEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * relation Table User_Role
 */
@Setter
@Getter
@ToString(callSuper = true)
public class UserRoleEntity extends ParentEntity {
    // ユーザId
    private Long userId;
    // ロールId
    private Long roleId;
}