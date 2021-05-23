package com.health.service.impl;

import com.health.mapper.TbDoctorMapper;
import com.health.pojo.TbDoctor;
import com.health.service.doctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class doctorServiceImpl implements doctorService {

    @Autowired
    private TbDoctorMapper tbDoctorMapper;

    @Override
    public void insertDocotor(TbDoctor tbDoctor) {
        tbDoctorMapper.insert(tbDoctor);
    }
}
