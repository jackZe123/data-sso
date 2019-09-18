package com.yipai.controller;

import com.yipai.common.Const;
import com.yipai.common.ResponseCode;
import com.yipai.pojo.Admin;
import com.yipai.pojo.User;
import com.yipai.service.CommentService;
import com.yipai.utils.HaoCangResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 16:54
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @RequestMapping("/getComment")
    @ResponseBody
    public HaoCangResult getComment(@RequestParam String videoid){
        int videoId = Integer.valueOf(videoid);

        return commentService.getComment(videoId);
    }

    @RequestMapping("/pushComment")
    @ResponseBody
    public HaoCangResult pushComment(@RequestParam String videoid,@RequestParam String comment,@RequestParam(required = false) String beuserid,@RequestParam(required = false) String becommentid, HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
                return   HaoCangResult.build(ResponseCode.PLEASE_LOGIN.getCode(),"请先登录，登录后才可评论");
        }
        int  userid = Integer.valueOf(user.getUserAccount());
        int  videoId = Integer.valueOf(videoid);
        return commentService.pushComment(comment,userid,videoId,beuserid,becommentid);
    }

    @RequestMapping("/deleteComment")
    @ResponseBody
    public HaoCangResult deleteComment(@RequestParam Integer commentid, HttpSession session){
        Admin admin = (Admin) session.getAttribute(Const.ADMIN);
        if (admin==null){
            return   HaoCangResult.build(ResponseCode.PLEASE_LOGIN.getCode(),"没有权限");
        }
        return commentService.deleteComment(commentid);
    }
}
