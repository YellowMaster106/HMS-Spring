package com.health.service.impl;

import com.health.mapper.TbHospitalMapper;
import com.health.mapper.TbUserMapper;
import com.health.pojo.TbUser;
import com.health.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> findAllUser() {
        return tbUserMapper.selectByExample(null);
    }

    @Override
    public void insertUser(TbUser tbUser) {
        tbUserMapper.insert(tbUser);
        System.out.println("ok");
    }
}
