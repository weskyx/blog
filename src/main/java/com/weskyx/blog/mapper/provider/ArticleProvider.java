package com.weskyx.blog.mapper.provider;

import com.weskyx.blog.common.BatisSqlUtils;
import com.weskyx.blog.entity.Article;

public class ArticleProvider {

    private final String tableName = "article";

    public String add(Article article) {
        return BatisSqlUtils.insertSql(tableName, article);
    }

    public String update(Article article) {
        return BatisSqlUtils.updateSql(tableName, article, "id");
    }
}
