package com.yipai.pojo;

import java.util.Date;

public class Comment {
    private Integer id;

    private String comment;

    private Integer userId;

    private Integer videoId;

    private Integer beUserId;

    private Integer beCommentId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getBeUserId() {
        return beUserId;
    }

    public void setBeUserId(Integer beUserId) {
        this.beUserId = beUserId;
    }

    public Integer getBeCommentId() {
        return beCommentId;
    }

    public void setBeCommentId(Integer beCommentId) {
        this.beCommentId = beCommentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}