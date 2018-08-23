package com.weskyx.blog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

/**
 *  id: 文章id
 *  section_id: 分类名称
 *  create_time: 创建时间
 *  author: 作者
 *  status: 0（已删除）1（未发布） 2 （已发布）
 *  favorite: 喜欢数
 *  page_view: 浏览量
 *
 *  title: 标题
 *  brief: 摘要
 *  content: 内容
 *  image_url: 图片链接（以“;”分隔）
 */

@Data
@NoArgsConstructor
public class Article {

    String id = UUID.randomUUID().toString().replace("-", "");
    String section_id;
    Date create_time;
    String author;
    Integer status;
    Integer favorite;
    Integer page_view;

    String title;
    String brief;
    String content;
    String image_url;
}
