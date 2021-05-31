package com.health.service;

import com.health.pojo.TbContent;
import com.health.pojo.TbDoctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface doctorService {
    public void insertDocotor(TbDoctor tbDoctor);
    public List<TbDoctor> findAllDoctor();
    public TbDoctor findDoctor(int id);
}
