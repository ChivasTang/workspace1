package com.flyingStone.core.domain.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class RoleEntity {
    private Long roleId;

    private String role;

    private String roleName;

}