package com.flyingStone.security.domain.entity;

import com.flyingStone.core.entity.ParentEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Master Table Role
 */
@Setter
@Getter
@ToString(callSuper = true)
public class RoleEntity extends ParentEntity {
    // ロールId
    private Long roleId;
    // ロール名
    private String roleName;
    // ロール表示名
    private String displayName;
    // ロール説明
    private String description;
}