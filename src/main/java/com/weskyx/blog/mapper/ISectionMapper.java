package com.weskyx.blog.mapper;

import com.weskyx.blog.entity.Section;
import com.weskyx.blog.mapper.provider.SectionProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ISectionMapper {

    @Select("SELECT * FROM section WHERE author = #{account}")
    List<Section> listByAccout(@Param("account") String account);

    @InsertProvider(type = SectionProvider.class, method = "add")
    int add(Section section);

    @UpdateProvider(type = SectionProvider.class, method = "update")
    void update(Section section);

    @Update("UPDATE section SET status = 0 where id = #{id}")
    void delete(@Param("id") String id);

}
