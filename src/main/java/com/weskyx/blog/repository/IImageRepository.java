package com.weskyx.blog.repository;

import com.weskyx.blog.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends MongoRepository<Image, String> {
}
