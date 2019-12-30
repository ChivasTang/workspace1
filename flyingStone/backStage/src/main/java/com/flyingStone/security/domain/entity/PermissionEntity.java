package com.flyingStone.security.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class PermissionEntity {
    private Long permissionId;

    private String permissionName;

    private String description;

    private String link;

}