package com.health.controller;

import com.health.pojo.TbUser;
import com.health.result.LoginResult;
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

    @GetMapping("/loadUser")
    public List<TbUser> findAllUser(){
        return userService.findAllUser();
    }

    @PostMapping("/insertUser")
    public void insertUser(TbUser tbUser){
        userService.insertUser(tbUser);
    }

    @RequestMapping("/checkUser")
    public LoginResult checkUser(@RequestBody TbUser tbUser){
        return userService.checkUser(tbUser);
    }
}
