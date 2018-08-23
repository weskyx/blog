package com.weskyx.blog.service.impl;

import com.weskyx.blog.common.ResultBuilder;
import com.weskyx.blog.entity.Article;
import com.weskyx.blog.mapper.IArticleMapper;
import com.weskyx.blog.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

    private IArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(IArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public List<Article> listAll() {
        return articleMapper.listAll();
    }

    @Override
    public List<Article> listByAccount(String account) {
        return articleMapper.listByAccount(account);
    }


    @Override
    public Article get(String id) {
        return articleMapper.get(id);
    }

    @Override
    public String add(Article article) {
        article.setCreate_time(new Date());
        articleMapper.add(article);
        return ResultBuilder.getResult(true, article.toString(), "新建成功", "");
    }

    @Override
    public String update(Article article) {
        articleMapper.update(article);
        return ResultBuilder.getResult(true, article.toString(), "更新成功", "");
    }

    @Override
    public String publish(String id) {
        articleMapper.publish(id);
        return ResultBuilder.getResult(true, "", "更新成功", "");
    }

    @Override
    public String delete(String id) {
        articleMapper.delete(id);
        return ResultBuilder.getResult(true, "", "更新成功", "");
    }
}
