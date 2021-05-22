package com.health.controller;

import com.health.pojo.TbResident;
import com.health.pojo.TbUser;
import com.health.pojo.TbUserExample;
import com.health.request.ResidentUserRequest;
import com.health.result.LoginResult;
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


    @GetMapping("/loadUser")
    public List<TbUser> findAllUser(){
        return userService.findAllUser();
    }

    @PostMapping("/insertResidentUser")
    public int insertUser(@RequestBody ResidentUserRequest residentUserRequest){
       TbUser tbUser = new TbUser();
       tbUser.setIdIdentity(residentUserRequest.getIdIdentity());
       tbUser.setKeyword(residentUserRequest.getKeyword());
       tbUser.setPhonenumber(residentUserRequest.getPhonenumber());
       userService.insertUser(tbUser);

       TbResident tbResident = new TbResident();

       if(tbUser.getId() != null) {
           tbResident.setId(tbUser.getId());
           tbResident.setIdAddress(residentUserRequest.getIdAddress());
           System.out.println(residentUserRequest.getIdAddress());
           tbResident.setName(residentUserRequest.getName());
           System.out.println(residentUserRequest.getName());
           residentService.insertResident(tbResident);
           return 0;
       }
       else{
           return 1;
       }
    }

    @RequestMapping("/checkUser")
    public LoginResult checkUser(@RequestBody TbUser tbUser){
        return userService.checkUser(tbUser);
    }
}
