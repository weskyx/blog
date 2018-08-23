package com.weskyx.blog.service;


import com.weskyx.blog.entity.Article;

import java.util.List;

public interface IArticleService {

    List<Article> listAll();

    List<Article> listByAccount(String account);

    Article get(String id);

    String add(Article article);

    String update(Article article);

    String publish(String id);

    String delete(String id);

}
