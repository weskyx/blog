package com.weskyx.blog.controller;

import com.weskyx.blog.common.ResultBuilder;
import com.weskyx.blog.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "ArticleController", description = "博客文件上传与查看接口")
@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    private IArticleService articleService;

    @Autowired
    public ArticleController(IArticleService articleService) {
        this.articleService = articleService;
    }

    @ApiOperation(value = "test", notes = "测试接口")
    @GetMapping(value = "/test")
    public String test() {
        return ResultBuilder.getResult(true, "", "hello world !", "");
    }

    @ApiOperation(value = "博客上传接口", notes = "博客上传保存，返回博客保存地址")
    @PostMapping(value = "uploadArticle")
    public String uploadArticle(@ApiParam(value = "上传的文件", required = true) @RequestParam("article") MultipartFile article) {
        return articleService.uploadArticle(article);
    }

}
