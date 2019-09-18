package com.yipai.mapper;

import com.yipai.facade.response.GetCommentByAdminResponse;
import com.yipai.facade.response.GetCommentResponse;
import com.yipai.pojo.Comment;
import com.yipai.pojo.CommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CommentMapper {
    int countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<GetCommentResponse> getComments(Integer videoid);

    int pushComment(@Param("comment") String comment, @Param("userid") Integer userid, @Param("videoid")Integer videoid, @Param("beuserid")String beuserid, @Param("becommentid")String becommentid, @Param("createtime")Date createtime);

    int deleteComment(Integer commentid);

    List<GetCommentByAdminResponse> getCommentByAdmin();
}