package com.health.service.impl;

import com.health.mapper.TbDoctorMapper;
import com.health.pojo.TbDoctor;
import com.health.pojo.TbDoctorExample;
import com.health.result.AllUpdateResult;
import com.health.service.doctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class doctorServiceImpl implements doctorService {

    @Autowired
    private TbDoctorMapper tbDoctorMapper;

    @Override
    public void insertDocotor(TbDoctor tbDoctor) {
        tbDoctorMapper.insert(tbDoctor);
    }

    @Override
    public List<AllUpdateResult> findAllDoctor() {
        List<AllUpdateResult> results = new ArrayList<>();
        TbDoctorExample tbDoctorExample = new TbDoctorExample();
        TbDoctorExample.Criteria criteria = tbDoctorExample.createCriteria();
        criteria.andStatusEqualTo(1);
        List<TbDoctor> doctors = tbDoctorMapper.selectByExample(tbDoctorExample);
        for(int i = 0;i < doctors.size();i++){
            AllUpdateResult re = new AllUpdateResult();
            re.setName(doctors.get(i).getName());
            re.setIdHospital(doctors.get(i).getIdHospital());
            re.setId(doctors.get(i).getId());
            results.add(re);
        }
        return results;

    }

    @Override
    public TbDoctor findDoctor(int id) {
        return tbDoctorMapper.selectByPrimaryKey(id);
    }


}
