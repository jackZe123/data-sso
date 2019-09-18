package com.yipai.service;

        import com.yipai.utils.HaoCangResult;

/**
 * @author MRrui
 * @description:
 * @date 2019/9/2 22:18
 */
public interface UserService {

    HaoCangResult checkLogin(String useraccount,String password);

    HaoCangResult checkUserAccount(String useraccount);

    HaoCangResult checkUserRegisterAccount(String zh);

    HaoCangResult checkUserPassword(String password);

    HaoCangResult checkUserName(String username);

    HaoCangResult checkUserPhone(String phone);

    HaoCangResult checkUserEmail(String email);

    HaoCangResult register(String userAccount,String userName,String pwd,Integer sex,String phone,String email);

}
