package com.health.controller;

import com.health.pojo.TbUser;
import com.health.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PatchMapping("/insertUser")
    public void insertUser(TbUser tbUser){
        userService.insertUser(tbUser);
    }
}
