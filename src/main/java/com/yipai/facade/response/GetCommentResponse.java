package com.yipai.facade.response;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/7 13:16
 */
public class GetCommentResponse {
    private Integer commentid;
    private Integer userid;
    private String  username;
    private String  comment;
    private Integer beuserid;
    private Integer becommentid;
    private String createtime;

    @Override
    public String toString() {
        return "GetCommentResponse{" +
                "commentid=" + commentid +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", comment='" + comment + '\'' +
                ", beuserid=" + beuserid +
                ", becommentid=" + becommentid +
                ", createtime=" + createtime +
                '}';
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public Integer getBeuserid() {
        return beuserid;
    }

    public void setBeuserid(Integer beuserid) {
        this.beuserid = beuserid;
    }

    public Integer getBecommentid() {
        return becommentid;
    }

    public void setBecommentid(Integer becommentid) {
        this.becommentid = becommentid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
