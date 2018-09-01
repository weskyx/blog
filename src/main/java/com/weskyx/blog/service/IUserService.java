package com.weskyx.blog.service;

import com.weskyx.blog.entity.User;

public interface IUserService {

    String add(User user);

    String update(User user);

    String delete(String id);
}
