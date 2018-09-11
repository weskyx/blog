package com.weskyx.blog.mapper;

import com.weskyx.blog.entity.User;
import com.weskyx.blog.mapper.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IUserMapper {

    @Select("SELECT * FROM user WHERE account = #{account}")
    User getByAccount(@Param("account") String account);

    @InsertProvider(type = UserProvider.class, method = "add")
    int add(User user);

    @UpdateProvider(type = UserProvider.class, method = "update")
    void update(User user);

    @Update("UPDATE user SET status = 0 WHERE account = #{account}")
    void delete(@Param("account") String account);
}
