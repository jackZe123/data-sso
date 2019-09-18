package com.yipai.facade.response;

import java.util.List;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/8 17:34
 */
public class GetVideoMessageByVideoIdResponse {
    private GetVideoResponse video;
    private List<GetCommentResponse> getCommentResponseList;

    @Override
    public String toString() {
        return "GetVideoMessageByVideoIdResponse{" +
                "video=" + video +
                ", getCommentResponseList=" + getCommentResponseList +
                '}';
    }

    public GetVideoResponse getVideo() {
        return video;
    }

    public void setVideo(GetVideoResponse video) {
        this.video = video;
    }

    public List<GetCommentResponse> getGetCommentResponseList() {
        return getCommentResponseList;
    }

    public void setGetCommentResponseList(List<GetCommentResponse> getCommentResponseList) {
        this.getCommentResponseList = getCommentResponseList;
    }
}
