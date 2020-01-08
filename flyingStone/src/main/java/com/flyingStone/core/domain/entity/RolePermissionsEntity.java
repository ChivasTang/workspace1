package com.flyingStone.core.domain.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class RolePermissionsEntity {
    private Long id;

    private Long roleId;

    private Long permissionId;

}