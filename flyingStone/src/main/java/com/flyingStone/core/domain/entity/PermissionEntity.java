package com.flyingStone.core.domain.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class PermissionEntity {
    private Long permissionId;

    private String permissionName;

    private String permissionCode;

}