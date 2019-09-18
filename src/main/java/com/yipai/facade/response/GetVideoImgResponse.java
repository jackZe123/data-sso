package com.yipai.facade.response;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/8 12:27
 */
public class GetVideoImgResponse {
    private  String  imgurl;
    private  Integer categoryid;
    private  Integer videoid;

    @Override
    public String toString() {
        return "GetVideoImgResponse{" +
                "imgurl='" + imgurl + '\'' +
                ", categoryid=" + categoryid +
                ", videoid=" + videoid +
                '}';
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }
}
