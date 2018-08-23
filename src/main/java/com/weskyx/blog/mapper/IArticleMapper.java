package com.weskyx.blog.mapper;

import com.weskyx.blog.entity.Article;
import com.weskyx.blog.mapper.provider.ArticleProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IArticleMapper {

    @Select("SELECT * FROM article WHERE status = 2 ORDER BY create_time DESC")
    List<Article> listAll();

    @Select("SELECT * FROM article WHERE status = 2 AND author = #{account} ORDER BY create_time DESC")
    List<Article> listByAccount(@Param("account") String account);

    @Select("SELECT * FROM article WHERE id = #{id}")
    Article get(@Param("id") String id);

    @InsertProvider(type = ArticleProvider.class,method = "add")
    int add(Article article);

    @UpdateProvider(type = ArticleProvider.class,method = "update")
    void update(Article article);

    @Update("UPDATE article SET status = 2 WHERE id = #{id}")
    void publish(@Param("id")String id);

    @Update("UPDATE article SET status = 0 WHERE id = #{id}")
    void delete(@Param("id")String id);

}
