package com.flyingStone.core.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * テーブルの通用フィールド
 */
@Setter
@Getter
@ToString(callSuper = true)
public class ParentEntity {

    private String createUser;

    private Date created;

    private String updateUser;

    private Date updated;

    private Boolean locked;
}