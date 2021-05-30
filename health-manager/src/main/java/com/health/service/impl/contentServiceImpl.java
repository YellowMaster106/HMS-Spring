package com.health.service.impl;

import com.health.mapper.TbContentMapper;
import com.health.pojo.TbContent;
import com.health.service.contentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class contentServiceImpl implements contentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> findAllContent() {
        return tbContentMapper.selectByExample(null);
    }
}
