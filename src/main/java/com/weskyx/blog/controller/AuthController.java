package com.weskyx.blog.controller;

import com.weskyx.blog.service.IAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "AuthController", description = "授权认证相关接口")
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private IAuthService authService;

    @Autowired
    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @ApiOperation(value = "登陆", notes = "用户登陆")
    @ApiImplicitParam(name = "loginInfo", value = "json格式，包含account 和 password 两个字段", required = true, type = "body")
    @PostMapping(value = "/login")
    String login(@RequestBody String loginInfo) {
        return authService.login(loginInfo);
    }

    @ApiOperation(value = "登出", notes = "用户登出")
    @ApiImplicitParam(name = "account", required = true, type = "path", dataType = "String")
    @PostMapping(value = "/logout")
    String logout(String account) {
        return authService.logout(account);
    }
}
