package com.yipai.controller;

import com.yipai.common.Const;
import com.yipai.common.ResponseCode;
import com.yipai.facade.response.*;
import com.yipai.mapper.CategoryMapper;
import com.yipai.mapper.CommentMapper;
import com.yipai.mapper.VideoMapper;
import com.yipai.pojo.Admin;
import com.yipai.pojo.User;
import com.yipai.service.VideoService;
import com.yipai.utils.HaoCangResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 10:25
 */
@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private LoginController loginController;

    @RequestMapping("/commitZan")
    @ResponseBody
    public HaoCangResult commitZan(@RequestParam String videoid, HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return   HaoCangResult.build(ResponseCode.PLEASE_LOGIN.getCode(),"请先登录，登录后才可点赞");
        }
        int videoId = Integer.valueOf(videoid);
        return videoService.commitZan(videoId);
    }

    @RequestMapping("/cancelZan")
    @ResponseBody
    public HaoCangResult cancelZan(@RequestParam String videoid,HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return   HaoCangResult.build(ResponseCode.PLEASE_LOGIN.getCode(),"请先登录");
        }
        int videoId = Integer.valueOf(videoid);
        return videoService.cancelZan(videoId);
    }

    @RequestMapping("/commitLike")
    @ResponseBody
    public HaoCangResult commitLike(@RequestParam String videoid, HttpSession session){
        int videoId = Integer.valueOf(videoid);
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
          return   HaoCangResult.build(ResponseCode.PLEASE_LOGIN.getCode(),"请先登录，登录后才可收藏");
        }
        String userAccount = user.getUserAccount();

      return  videoService.commitLike(userAccount,videoId);
    }

    @RequestMapping("/cancelLike")
    @ResponseBody
    public HaoCangResult cancelLike(@RequestParam String videoid, HttpSession session){
        int videoId = Integer.valueOf(videoid);
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return   HaoCangResult.build(ResponseCode.PLEASE_LOGIN.getCode(),"请先登录");
        }
        String userAccount = user.getUserAccount();

        return  videoService.cancelLike(userAccount,videoId);
    }


    @RequestMapping("/getVideoMessageByVideoId")
    public String getVideoMessageByVideoId(@RequestParam String videoid,Model model){
        int videoId = Integer.valueOf(videoid);
        int result = videoMapper.addBrowseNum(videoId);
        GetVideoMessageByVideoIdResponse getVideoMessageByVideoIdResponse = new GetVideoMessageByVideoIdResponse();
        List<GetCommentResponse> getCommentResponses = commentMapper.getComments(videoId);
        if (getCommentResponses!=null){
            getVideoMessageByVideoIdResponse.setGetCommentResponseList(getCommentResponses);
        }
        GetVideoResponse  video = videoMapper.getVideoMessage(videoId);
        if(video!=null){
            getVideoMessageByVideoIdResponse.setVideo(video);
        }
        model.addAttribute("video_info",getVideoMessageByVideoIdResponse);
        return "video";
    }

    @RequestMapping(value = "/upload" )
    public String showUpload(Model model){
        List<GetCategoryMainResponse> getCategoryMainResponses = new ArrayList<>();
        getCategoryMainResponses = categoryMapper.categorys();
        model.addAttribute("category_list_sort",getCategoryMainResponses);
        return "upload";
    }

    @RequestMapping("/uploadVideo")
    public String uploadVideo(@RequestParam("img") MultipartFile img, @RequestParam("video") MultipartFile video,@RequestParam("title")  String title,
                                     @RequestParam("categoryname") String categoryname, HttpSession session, HttpServletRequest request,Model model) throws IOException {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        String imgname = img.getOriginalFilename();
        String videoname = video.getOriginalFilename();
        String username = user.getUserName();
        int userid =Integer.valueOf(user.getUserAccount());
        int categoryId = categoryMapper.getCategoryId(categoryname);
        String imgurl=request.getServletContext().getRealPath("/WEB-INF/img/");
        String videourl=request.getServletContext().getRealPath("/WEB-INF/video/");
        File fileimg = new File(imgurl+imgname);
        File filevideo=new File(videourl+videoname);
        fileimg.getParentFile().mkdirs();
        filevideo.getParentFile().mkdirs();
        img.transferTo(fileimg);
//        String imgurlname = fileimg.getAbsolutePath();
        video.transferTo(filevideo);
//        String videourlname = filevideo.getAbsolutePath();
        int result=videoService.insertVideo(title,username,userid,categoryId,imgname,videoname);
        return showUpload(model);
    }

    @RequestMapping("/getImgByCategoryId")
    @ResponseBody
    public HaoCangResult getImgByCategoryId(@RequestParam Integer categoryid){
       GetVideoImgCountResponse getVideoImgCountResponse = new GetVideoImgCountResponse();
        List<GetVideoImgResponse> getVideoImgResponses = new ArrayList<>();
        getVideoImgResponses = videoMapper.getImgByCategoryId(categoryid);
        getVideoImgCountResponse.setGetVideoImgResponses(getVideoImgResponses);
        int count = videoMapper.videoCount(categoryid);
        getVideoImgCountResponse.setVideocount(count);
        return  HaoCangResult.ok(getVideoImgCountResponse);
    }

    @RequestMapping("/getImgByPage")
    @ResponseBody
    public HaoCangResult getImgByPage(@RequestParam Integer categoryid,@RequestParam Integer pageIndex,@RequestParam Integer pageSize,Model model){
        if(categoryid==null){
            categoryid=1;
        }
        List<GetVideoImgResponse> getVideoImgResponses = new ArrayList<>();
        getVideoImgResponses = videoMapper.getImgByPage(categoryid,pageIndex,pageSize);
        return  HaoCangResult.ok(getVideoImgResponses);
    }

    @RequestMapping("/checkVideoByVideoIdPass")
    @ResponseBody
    public  HaoCangResult checkVideoByVideoIdPass(@RequestParam Integer videoid,HttpSession session){
        Admin admin = (Admin) session.getAttribute(Const.ADMIN);
        if (admin==null){
            return   HaoCangResult.build(ResponseCode.PLEASE_LOGIN.getCode(),"没有管理员权限");
        }
        int result = videoMapper.checkVideoByVideoId(videoid);
        return  HaoCangResult.ok();
    }

    @RequestMapping("/checkVideoByVideoIdUnPass")
    @ResponseBody
    public  HaoCangResult checkVideoByVideoIdUnPass(@RequestParam Integer videoid,HttpSession session,Model model){
        Admin admin = (Admin) session.getAttribute(Const.ADMIN);
        if (admin==null){
            return   HaoCangResult.build(ResponseCode.PLEASE_LOGIN.getCode(),"没有管理员权限");
        }
        int result = videoMapper.checkVideoByVideoIdUnPass(videoid);
        return  HaoCangResult.ok();
    }

    @RequestMapping("/getVideoIsPass")
    @ResponseBody
    public HaoCangResult getVideoIsPass(){
       List<GetVideoIsPassResponse> getVideoIsPassResponse = videoMapper.getVideoIsPass();
       return HaoCangResult.ok(getVideoIsPassResponse);
    }
}
