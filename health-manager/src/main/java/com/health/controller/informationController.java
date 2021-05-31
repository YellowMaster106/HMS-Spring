package com.health.controller;

import com.health.pojo.*;
import com.health.request.DoctorUserRequest;
import com.health.request.ResidentUserRequest;
import com.health.result.LoginResult;
import com.health.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class informationController {

    @Autowired
    private informationService informationService;

    @RequestMapping("/loadInformation")
    public List<TbInformation> findInformation(@RequestBody TbUser tbUser) {
        return informationService.findInformation(tbUser);
    }

}
