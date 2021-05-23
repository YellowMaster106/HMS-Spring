package com.health.controller;

import com.health.pojo.TbAddress;
import com.health.pojo.TbResident;
import com.health.service.addressService;
import com.health.service.residentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class residentController {

    @Autowired
    private residentService residentService;

    @RequestMapping("/insertResident")
    public void insertResident(@RequestBody TbResident tbResident){
        residentService.insertResident(tbResident);
    }
}
