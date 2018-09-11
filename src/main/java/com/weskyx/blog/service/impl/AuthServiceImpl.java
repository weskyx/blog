package com.weskyx.blog.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.weskyx.blog.common.BlogConsts;
import com.weskyx.blog.common.ResultBuilder;
import com.weskyx.blog.entity.User;
import com.weskyx.blog.entity.utils.EntityUtils;
import com.weskyx.blog.service.IAuthService;
import com.weskyx.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by xup-e on 2018/9/11.
 */
@Service
public class AuthServiceImpl implements IAuthService {

    private IUserService userService;

    @Autowired
    public AuthServiceImpl(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public String login(String loginInfo) {
        JSONObject loginInfoObj = JSONObject.parseObject(loginInfo);
        String account = loginInfoObj.getString("account");
        String password = loginInfoObj.getString("password");
        User user = userService.getByAccount(account);
        if (user == null || user.getStatus().equals(BlogConsts.InvalidStatus)) {
            return ResultBuilder.getResult(false, "", "用户名或密码错误", "");
        } else {
            //todo password
            if (password.equals(user.getPassword())) {
                return ResultBuilder.getResult(true, "", "登录成功", "");
            } else {
                return ResultBuilder.getResult(false, "", "用户名或密码错误", "");
            }
        }
    }

    @Override
    public String logout(String account) {
        return null;
    }
}
