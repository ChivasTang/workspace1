package com.flyingStone.security.domain.entity;

import com.flyingStone.core.entity.ParentEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Master Table Permission
 */
@Setter
@Getter
@ToString(callSuper = true)
public class PermissionEntity extends ParentEntity {
    // リンクId
    private Long permissionId;
    // リンク名
    private String permissionName;
    // 説明
    private String description;
    // リンク
    private String url;

}