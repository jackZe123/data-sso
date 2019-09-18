package com.yipai.service;

import com.yipai.utils.HaoCangResult;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 8:38
 */
public interface AdminService {
    HaoCangResult checkLogin(String adminaccount, String adminpassword);
}
