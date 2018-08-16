package com.weskyx.blog.controller;

import com.weskyx.blog.common.ResultBuilder;
import com.weskyx.blog.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "ArticleController", description = "博客操作接口")
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

}
