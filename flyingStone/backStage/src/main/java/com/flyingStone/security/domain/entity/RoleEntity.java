package com.flyingStone.security.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class RoleEntity {
    private Long roleId;

    private String role;

    private String roleName;

    private String description;

}