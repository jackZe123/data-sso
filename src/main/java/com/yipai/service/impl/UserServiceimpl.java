package com.yipai.service.impl;

import com.yipai.common.ResponseCode;
import com.yipai.mapper.UserMapper;
import com.yipai.pojo.User;
import com.yipai.pojo.UserExample;
import com.yipai.service.UserService;
import com.yipai.utils.HaoCangResult;
import com.yipai.utils.MD5Util;
import com.yipai.utils.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author MRrui
 * @description:
 * @date 2019/9/2 22:20
 */
@Service
public class UserServiceimpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public HaoCangResult checkLogin(String useraccount, String password) {
        String md5_pwd = MD5Util.getMD5(password);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserAccountEqualTo(useraccount);
        criteria.andPasswordEqualTo(md5_pwd);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size()>=1){
            return HaoCangResult.ok(users.get(0));
        }
        return  HaoCangResult.build(ResponseCode.LOGIN_REEOR.getCode(),"登录失败");
    }

    @Override
    public HaoCangResult checkUserRegisterAccount(String useraccount) {
        //逻辑处理
        if(useraccount==null||useraccount.length()==0||useraccount==""){
            return  HaoCangResult.build(ResponseCode.USER_ACCOUNT_IS_NULL.getCode(),"用户账号不能为空");
        }
        if(useraccount.length()>10){
            return HaoCangResult.build(ResponseCode.USER_ACCOUNT_IS_LONG.getCode(),"用户账号过长");
        }
        return HaoCangResult.ok();
    }

    @Override
    public HaoCangResult checkUserAccount(String useraccount) {
        //逻辑处理
        if(useraccount==null||useraccount.length()==0||useraccount==""){
            return  HaoCangResult.build(ResponseCode.USER_ACCOUNT_IS_NULL.getCode(),"用户账号不能为空");
        }
        if(useraccount.length()>10){
            return HaoCangResult.build(ResponseCode.USER_ACCOUNT_IS_LONG.getCode(),"用户账号过长");
        }
        int result = checkUserIsExist(useraccount);
        if(result==0){
            return HaoCangResult.build(ResponseCode.USER_ACCOUNT_IS_NOT_EXIST.getCode(),"用户账号不存在");
        }
        return HaoCangResult.ok();
    }

    @Override
    public HaoCangResult checkUserPassword(String password) {
        if (password==null||password.length()==0||password==""){
            return HaoCangResult.build(ResponseCode.PASSWORD_IS_NULL.getCode(),"密码不能为空");
        }
        if (password.length()<6||password.length()>12){
            return HaoCangResult.build(ResponseCode.PASSWORD_LENGTH_IS_ERROR.getCode(),"密码长度必须在6-12位");
        }
        if (!Regex.isLetterDigit(password)){
            return HaoCangResult.build(ResponseCode.PASSWORD_IS_NOT_STANDARD.getCode(),"密码必须包含数字和字母");
        }
        return HaoCangResult.ok();
    }

    @Override
    public HaoCangResult checkUserName(String username) {
        if(username.length()==0||username==null||username==""){
            return HaoCangResult.build(ResponseCode.NAME_IS_NULL.getCode(),"昵称不能为空");
        }
        if(username.length()>8){
            return HaoCangResult.build(ResponseCode.NAME_IS_LONG.getCode(),"昵称的长度不能大于8");
        }
        return HaoCangResult.ok();
    }

    @Override
    public HaoCangResult checkUserPhone(String phone) {
        if (phone.length()==0||phone==null||phone==""){
            return HaoCangResult.build(ResponseCode.PHONE_IS_NULL.getCode(),"手机号不能为空");
        }
        if(phone.length()!=11){
            return HaoCangResult.build(ResponseCode.PHONE_LENGTH_IS_NOT_STANDARD.getCode(),"手机号长度必须为11位");
        }
        if(!Regex.checkPhone(phone)){
            return  HaoCangResult.build(ResponseCode.PHONE_FORMAT_IS_ERROR.getCode(),"手机号格式不正确");
        }
        int result = userMapper.checkUserPhone(phone);
        if (result>0){
            return  HaoCangResult.build(ResponseCode.PHONE_HAS_REGISTER.getCode(),"该手机号已经被注册");
        }
        return HaoCangResult.ok();
    }

    @Override
    public HaoCangResult checkUserEmail(String email) {
        if (email.length()==0||email==null||email==""){
            return HaoCangResult.build(ResponseCode.EMAIL_IS_NULL.getCode(),"email不能为空");
        }
        if (!Regex.checkEmail(email)){
            return  HaoCangResult.build(ResponseCode.EMAIL_FORMAT_IS_ERROR.getCode(),"邮箱格式不正确");
        }
        int result = userMapper.checkUserEmail(email);
        if(result>0){
            return HaoCangResult.build(ResponseCode.EMAIL_HAS_REGISTER.getCode(),"该email已经被注册");
        }
        return HaoCangResult.ok();
    }

    @Override
    public HaoCangResult register(String userAccount, String userName, String pwd, Integer sex, String phone, String email) {
        String md5_pwd = MD5Util.getMD5(pwd);
        Date createTime = new Date();
        Date updateTime = new Date();
        int result = userMapper.register(userAccount,userName,md5_pwd,sex,phone,email,createTime,updateTime);
        if(result<=0){
            return HaoCangResult.build(517,"注册失败");
        }
        return HaoCangResult.ok();
    }

    //判断用户是否登录
    public int checkUserLoginState(String useraccount){
        return userMapper.checkUserLoginState(useraccount);
    }

    //判断用户是否存在
    public int checkUserIsExist(String useraccount){
        return  userMapper.checkUserIsExist(useraccount);
    }
}
