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
    // 作成ユーザ
    private String createUser;
    // 作成日付
    private Date created;
    // 更新ユーザ
    private String updateUser;
    // 更新日付
    private Date updated;
    // 有効区分
    private Short activeKbn;
}
