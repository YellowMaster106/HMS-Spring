package com.health.controller;

import com.health.pojo.TbAddress;
import com.health.pojo.TbResident;
import com.health.service.addressService;
import com.health.service.residentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/loadResident")
    public List<TbResident> findAllResident(){
        return residentService.findAllResident();
    };

    @RequestMapping("/findResident")
    public TbResident findResident(@RequestBody TbResident tbResident){
        return residentService.findResident(tbResident.getId());
    }
}
