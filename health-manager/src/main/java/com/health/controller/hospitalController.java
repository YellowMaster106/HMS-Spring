package com.health.controller;

import com.health.pojo.TbHospital;
import com.health.service.hospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class hospitalController {

    @Autowired
    private hospitalService hospitalService;

    @GetMapping("/loadHospital")
    public List<TbHospital> findAllHospital(){
        return hospitalService.findAllHospital();
    }
}
