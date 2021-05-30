package com.health.service;

import com.health.pojo.TbUser;
import com.health.result.LoginResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userService {
    public List<TbUser> findAllUser();
    public void insertUser(TbUser tbUser);
    public LoginResult checkUser(TbUser tbUser);
    public void DeleteUser(TbUser tbUser);
}
