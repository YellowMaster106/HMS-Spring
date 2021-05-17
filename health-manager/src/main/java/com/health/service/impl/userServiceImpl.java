package com.health.service.impl;

import com.health.mapper.TbUserMapper;
import com.health.pojo.TbUser;
import com.health.pojo.TbUserExample;
import com.health.result.LoginResult;
import com.health.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> findAllUser() {
        return tbUserMapper.selectByExample(null);
    }

    @Override
    public void insertUser(TbUser tbUser) {
        tbUserMapper.insert(tbUser);
        System.out.println("ok");
    }

    @Override
    public LoginResult checkUser(TbUser tbUser) {
        //根据传入的数据检测账号密码
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andPhonenumberEqualTo(tbUser.getPhonenumber());
        TbUser tbUser2 = new TbUser();

        LoginResult loginResult = new LoginResult();
        loginResult.setPhonenumber(tbUser.getPhonenumber());

        if(tbUserMapper.selectByExample(tbUserExample).size() != 0) {
            tbUser2 = tbUserMapper.selectByExample(tbUserExample).get(0);
            if(tbUser2.getKeyword().equals(tbUser.getKeyword())){
                loginResult.setStatus(200);                 //登陆成功
                loginResult.setIdentity(tbUser2.getIdIdentity());
            }
            else{
                loginResult.setStatus(500);                 //密码错误
            }
        }
        else{
            loginResult.setStatus(400);                     //账号错误
        }
        return loginResult;
    }
}
