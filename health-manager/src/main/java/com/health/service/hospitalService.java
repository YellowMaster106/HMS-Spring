package com.health.service;

import com.health.pojo.TbHospital;
import com.health.request.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface hospitalService {
    public List<TbHospital> findAllHospitalByPage(int page,int size);
    public int findAllHospital();
}
