package com.flyingStone.core.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class RolePermissionsEntity {
    private Long id;

    private Long roleId;

    private Long permissionId;

}