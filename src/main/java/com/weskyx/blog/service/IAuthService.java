package com.weskyx.blog.service;

/**
 * Created by xup-e on 2018/9/11.
 */
public interface IAuthService {

    String login(String loginInfo);

    String logout(String account);
}
