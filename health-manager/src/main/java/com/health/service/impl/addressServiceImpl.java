package com.health.service.impl;

import com.health.mapper.TbAddressMapper;
import com.health.pojo.TbAddress;
import com.health.pojo.TbAddressExample;
import com.health.service.addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class addressServiceImpl implements addressService {

    @Autowired
    private TbAddressMapper tbAddressMapper;

    @Override
    public List<TbAddress> findAddress(int address) {
        TbAddressExample tbAddressExample = new TbAddressExample();
        TbAddressExample.Criteria criteria = tbAddressExample.createCriteria();
        criteria.andParentIdEqualTo(address);

        return tbAddressMapper.selectByExample(tbAddressExample);
    }
}
