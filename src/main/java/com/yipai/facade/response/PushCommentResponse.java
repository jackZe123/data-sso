package com.yipai.facade.response;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/12 14:52
 */
public class PushCommentResponse {
    private  String username;
    private  String comment;

    @Override
    public String toString() {
        return "PushCommentResponse{" +
                "username='" + username + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}