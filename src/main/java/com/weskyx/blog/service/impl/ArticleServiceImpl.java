package com.weskyx.blog.service.impl;

import com.weskyx.blog.common.ResultBuilder;
import com.weskyx.blog.repository.IArticleRepository;
import com.weskyx.blog.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

    private IArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(IArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public String uploadArticle(MultipartFile article) {
        //业务逻辑
        return ResultBuilder.getResult(true, "", "", "");
    }
}
