package com.weskyx.blog.service;

import com.weskyx.blog.entity.Section;

import java.util.List;

public interface ISectionService {

    List<Section> listByAccount(String account);

    String add(Section section);

    String update(Section section);

    String delete(String id);
}
