package com.flyingStone.security.domain.entity;

import com.flyingStone.core.entity.ParentEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Master Table User
 */
@Setter
@Getter
@ToString(callSuper = true)
public class UserEntity extends ParentEntity {
    // ユーザId
    private Long userId;
    // ユーザ名
    private String username;
    // イーメール
    private String email;
    // パスワード
    private String password;
    // 名前
    private String firstName;
    // 苗字
    private String lastName;
    // 生年月日
    private Date birthday;
    // 最新ログイン日付
    private Date lastLogin;

}