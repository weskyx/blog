package com.weskyx.blog.service;


import com.weskyx.blog.entity.Article;

import java.util.List;

public interface IArticleService {

    List<Article> listAll();

    List<Article> listByAccount(String account);

    String add(Article article);

    String update(Article article);

}
