package com.weskyx.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "AuthController", description = "授权认证相关接口")
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @ApiOperation(value = "登陆", notes = "用户登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", required = true, type = "form", dataType = "String"),
            @ApiImplicitParam(name = "password", required = true, type = "form", dataType = "String")})
    @PostMapping(value = "/login")
    String login(String account, String password) {
        return null;
    }

    @ApiOperation(value = "登出", notes = "用户登出")
    @ApiImplicitParam(name = "account", required = true, type = "path", dataType = "String")
    @PostMapping(value = "/logout")
    String logout(String account) {
        return null;
    }
}
