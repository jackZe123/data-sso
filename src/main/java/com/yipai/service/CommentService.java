package com.yipai.service;

import com.yipai.utils.HaoCangResult;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 16:55
 */
public interface CommentService {
    HaoCangResult getComment(Integer videoid);
    HaoCangResult pushComment(String comment,Integer userid,Integer videoId,String beuserid,String becommentid);
    HaoCangResult deleteComment(Integer commentid);
}
