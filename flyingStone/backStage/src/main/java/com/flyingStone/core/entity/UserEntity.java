package com.flyingStone.core.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString(callSuper = true)
public class UserEntity {
    private Long userId;

    private String username;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Date birthday;

}