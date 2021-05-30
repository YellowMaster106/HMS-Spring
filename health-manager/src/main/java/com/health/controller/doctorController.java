package com.health.controller;

import com.health.pojo.TbDoctor;
import com.health.pojo.TbResident;
import com.health.service.doctorService;
import com.health.service.residentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class doctorController {

    @Autowired
    private doctorService doctorService;

    @GetMapping("/loadDoctor")
    public List<TbDoctor> findAllResident(){
        return doctorService.findAllDoctor();
    };


}
