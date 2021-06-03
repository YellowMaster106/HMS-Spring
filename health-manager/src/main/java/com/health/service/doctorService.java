package com.health.service;

import com.health.pojo.TbContent;
import com.health.pojo.TbDoctor;
import com.health.result.AllUpdateResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface doctorService {
    public void insertDocotor(TbDoctor tbDoctor);
   public List<AllUpdateResult> findAllDoctor();
    public TbDoctor findDoctor(int id);
}
