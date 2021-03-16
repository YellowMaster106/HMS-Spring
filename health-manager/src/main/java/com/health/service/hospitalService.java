package com.health.service;

import com.health.pojo.TbHospital;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface hospitalService {
    public List<TbHospital> findAllHospital();
}
