package com.yipai.facade.response;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/17 14:26
 */
public class GetCommentByAdminResponse {
    private Integer commentid;
    private  String comment;
    private String username;
    private Integer videoid;
    private String  createtime;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "GetCommentByAdmin{" +
                "commentid=" + commentid +
                ", comment='" + comment + '\'' +
                ", username='" + username + '\'' +
                ", videoid=" + videoid +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
