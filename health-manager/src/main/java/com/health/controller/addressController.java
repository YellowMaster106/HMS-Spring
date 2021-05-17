package com.health.controller;

import com.health.pojo.TbAddress;
import com.health.service.addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class addressController {

    @Autowired
    private addressService addressService;

    @RequestMapping("/loadAddress")
    public List<TbAddress> findAddress(@RequestBody TbAddress tbAddress){
        return addressService.findAddress(tbAddress.getId());
    }
}
