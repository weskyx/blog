package com.weskyx.blog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  id: id
 *  author: 作者
 *  description: 分类名
 *  number: 文章名
 */
@Data
@NoArgsConstructor
public class Section {

    String id;
    String author;
    String description;
    String number;
}
