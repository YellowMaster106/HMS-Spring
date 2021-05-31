package com.health.service.impl;

import com.health.mapper.TbHospitalMapper;
import com.health.mapper.TbMessageMapper;
import com.health.pojo.TbHospital;
import com.health.pojo.TbMessage;
import com.health.pojo.TbMessageExample;
import com.health.pojo.TbUser;
import com.health.service.hospitalService;
import com.health.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class messageServiceImpl implements messageService {

    @Autowired
    private TbMessageMapper tbMessageMapper;


    @Override
    public List<TbMessage> findMessage(TbMessage tbMessage) {
        TbMessageExample tbMessageExample = new TbMessageExample();
        TbMessageExample.Criteria criteria = tbMessageExample.createCriteria();
        criteria.andTypeEqualTo(tbMessage.getType());
        criteria.andIdResidentEqualTo(tbMessage.getIdResident());
        criteria.andIdDoctorEqualTo(tbMessage.getIdDoctor());

        return tbMessageMapper.selectByExample(tbMessageExample);
    }

    @Override
    public List<TbMessage> findMessage2(TbMessage tbMessage) {
        TbMessageExample tbMessageExample = new TbMessageExample();
        TbMessageExample.Criteria criteria = tbMessageExample.createCriteria();
        criteria.andTypeEqualTo(tbMessage.getType());
        criteria.andIdDoctorEqualTo(tbMessage.getIdDoctor());

        return tbMessageMapper.selectByExample(tbMessageExample);
    }
}
