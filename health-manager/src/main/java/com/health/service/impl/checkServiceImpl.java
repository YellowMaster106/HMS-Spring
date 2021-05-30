package com.health.service.impl;

import com.health.mapper.TbCheckMapper;
import com.health.mapper.TbDoctorMapper;
import com.health.mapper.TbUserMapper;
import com.health.pojo.TbCheck;
import com.health.pojo.TbDoctor;
import com.health.pojo.TbUser;
import com.health.pojo.TbUserExample;
import com.health.result.LoginResult;
import com.health.service.checkService;
import com.health.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class checkServiceImpl implements checkService {

    @Autowired
    private TbCheckMapper tbCheckMapper;

    @Autowired
    private TbDoctorMapper tbDoctorMapper;

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public int checkDoctor(TbCheck tbCheck) {
        TbDoctor tbDoctor = new TbDoctor();
        tbDoctor = tbDoctorMapper.selectByPrimaryKey(tbCheck.getIdDoctor());
        if(tbDoctor.getId() == null){
            return 0;
        }
        tbDoctor.setStatus(1);
        tbDoctorMapper.updateByPrimaryKey(tbDoctor);
        tbCheckMapper.deleteByPrimaryKey(tbCheck.getIdDoctor());
        return 1;
    }

    @Override
    public void refuseDoctor(TbCheck tbCheck) {
        tbDoctorMapper.deleteByPrimaryKey(tbCheck.getIdDoctor());
        tbCheckMapper.deleteByPrimaryKey(tbCheck.getIdDoctor());
        tbUserMapper.deleteByPrimaryKey(tbCheck.getIdDoctor());
    }

    @Override
    public void insertCheck(TbCheck tbCheck) {
        tbCheckMapper.insert(tbCheck);
    }

    @Override
    public List<TbCheck> findAllCheck() {
        return tbCheckMapper.selectByExample(null);
    }

}
