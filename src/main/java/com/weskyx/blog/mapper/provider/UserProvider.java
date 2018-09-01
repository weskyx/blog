package com.weskyx.blog.mapper.provider;

import com.weskyx.blog.common.BatisSqlUtils;
import com.weskyx.blog.entity.User;

public class UserProvider {

    private final String tableName = "user";

    public String add(User user) {
        return BatisSqlUtils.insertSql(tableName, user);
    }

    public String update(User user) {
        return BatisSqlUtils.updateSql(tableName, user, "id");
    }
}
