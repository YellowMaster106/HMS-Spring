package com.health.service;

import com.health.pojo.TbUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userService {
    public List<TbUser> findAllUser();
    public void insertUser(TbUser tbUser);
}
