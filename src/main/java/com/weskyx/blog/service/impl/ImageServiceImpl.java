package com.weskyx.blog.service.impl;

import com.weskyx.blog.common.BlogException;
import com.weskyx.blog.common.ResultBuilder;
import com.weskyx.blog.entity.Image;
import com.weskyx.blog.repository.IImageRepository;
import com.weskyx.blog.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class ImageServiceImpl implements IImageService {

    private IImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(IImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    @Transactional
    public String uploadImage(MultipartFile file) throws BlogException {
        if (!file.isEmpty()) {
            try {
                return ResultBuilder.getResult(true, uploadImageFile(file.getOriginalFilename(), file.getSize(), file.getContentType(), file.getBytes()), "图片上传成功", "");
            } catch (IOException e) {
                throw new BlogException(e.getMessage());
            }
        } else {
            throw new BlogException("文件不存在");
        }
    }

    private String uploadImageFile(String originalFilename, long fileSize, String contentType, byte[] data) throws BlogException {
        if (data != null && data.length > 0) {
            try {
                // 源文件名
                String fileName = originalFilename;
                // 源文件后缀
                String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
                // 数据库文件Id,且以id为新的文件名
                String fileId = UUID.randomUUID() + "";

                if (fileSize > 1000 * 1024) {
                    throw new BlogException("上传失败,图片大于1MB");
                }
                if (!(fileSuffix.equals(".jpg") || fileSuffix.equals(".jpeg") || fileSuffix.equals(".png"))) {
                    throw new BlogException("上传失败，不支持该图片格式");
                }
                Image image = new Image();
                image.setName(fileId);
                image.setSize(fileSize);
                image.setContentType(contentType);
                image.setContent(data);
                Image newImage = imageRepository.save(image);
                return "img/" + newImage.getId();
            } catch (Exception e) {
                throw new BlogException("上传失败，" + e.getMessage());
            }
        } else {
            throw new BlogException("文件不存在");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Image getImageById(String id) {
        return imageRepository.findById(id).get();
    }
}
