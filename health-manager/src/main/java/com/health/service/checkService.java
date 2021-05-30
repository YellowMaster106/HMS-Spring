package com.health.service;

import com.health.pojo.TbCheck;
import com.health.pojo.TbUser;
import com.health.result.LoginResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface checkService {
    public int checkDoctor(TbCheck tbCheck);
    public void refuseDoctor(TbCheck tbCheck);
    public void insertCheck(TbCheck tbCheck);
    public List<TbCheck> findAllCheck();
}
