package com.weskyx.blog.mapper.provider;

import com.weskyx.blog.common.BatisSqlUtils;
import com.weskyx.blog.entity.Section;

public class SectionProvider {

    private final String tableName = "section";

    public String add(Section section) {
        return BatisSqlUtils.insertSql(tableName, section);
    }

    public String update(Section section) {
        return BatisSqlUtils.updateSql(tableName, section, "id");
    }
}
