package com.flyingStone.core.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class PermissionEntity {
    private Long permissionId;

    private String permissionName;

    private String permissionCode;

}