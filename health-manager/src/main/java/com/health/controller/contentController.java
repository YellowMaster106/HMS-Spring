package com.health.controller;

import com.health.pojo.TbContent;
import com.health.pojo.TbDoctor;
import com.health.pojo.TbUser;
import com.health.result.AllUpdateResult;
import com.health.service.contentService;
import com.health.service.doctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class contentController {

    @Autowired
    private contentService contentService;

    @Autowired
    private doctorService doctorService;

    @GetMapping("/loadContent")
    public List<TbContent> findAllContent(){
        return contentService.findAllContent();
    }

    @RequestMapping("/deleteContent")
    public void deleteContent(@RequestBody TbContent tbContent){
        contentService.deleteContent(tbContent);
    }

    @RequestMapping("/getContent")
    public AllUpdateResult getContent(@RequestBody TbContent tbContent){
        AllUpdateResult allUpdateResult = new AllUpdateResult();
        TbDoctor tbDoctor = new TbDoctor();
        TbContent tbContent1 = new TbContent();

        tbContent1 = contentService.findContent(tbContent);
        tbDoctor = doctorService.findDoctor(tbContent.getIdDoctor());
        allUpdateResult.setContent(tbContent1.getContent());
        allUpdateResult.setTitle(tbContent1.getTitle());
        allUpdateResult.setName(tbDoctor.getName());

        return allUpdateResult;
    }

    @RequestMapping("/insertContent")
    public void insertContent(@RequestBody TbContent tbContent){
        contentService.insertContent(tbContent);
    }
}
