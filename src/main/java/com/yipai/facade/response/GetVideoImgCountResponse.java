package com.yipai.facade.response;

import java.util.List;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/16 8:56
 */
public class GetVideoImgCountResponse {
     List< GetVideoImgResponse> getVideoImgResponses;
    private Integer videocount;

    public Integer getVideocount() {
        return videocount;
    }

    public void setVideocount(Integer videocount) {
        this.videocount = videocount;
    }

    @Override
    public String toString() {
        return "GetVideoImgCountResponse{" +
                "getVideoImgResponses=" + getVideoImgResponses +
                ", videocount=" + videocount +
                '}';
    }

    public List<GetVideoImgResponse> getGetVideoImgResponses() {
        return getVideoImgResponses;
    }

    public void setGetVideoImgResponses(List<GetVideoImgResponse> getVideoImgResponses) {
        this.getVideoImgResponses = getVideoImgResponses;
    }
}
