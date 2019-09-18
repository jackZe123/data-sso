package com.yipai.service.impl;

import com.yipai.common.ResponseCode;
import com.yipai.mapper.CollectMapper;
import com.yipai.mapper.VideoMapper;
import com.yipai.service.VideoService;
import com.yipai.utils.HaoCangResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 10:35
 */
@Service
public class VideoServiceimpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public HaoCangResult commitZan(Integer videoid) {
        if (videoid==null){
            return HaoCangResult.build(ResponseCode.PARAM_IS_ERROR.getCode(),"参数错误");
        }
        int result = videoMapper.commitZan(videoid);
        if(result<=0){
            return  HaoCangResult.build(ResponseCode.INSERT_ERROR.getCode(),"点赞失败");
        }
        int count = videoMapper.zanLenth(videoid);
        return HaoCangResult.ok(count);
    }

    @Override
    public HaoCangResult cancelZan(Integer videoid) {
        if(videoid==null){
            return HaoCangResult.build(ResponseCode.PARAM_IS_ERROR.getCode(),"参数错误");
        }
        int result = videoMapper.cancelZan(videoid);
        if(result<=0){
            return  HaoCangResult.build(ResponseCode.INSERT_ERROR.getCode(),"取消点赞失败");
        }
        int count = videoMapper.zanLenth(videoid);
        return HaoCangResult.ok(count);
    }

    @Override
    public HaoCangResult commitLike(String userAccount,Integer videoid) {
        if(videoid==null){
            return HaoCangResult.build(ResponseCode.PARAM_IS_ERROR.getCode(),"参数错误");
        }
        int result = videoMapper.commitLike(videoid);
        if(result<=0){
            return  HaoCangResult.build(ResponseCode.INSERT_ERROR.getCode(),"收藏数添加失败");
        }
        Date createTime = new Date();
        Date updateTime = new Date();
        int userid = Integer.valueOf(userAccount);
        int insert = collectMapper.addCollect(userid,videoid,createTime,updateTime);
        if (insert<=0){
            return  HaoCangResult.build(ResponseCode.INSERT_ERROR.getCode(),"添加失败");
        }
        int count = videoMapper.collectLength(videoid);
        return HaoCangResult.ok(count);
    }

    @Override
    public HaoCangResult cancelLike(String userAccount,Integer videoid) {
        if(videoid==null){
            return HaoCangResult.build(ResponseCode.PARAM_IS_ERROR.getCode(),"参数错误");
        }
        int result = videoMapper.cancelLike(videoid);
        if(result<=0){
            return  HaoCangResult.build(ResponseCode.INSERT_ERROR.getCode(),"收藏数减少失败");
        }
        int userid = Integer.valueOf(userAccount);
        int delete = collectMapper.deleteCollect(userid,videoid);
        if (delete<=0){
            return  HaoCangResult.build(ResponseCode.INSERT_ERROR.getCode(),"取消失败");
        }
        int count = videoMapper.collectLength(videoid);
        return HaoCangResult.ok(count);
    }

    @Override
    public int insertVideo(String title, String username,Integer userid,Integer categoryid, String imgname, String videoname) {
        Date createTime = new Date();
        Date updateTime = new Date();
        int result = videoMapper.insertVideo(title,username,userid,categoryid,imgname,videoname,createTime,updateTime);
        return result;
    }
}
