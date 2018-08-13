package com.weskyx.blog.repository;

import com.weskyx.blog.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticleRepository extends MongoRepository<Article, String> {
}
