package com.health.controller;

import com.health.pojo.*;
import com.health.request.DoctorUserRequest;
import com.health.request.ResidentUserRequest;
import com.health.result.LoginResult;
import com.health.service.checkService;
import com.health.service.doctorService;
import com.health.service.residentService;
import com.health.service.userService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class userController {

    @Autowired
    private userService userService;

    @Autowired
    private residentService residentService;

    @Autowired
    private doctorService doctorService;

    @Autowired
    private checkService checkService;


    @GetMapping("/loadUser")
    public List<TbUser> findAllUser(){
        return userService.findAllUser();
    }

    @PostMapping("/insertResidentUser")
    public int insertResidentUser(@RequestBody ResidentUserRequest residentUserRequest){
       TbUser tbUser = new TbUser();
       tbUser.setIdIdentity(residentUserRequest.getIdIdentity());
       tbUser.setKeyword(residentUserRequest.getKeyword());
       tbUser.setPhonenumber(residentUserRequest.getPhonenumber());
       userService.insertUser(tbUser);

       TbResident tbResident = new TbResident();

       if(tbUser.getId() != null) {
           tbResident.setId(tbUser.getId());
           tbResident.setIdAddress(residentUserRequest.getIdAddress());
           tbResident.setName(residentUserRequest.getName());
           residentService.insertResident(tbResident);
           return 0;
       }
       else{
           return 1;
       }
    }

    @PostMapping("/insertDoctorUser")
    public int insertDoctorUser(@RequestBody DoctorUserRequest doctorUserRequest){
        TbUser tbUser = new TbUser();
        tbUser.setIdIdentity(doctorUserRequest.getIdIdentity());
        tbUser.setKeyword(doctorUserRequest.getKeyword());
        tbUser.setPhonenumber(doctorUserRequest.getPhonenumber());
        userService.insertUser(tbUser);

        TbDoctor tbDoctor = new TbDoctor();
        if(tbUser.getId() != null) {
            tbDoctor.setId(tbUser.getId());
            tbDoctor.setName(doctorUserRequest.getName());
            tbDoctor.setIdHospital(doctorUserRequest.getIdHospital());
            tbDoctor.setStatus(0);
            doctorService.insertDocotor(tbDoctor);
        }else {
            return 1;
        }

        TbCheck tbCheck = new TbCheck();
        tbCheck.setIdDoctor(tbUser.getId());
        checkService.insertCheck(tbCheck);
        return 0;

    }

    @PostMapping("/checkUser")
    public LoginResult checkUser(@RequestBody TbUser tbUser){
        return userService.checkUser(tbUser);
    }
}
