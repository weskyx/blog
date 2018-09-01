package com.weskyx.blog.controller;

import com.weskyx.blog.entity.User;
import com.weskyx.blog.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "UserController", description = "用户操作相关接口，内部使用")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "添加用户", notes = "新增用户")
    @ApiImplicitParam(name = "user", required = true, paramType = "body", dataType = "User")
    @PostMapping(value = "/add")
    String add(@RequestBody User user) {
        return userService.add(user);
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @ApiImplicitParam(name = "user", required = true, paramType = "body", dataType = "User")
    @PostMapping(value = "/update")
    String update(@RequestBody User user) {
        return userService.update(user);
    }

    @ApiOperation(value = "删除用户", notes = "根据account删除用户")
    @ApiImplicitParam(name = "account", required = true, paramType = "path", dataType = "String")
    @PostMapping(value = "/delete/{account}")
    String delete(@PathVariable String account) {
        return userService.delete(account);
    }
}
