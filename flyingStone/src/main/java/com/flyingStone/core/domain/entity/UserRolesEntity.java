package com.flyingStone.core.domain.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class UserRolesEntity {
    private Long id;

    private Long userId;

    private Long roleId;

}