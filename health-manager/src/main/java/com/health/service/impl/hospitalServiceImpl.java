package com.health.service.impl;

import com.health.mapper.TbHospitalMapper;
import com.health.pojo.TbHospital;
import com.health.request.PageRequest;
import com.health.service.hospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class hospitalServiceImpl implements hospitalService {

    @Autowired
    private TbHospitalMapper tbHospitalMapper;

    @Override
    public List<TbHospital> findAllHospitalByPage(int page,int size) {
        List<TbHospital> list = tbHospitalMapper.selectByExample(null);
        List<TbHospital> results = new ArrayList<>();

        int page2 = page * size;
        if(page2 > list.size()){
            page2 = list.size();
        }
        for(int i = (page - 1) * size;i < page2; i++){
            results.add(list.get(i));
        }
        return results;
    }

    @Override
    public int findAllHospital() {
        return tbHospitalMapper.selectByExample(null).size();
    }
}
