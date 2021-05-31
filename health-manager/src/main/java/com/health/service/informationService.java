package com.health.service;

import com.health.pojo.TbInformation;
import com.health.pojo.TbUser;
import com.health.result.LoginResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface informationService {
    public List<TbInformation> findInformation(TbUser tbUser);
}
