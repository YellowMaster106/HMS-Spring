package com.health.service;

import com.health.pojo.TbContent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface contentService {
    public List<TbContent> findAllContent();
    public void deleteContent(TbContent tbContent);
    public TbContent findContent(TbContent tbContent);
}
