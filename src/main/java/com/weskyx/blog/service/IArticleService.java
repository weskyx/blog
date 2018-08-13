package com.weskyx.blog.service;

import org.springframework.web.multipart.MultipartFile;


public interface IArticleService {

    String uploadArticle(MultipartFile article);
}
