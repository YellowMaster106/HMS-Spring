package com.health.service.impl;

import com.health.mapper.TbHospitalMapper;
import com.health.pojo.TbHospital;
import com.health.service.hospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class hospitalServiceImpl implements hospitalService {

    @Autowired
    private TbHospitalMapper tbHospitalMapper;

    @Override
    public List<TbHospital> findAllHospital() {
        return tbHospitalMapper.selectByExample(null);
    }
}
