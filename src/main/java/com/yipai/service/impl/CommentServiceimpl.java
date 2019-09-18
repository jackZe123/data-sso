package com.yipai.service.impl;

import com.yipai.common.ResponseCode;
import com.yipai.facade.response.GetCommentResponse;
import com.yipai.facade.response.PushCommentResponse;
import com.yipai.mapper.CommentMapper;
import com.yipai.mapper.UserMapper;
import com.yipai.service.CommentService;
import com.yipai.utils.HaoCangResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/7 13:28
 */
@Service
public class CommentServiceimpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper  userMapper;



    @Override
    public HaoCangResult getComment(Integer videoid) {
        List<GetCommentResponse> getCommentResponses = new ArrayList<>();
        getCommentResponses = commentMapper.getComments(videoid);
        return HaoCangResult.ok(getCommentResponses);
    }

    @Override
    public HaoCangResult pushComment(String comment, Integer userid, Integer videoId, String beuserid, String becommentid) {
        if (comment==null||comment==""){
            return  HaoCangResult.build(ResponseCode.PARAM_IS_ERROR.getCode(),"评论不为空");
        }
        Date createtime = new Date();

        int result = commentMapper.pushComment(comment,userid,videoId,beuserid,becommentid,createtime);
        if(result<=0){
            return HaoCangResult.build(ResponseCode.INSERT_ERROR.getCode(),"插入失败");
        }
        PushCommentResponse pushCommentResponse = new PushCommentResponse();
        String useraccount = userid.toString();
        String username = userMapper.getName(useraccount);
        pushCommentResponse.setUsername(username);
        pushCommentResponse.setComment(comment);
        return HaoCangResult.ok(pushCommentResponse);
    }

    @Override
    public HaoCangResult deleteComment(Integer commentid) {
        int result = commentMapper.deleteComment(commentid);
        if(result<=0){
            return HaoCangResult.build(ResponseCode.INSERT_ERROR.getCode(),"删除失败");
        }
        return HaoCangResult.ok();
    }


}
