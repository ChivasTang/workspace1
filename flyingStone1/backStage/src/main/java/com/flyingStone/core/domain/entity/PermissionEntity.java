package com.flyingStone.core.domain.entity;

import com.flyingStone.core.domain.ParentDomain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class PermissionEntity extends ParentDomain {
    private Long permissionId;

    private String permissionName;

    private String permissionCode;
}