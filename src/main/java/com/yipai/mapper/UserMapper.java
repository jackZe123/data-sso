package com.yipai.mapper;

import com.yipai.facade.response.GetUserByAdminResponse;
import com.yipai.pojo.User;
import com.yipai.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUserLoginState(String useraccount);

    int checkUserIsExist(String useraccount);

    int checkUserPhone(String userPhone);

    int checkUserEmail(String email);

    int register(@Param("userAccount")String userAccount, @Param("userName")String userName, @Param("passWord")String passWord, @Param("sex")Integer sex, @Param("phone")String phone, @Param("email")String email, @Param("createTime") Date createTime, @Param("updateTime")Date updateTime);

    String getName(String useraccount);

    List<GetUserByAdminResponse> getUserByAdmin();

    int deleteUser(String userid);
}