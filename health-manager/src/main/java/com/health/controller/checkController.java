package com.health.controller;

import com.health.pojo.TbCheck;
import com.health.pojo.TbResident;
import com.health.result.AllUpdateResult;
import com.health.service.checkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class checkController {

    @Autowired
    private checkService checkService;

    @PostMapping("/checkDoctor")
    public int checkDoctor(@RequestBody TbCheck tbCheck){
        return checkService.checkDoctor(tbCheck);
    }

    @PostMapping("/refuseDoctor")
    public void refuseDoctor(@RequestBody TbCheck tbCheck){
        checkService.refuseDoctor(tbCheck);
    }

    @GetMapping("/loadCheck")
    public List<AllUpdateResult> findAllCheck(){
        return checkService.findAllCheck();
    }
}
