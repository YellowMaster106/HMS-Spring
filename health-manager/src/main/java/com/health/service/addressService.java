package com.health.service;

import com.health.pojo.TbAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface addressService {
    public List<TbAddress> findAddress(int address);
}
