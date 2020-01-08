package com.flyingStone.core.domain.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
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