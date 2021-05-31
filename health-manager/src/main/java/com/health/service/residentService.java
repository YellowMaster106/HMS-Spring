package com.health.service;

import com.health.pojo.TbResident;
import com.health.pojo.TbUser;
import com.health.result.LoginResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface residentService {
    public void insertResident(TbResident tbResident);
    public List<TbResident> findAllResident();
    public TbResident findResident(int id);
}
