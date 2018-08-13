package com.weskyx.blog.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "articles")
public class Article {
    @Id
    private String _id;
    private String name;
    private String contentType;
    private long size;
    private byte[] content;
}
