package com.weskyx.blog.controller;

import com.weskyx.blog.common.BlogException;
import com.weskyx.blog.entity.Image;
import com.weskyx.blog.service.IImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "ImageController", description = "图片上传与查看接口")
@RestController
@RequestMapping(value = "/img")
public class ImageController {

    private IImageService imageService;

    @Autowired
    public ImageController(IImageService imageService) {
        this.imageService = imageService;
    }

    @ApiOperation(value = "图片上传接口", notes = "图片上传保存，返回图片保存地址")
    @PostMapping(value = "uploadImage")
    public String uploadImage(@ApiParam(value = "上传的文件", required = true) @RequestParam("image") MultipartFile image) throws BlogException {
        return imageService.uploadImage(image);
    }

    @ApiOperation(value = "在线查看图片", notes = "查看图片")
    @ApiImplicitParam(name = "imageId", value = "图片id", required = true, paramType = "path", dataType = "String")
    @GetMapping(value = "/{imageId}")
    @ResponseBody
    public ResponseEntity<Object> getImageById(@PathVariable String imageId) {
        Image image = imageService.getImageById(imageId);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + image.getName() + "\"").header(HttpHeaders.CONTENT_TYPE, image.getContentType()).header(HttpHeaders.CONTENT_LENGTH, image.getSize() + "").header("Connection", "close").body(image.getContent());
    }
}
