package com.health.service.impl;

import com.health.mapper.TbResidentMapper;
import com.health.mapper.TbUserMapper;
import com.health.pojo.TbResident;
import com.health.pojo.TbUser;
import com.health.pojo.TbUserExample;
import com.health.result.LoginResult;
import com.health.service.residentService;
import com.health.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class residentServiceImpl implements residentService {

    @Autowired
    private TbResidentMapper tbResidentMapper;

    @Override
    public void insertResident(TbResident tbResident) {
        tbResidentMapper.insert(tbResident);
    }

    @Override
    public List<TbResident> findAllResident() {
        return tbResidentMapper.selectByExample(null);
    }


}
