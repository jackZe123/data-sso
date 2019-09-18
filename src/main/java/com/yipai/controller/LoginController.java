package com.yipai.controller;

import com.yipai.common.Const;
import com.yipai.facade.response.GetCategoryMainResponse;
import com.yipai.facade.response.GetVideoImgResponse;
import com.yipai.facade.response.RankingListResponse;
import com.yipai.mapper.CategoryMapper;
import com.yipai.mapper.VideoMapper;
import com.yipai.pojo.User;
import com.yipai.service.UserService;
import com.yipai.utils.HaoCangResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private VideoMapper videoMapper;

    @RequestMapping(value = "/main" )
    public String showMain(Model model){
        List<GetCategoryMainResponse> getCategoryMainResponses = new ArrayList<>();
        getCategoryMainResponses = categoryMapper.categorys();
        model.addAttribute("category_list",getCategoryMainResponses);
        List<GetVideoImgResponse> getVideoImgResponses = new ArrayList<>();
        getVideoImgResponses = videoMapper.videoImgs();
        model.addAttribute("img_list",getVideoImgResponses);
        List<RankingListResponse> rankingListResponses =  new ArrayList<>();
        rankingListResponses = videoMapper.getRankingList();
        model.addAttribute("paih_list",rankingListResponses);
        int count = videoMapper.videoCount(1);
        model.addAttribute("video_count",count);
        return "main";
    }


    @RequestMapping(value = "checkUserName")
    @ResponseBody
    public HaoCangResult checkUserName(@RequestParam String username){
        return userService.checkUserName(username);
    }

    @RequestMapping(value = "/checkLogin")
    public String checkLogin(@RequestParam(value = "useraccount") String account, @RequestParam(value = "pwd") String password,Model model, HttpSession session){
        HaoCangResult haoCangResult = checkUserAccount(account);
        haoCangResult = checkUserPassword(password);
        haoCangResult = userService.checkLogin(account,password);
        if (haoCangResult.getStatus()==200){
            User user = (User)haoCangResult.getData();
            session.setAttribute(Const.CURRENT_USER,user);
        }
        return  showMain(model);
    }
    @RequestMapping(value = "/checkUserRegisterAccount")
    @ResponseBody
    public HaoCangResult checkUserRegisterAccount(@RequestParam String account){
        return userService.checkUserRegisterAccount(account);
    }

    @RequestMapping(value = "/checkUserAccount")
    @ResponseBody
    public HaoCangResult checkUserAccount(@RequestParam String account){
        return userService.checkUserAccount(account);
    }

    @RequestMapping(value = "/checkUserPassword")
    @ResponseBody
    public HaoCangResult checkUserPassword(@RequestParam String password){
        return userService.checkUserPassword(password);
    }


    @RequestMapping(value = "/checkUserPhone")
    @ResponseBody
    public HaoCangResult checkUserPhone(@RequestParam String phone){
        return userService.checkUserPhone(phone);
    }

    @RequestMapping(value = "/checkUserEmail")
    @ResponseBody
    public HaoCangResult checkUserEmail(@RequestParam String email){
        return  userService.checkUserEmail(email);
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public HaoCangResult register(@RequestParam String account,@RequestParam String username,@RequestParam String password,@RequestParam Integer sex,@RequestParam String phone,@RequestParam String email){
        HaoCangResult haoCangResult = checkUserRegisterAccount(account);
        haoCangResult = checkUserName(username);
        haoCangResult = checkUserPassword(password);
        haoCangResult =checkUserPhone(phone);
        haoCangResult = checkUserEmail(email);
        if(haoCangResult.getStatus()==200){
            haoCangResult = userService.register(account,username,password,sex,phone,email);
        }
        return haoCangResult;
    }

    @RequestMapping(value = "/loginOut")
    public String loginOut(HttpSession session ,Model model){
        session.removeAttribute(Const.CURRENT_USER);
        return showMain(model);
    }
}
