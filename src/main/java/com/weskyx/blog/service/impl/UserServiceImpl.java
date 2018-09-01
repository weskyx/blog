package com.weskyx.blog.service.impl;

import com.weskyx.blog.common.ResultBuilder;
import com.weskyx.blog.entity.User;
import com.weskyx.blog.entity.utils.EntityUtils;
import com.weskyx.blog.mapper.IUserMapper;
import com.weskyx.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private IUserMapper userMapper;

    @Autowired
    public UserServiceImpl(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String add(User user) {
        //todo check user
        userMapper.add(user);
        return ResultBuilder.getResult(true, EntityUtils.generateJsonObjectString(User.class, user), "", "");
    }

    @Override
    public String update(User user) {
        //todo check user
        userMapper.update(user);
        return ResultBuilder.getResult(true, EntityUtils.generateJsonObjectString(User.class, user), "", "");
    }

    @Override
    public String delete(String account) {
        userMapper.delete(account);
        return ResultBuilder.getResult(true, "", "删除成功", "");
    }
}
