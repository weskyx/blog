package com.weskyx.blog.service.impl;

import com.weskyx.blog.common.ResultBuilder;
import com.weskyx.blog.entity.Section;
import com.weskyx.blog.entity.utils.EntityUtils;
import com.weskyx.blog.mapper.ISectionMapper;
import com.weskyx.blog.service.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SectionServiceImpl implements ISectionService {

    private ISectionMapper sectionMapper;

    @Autowired
    public SectionServiceImpl(ISectionMapper sectionMapper) {
        this.sectionMapper = sectionMapper;
    }

    @Override
    public List<Section> listByAccount(String account) {
        return sectionMapper.listByAccout(account);
    }

    @Override
    public String add(Section section) {
        sectionMapper.add(section);
        return ResultBuilder.getResult(true, EntityUtils.generateJsonObjectString(Section.class, section), "", "");
    }

    @Override
    public String update(Section section) {
        sectionMapper.update(section);
        return ResultBuilder.getResult(true, EntityUtils.generateJsonObjectString(Section.class, section), "", "");
    }

    @Override
    public String delete(String id) {
        //todo check
        sectionMapper.delete(id);
        return ResultBuilder.getResult(true, "", "删除成功", "");
    }
}
