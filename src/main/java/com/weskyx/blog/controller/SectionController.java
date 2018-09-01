package com.weskyx.blog.controller;

import com.weskyx.blog.entity.Section;
import com.weskyx.blog.service.ISectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "SectionController", description = "文章分类操作接口")
@RestController
@RequestMapping(value = "/section")
public class SectionController {

    private ISectionService sectionService;

    @Autowired
    public SectionController(ISectionService sectionService) {
        this.sectionService = sectionService;
    }

    @ApiOperation("获取用户分类列表")
    @ApiImplicitParam(name = "account", required = true, paramType = "path", dataType = "String")
    @GetMapping(value = "/list/{account}")
    List<Section> listByAccont(@PathVariable String account) {
        return sectionService.listByAccount(account);
    }

    @ApiOperation(value = "新建分类", notes = "根据requestBody内容新建分类")
    @ApiImplicitParam(name = "section", required = true, paramType = "body", dataType = "Section")
    @PostMapping(value = "/add")
    public String add(@RequestBody Section section) {
        return sectionService.add(section);
    }

    @ApiOperation(value = "更新分类", notes = "根据requestBody内容更新分类")
    @ApiImplicitParam(name = "section", required = true, paramType = "body", dataType = "Section")
    @PostMapping(value = "/update")
    public String update(@RequestBody Section section) {
        return sectionService.update(section);
    }
    

    @ApiOperation(value = "删除分类", notes = "删除分类")
    @ApiImplicitParam(name = "id", required = true, paramType = "path", dataType = "String")
    @PostMapping(value = "/delete/{id}")
    public String delete(@PathVariable String id) {
        return sectionService.delete(id);
    }
}
