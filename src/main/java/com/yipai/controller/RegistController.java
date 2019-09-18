package com.yipai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MRrui
 * @description:
 * @date 2019/9/3 10:30
 */
@Controller
@RequestMapping("/regist")
public class RegistController {

    @RequestMapping("toRegist")
    public String showRegist(){
        return "regist";
    }

    @RequestMapping("video")
    public String showVideo(){
        return "video";
    }
}
