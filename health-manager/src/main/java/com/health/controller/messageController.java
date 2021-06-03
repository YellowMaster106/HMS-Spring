package com.health.controller;

import com.health.pojo.TbHospital;
import com.health.pojo.TbMessage;
import com.health.service.hospitalService;
import com.health.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class messageController {

    @Autowired
    private messageService messageService;

    @RequestMapping("/loadSuggestion")
    public List<TbMessage> findSuggestion(@RequestBody TbMessage tbMessage){
        tbMessage.setType(1);
        return messageService.findMessage(tbMessage);
    }

    @RequestMapping("/loadMessage")
    public List<TbMessage> findMessage(@RequestBody TbMessage tbMessage){
        tbMessage.setType(2);
        return messageService.findMessage2(tbMessage);
    }

    @RequestMapping("/insertMessage")
    public void insertMessage(@RequestBody TbMessage tbMessage){
        messageService.insertMessage(tbMessage);
    }
}
