package com.flyingStone.security.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class RolePermissionsEntity {
    private Long roleId;

    private Long permissionId;

}