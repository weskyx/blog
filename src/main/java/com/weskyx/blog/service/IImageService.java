package com.weskyx.blog.service;

import com.weskyx.blog.common.BlogException;
import com.weskyx.blog.entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {

    String uploadImage(MultipartFile image) throws BlogException;

    Image getImageById(String id);
}
