package com.yipai.controller;

import com.yipai.common.Const;
import com.yipai.facade.response.GetCategoryResponse;
import com.yipai.facade.response.GetCommentByAdminResponse;
import com.yipai.facade.response.GetUserByAdminResponse;
import com.yipai.facade.response.GetVideoIsPassResponse;
import com.yipai.mapper.CategoryMapper;
import com.yipai.mapper.CommentMapper;
import com.yipai.mapper.UserMapper;
import com.yipai.mapper.VideoMapper;
import com.yipai.service.AdminService;
import com.yipai.utils.HaoCangResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 8:36
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/checkLogin")
    public String checkLogin(@RequestParam String adminaccount, @RequestParam String adminpassword, HttpSession session, Model model){
        HaoCangResult haoCangResult = adminService.checkLogin(adminaccount,adminpassword);
        model.addAttribute(Const.ADMIN,adminaccount);
        if (haoCangResult.getStatus()==200){
            session.setAttribute(Const.ADMIN,haoCangResult.getData());
            List<GetCategoryResponse> categories= new ArrayList<>();
            categories = categoryMapper.selectCategory();
            model.addAttribute("categories",categories);
            List<GetVideoIsPassResponse> getVideoIsPassResponse = videoMapper.getVideoIsPass();
            model.addAttribute("videoCategories",getVideoIsPassResponse);
            List<GetCommentByAdminResponse> getCommentByAdminResponses = new ArrayList<>();
            getCommentByAdminResponses = commentMapper.getCommentByAdmin();
            model.addAttribute("commentCategories",getCommentByAdminResponses);
            List<GetUserByAdminResponse> getUserByAdminResponses = new ArrayList<>();
            getUserByAdminResponses = userMapper.getUserByAdmin();
            model.addAttribute("userCategories",getUserByAdminResponses);
            return "manager";
        }
        return "manager_login";
    }

    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute(Const.ADMIN);
        return "manager_login";
    }

    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public HaoCangResult deleteUser(String userid){
       int result = userMapper.deleteUser(userid);
        return HaoCangResult.ok();
    }

    @RequestMapping(value = "/managerlogin")
    public String showManager(){
        return "manager_login";
    }

}
