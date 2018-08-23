package com.weskyx.blog.controller;

import com.weskyx.blog.common.ResultBuilder;
import com.weskyx.blog.entity.Article;
import com.weskyx.blog.service.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(value = "所有博客列表", notes = "获取所有博客列表")
    @GetMapping(value = "listAll")
    public List<Article> listAll() {
        return articleService.listAll();
    }

    @ApiOperation(value = "用户博客列表", notes = "根据用户账号获取博客列表")
    @ApiImplicitParam(name = "account", required = true, paramType = "path", dataType = "String")
    @GetMapping(value = "/list/{account}")
    public List<Article> listByAccount(@PathVariable String account) {
        return articleService.listByAccount(account);
    }

    @ApiOperation(value = "获取博客", notes = "获取博客")
    @ApiImplicitParam(name = "article", required = true, paramType = "body", dataType = "Article")
    @GetMapping(value = "/get/{id}")
    public Article add(@PathVariable String id) {
        return articleService.get(id);
    }


    @ApiOperation(value = "新建博客", notes = "根据requestBody内容新建博客")
    @ApiImplicitParam(name = "article", required = true, paramType = "body", dataType = "Article")
    @PostMapping(value = "/add")
    public String add(Article article) {
        return articleService.add(article);
    }

    @ApiOperation(value = "更新博客", notes = "根据requestBody内容更新博客")
    @ApiImplicitParam(name = "article", required = true, paramType = "body", dataType = "Article")
    @PostMapping(value = "/update")
    public String update(Article article) {
        return articleService.update(article);
    }

    @ApiOperation(value = "发布博客", notes = "发布博客")
    @ApiImplicitParam(name = "id", required = true, paramType = "path", dataType = "String")
    @PostMapping(value = "/publish/{id}")
    public String publish(@PathVariable String id) {
        return articleService.publish(id);
    }

    @ApiOperation(value = "删除博客", notes = "删除博客")
    @ApiImplicitParam(name = "id", required = true, paramType = "path", dataType = "String")
    @PostMapping(value = "/delete/{id}")
    public String delete(@PathVariable String id) {
        return articleService.delete(id);
    }

}
