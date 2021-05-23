package com.health.service;

import com.health.pojo.TbDoctor;
import org.springframework.stereotype.Service;

@Service
public interface doctorService {
    public void insertDocotor(TbDoctor tbDoctor);
}
