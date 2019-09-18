package com.yipai.service.impl;

import com.yipai.common.ResponseCode;
import com.yipai.mapper.AdminMapper;
import com.yipai.pojo.Admin;
import com.yipai.pojo.AdminExample;
import com.yipai.service.AdminService;
import com.yipai.utils.HaoCangResult;
import com.yipai.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 8:39
 */
@Service
public class AdminServiceimpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public HaoCangResult checkLogin(String adminaccount, String adminpassword) {
        String md5_pwd = MD5Util.getMD5(adminpassword);
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminAccountEqualTo(adminaccount);
        criteria.andAdminPasswordEqualTo(md5_pwd);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size()>=1){
            return HaoCangResult.ok(admins.get(0));
        }
        return  HaoCangResult.build(ResponseCode.LOGIN_REEOR.getCode(),"登录失败");
    }
}
