package com.health.controller;

import com.health.pojo.TbCheck;
import com.health.pojo.TbResident;
import com.health.service.checkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class checkController {

    @Autowired
    private checkService checkService;

    @PostMapping("/checkDoctor")
    public int checkDoctor(@RequestBody TbCheck tbCheck){
        return checkService.checkDoctor(tbCheck);
    }
}
