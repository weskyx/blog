package com.weskyx.blog.entity;

import com.weskyx.blog.common.BlogConsts;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * id: id
 * author: 作者
 * description: 分类名
 * number: 文章数
 */
@Data
@NoArgsConstructor
public class Section {

    String id;
    String author;
    String description;

    Integer number;
    Integer status = BlogConsts.ValidStatus;
}
