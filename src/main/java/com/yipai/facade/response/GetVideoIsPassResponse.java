package com.yipai.facade.response;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/16 16:21
 */
public class GetVideoIsPassResponse {
    private Integer videoid;
    private String title;
    private String username;
    private String createtime;
    private String categoryname;

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Override
    public String toString() {
        return "GetVideoIsPassResponse{" +
                "videoid=" + videoid +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", createtime='" + createtime + '\'' +
                ", categoryname='" + categoryname + '\'' +
                '}';
    }
}
