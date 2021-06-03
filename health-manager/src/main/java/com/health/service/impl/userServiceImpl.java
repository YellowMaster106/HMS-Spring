package com.health.service.impl;

import com.health.mapper.TbDoctorMapper;
import com.health.mapper.TbResidentMapper;
import com.health.mapper.TbUserMapper;
import com.health.pojo.*;
import com.health.result.AllUpdateResult;
import com.health.result.LoginResult;
import com.health.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<AllUpdateResult> findAllUser() {
        List<AllUpdateResult> result = new ArrayList<>();
        List<TbUser> userlist = tbUserMapper.selectByExample(null);
        for(int i = 0;i < userlist.size();i++){
            AllUpdateResult re = new AllUpdateResult();
            re.setId(userlist.get(i).getId());
            re.setKeyword(userlist.get(i).getKeyword());
            re.setPhonenumber(userlist.get(i).getPhonenumber());
            re.setIdIdentity(userlist.get(i).getIdIdentity());
            if(re.getIdIdentity() == 1) {
                re.setName(tbResidentMapper.selectByPrimaryKey(userlist.get(i).getId()).getName());
                re.setIdentity("居民");
            }else if(re.getIdIdentity() == 2) {
                re.setName(tbDoctorMapper.selectByPrimaryKey(userlist.get(i).getId()).getName());
                re.setIdentity("医生");
            }else{
                continue;
            }
            result.add(re);
        }
        return result;
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
                    TbDoctor tbDoctor = tbDoctorMapper.selectByPrimaryKey(tbUser2.getId());
                    if(tbDoctor.getStatus().equals(0)){
                        loginResult.setStatus(501);                 //医生未认证
                    }
                    else{
                        loginResult.setStatus(200);                 //医生登陆成功
                        loginResult.setId(tbUser2.getId());
                        loginResult.setName(tbDoctor.getName());
                        loginResult.setIdentity(tbUser2.getIdIdentity());
                        loginResult.setIdentityName("医生");
                    }
                }
                else if(tbUser2.getIdIdentity().equals(1)){
                    TbResident tbResident = tbResidentMapper.selectByPrimaryKey(tbUser2.getId());
                    loginResult.setStatus(200);                 //登陆成功
                    loginResult.setId(tbUser2.getId());
                    loginResult.setIdentity(tbUser2.getIdIdentity());
                    loginResult.setName(tbResident.getName());
                    loginResult.setIdentityName("居民");
                }else{
                    loginResult.setStatus(200);                 //登陆成功
                    loginResult.setId(tbUser2.getId());
                    loginResult.setIdentity(tbUser2.getIdIdentity());
                    loginResult.setName("管理员");
                    loginResult.setIdentityName("");
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

    @Override
    public void UpdateUser(TbUser tbUser) {
        tbUserMapper.updateByPrimaryKey(tbUser);
    }

    @Override
    public TbUser findUser(int id) {
        return tbUserMapper.selectByPrimaryKey(id);
    }
}
