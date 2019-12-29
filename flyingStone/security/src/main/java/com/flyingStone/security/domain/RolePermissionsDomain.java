package com.flyingStone.security.domain;

import com.flyingStone.security.domain.entity.PermissionEntity;
import com.flyingStone.security.domain.entity.RoleEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * RolePermission
 */
@Setter
@Getter
@ToString(callSuper = true)
public class RolePermissionsDomain {
    private RoleEntity role;
    private List<PermissionEntity> permissions;
}
