package com.health.controller;

import com.health.pojo.TbHospital;
import com.health.request.PageRequest;
import com.health.service.hospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class hospitalController {

    @Autowired
    private hospitalService hospitalService;

    @RequestMapping("/loadHospital")
    public List<TbHospital> findAllHospital(@RequestBody PageRequest pageRequest){
        int page = pageRequest.getPage();
        int size = pageRequest.getSize();
        return hospitalService.findAllHospitalByPage(page,size);
    }

    @GetMapping("/loadHospitalCount")
    public int findHospitalCount(){
        return hospitalService.findAllHospital();
    }
}
