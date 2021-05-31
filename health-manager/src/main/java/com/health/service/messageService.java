package com.health.service;

import com.health.pojo.TbHospital;
import com.health.pojo.TbMessage;
import com.health.pojo.TbUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface messageService {
    public List<TbMessage> findMessage(TbMessage tbMessage);
    public List<TbMessage> findMessage2(TbMessage tbMessage);
}
