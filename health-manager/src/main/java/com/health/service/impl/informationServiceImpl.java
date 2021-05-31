package com.health.service.impl;

import com.health.mapper.TbDoctorMapper;
import com.health.mapper.TbInformationMapper;
import com.health.mapper.TbResidentMapper;
import com.health.mapper.TbUserMapper;
import com.health.pojo.*;
import com.health.result.LoginResult;
import com.health.service.informationService;
import com.health.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class informationServiceImpl implements informationService {

    @Autowired
    private TbInformationMapper tbInformationMapper;

    @Override
    public List<TbInformation> findInformation(TbUser tbUser) {
        TbInformationExample tbInformationExample = new TbInformationExample();
        TbInformationExample.Criteria criteria = tbInformationExample.createCriteria();
        criteria.andIdUserEqualTo(tbUser.getId());

        return tbInformationMapper.selectByExample(tbInformationExample);
    }
}
