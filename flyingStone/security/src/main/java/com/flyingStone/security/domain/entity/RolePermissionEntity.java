package com.flyingStone.security.domain.entity;

import com.flyingStone.core.entity.ParentEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Relation Table Role_Permission
 */
@Setter
@Getter
@ToString(callSuper = true)
public class RolePermissionEntity extends ParentEntity {
    // ロールId
    private Long roleId;
    // リンクId
    private Long permissionId;
}