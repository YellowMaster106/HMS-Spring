package com.health.service.impl;

import com.health.mapper.TbDoctorMapper;
import com.health.mapper.TbResidentMapper;
import com.health.mapper.TbUserMapper;
import com.health.pojo.*;
import com.health.result.LoginResult;
import com.health.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbDoctorMapper tbDoctorMapper;

    @Autowired
    private TbResidentMapper tbResidentMapper;

    @Override
    public List<TbUser> findAllUser() {
        return tbUserMapper.selectByExample(null);
    }

    @Override
    public void insertUser(TbUser tbUser) {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andPhonenumberEqualTo(tbUser.getPhonenumber());
        if(tbUserMapper.selectByExample(tbUserExample).size() == 0) {
            tbUserMapper.insert(tbUser);
        }
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
                if(tbUser2.getIdIdentity().equals(2)){//判断是否为医生，看是否审核通过
                    TbDoctorExample tbDoctorExample = new TbDoctorExample();
                    TbDoctorExample.Criteria criteria2 = tbDoctorExample.createCriteria();
                    criteria2.andIdEqualTo(tbUser2.getId());
                    TbDoctor tbDoctor = new TbDoctor();
                    tbDoctor = tbDoctorMapper.selectByExample(tbDoctorExample).get(0);
                    if(tbDoctor.getStatus().equals(0)){
                        loginResult.setStatus(501);                 //医生未认证
                    }
                    else{
                        loginResult.setStatus(200);                 //医生登陆成功
                        loginResult.setId(tbUser2.getId());
                        loginResult.setName(tbDoctor.getName());
                        loginResult.setIdentity(tbUser2.getIdIdentity());
                    }
                }
                else {
                    loginResult.setStatus(200);                 //登陆成功
                    loginResult.setId(tbUser2.getId());
                    loginResult.setIdentity(tbUser2.getIdIdentity());
                }
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

    @Override
    public void DeleteUser(TbUser tbUser) {
        tbUserMapper.deleteByPrimaryKey(tbUser.getId());
        if(tbUser.getIdIdentity() == 1){
            tbResidentMapper.deleteByPrimaryKey(tbUser.getId());
        }else if (tbUser.getIdIdentity() == 2){
            tbDoctorMapper.deleteByPrimaryKey(tbUser.getId());
        }
    }
}
