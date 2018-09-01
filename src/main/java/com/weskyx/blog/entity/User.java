package com.weskyx.blog.entity;

import com.weskyx.blog.common.BlogConsts;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * id : 用户id
 * account: 账号
 * password: 密码
 * introduction: 简介
 * email: 邮箱
 */
@Data
@NoArgsConstructor
public class User {

    String id = UUID.randomUUID().toString().replace("-", "");
    String account;
    String password;
    String introduction;
    String email;

    Integer status = BlogConsts.ValidStatus;
}
