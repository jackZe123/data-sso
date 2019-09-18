package com.yipai.facade.response;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/9 8:44
 */
public class RankingListResponse {
    private String username;
    private String title;
    private Integer supportnum;
    private Integer videoid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSupportnum() {
        return supportnum;
    }

    public void setSupportnum(Integer supportnum) {
        this.supportnum = supportnum;
    }

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    @Override
    public String toString() {
        return "RankingListResponse{" +
                "username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", supportnum=" + supportnum +
                ", videoid=" + videoid +
                '}';
    }
}
