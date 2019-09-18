package com.yipai.mapper;

import com.yipai.facade.response.GetVideoImgResponse;
import com.yipai.facade.response.GetVideoIsPassResponse;
import com.yipai.facade.response.GetVideoResponse;
import com.yipai.facade.response.RankingListResponse;
import com.yipai.pojo.Video;
import com.yipai.pojo.VideoExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 11:00
 */
public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    int commitZan(Integer videoid);

    int cancelZan(Integer videoid);

    int commitLike(Integer videoid);

    int cancelLike(Integer videoid);

    int zanLenth(Integer videoid);

    int collectLength(Integer videoid);

    List<GetVideoImgResponse> videoImgs();

    List<GetVideoImgResponse> getImgByCategoryId(Integer categoryid);

    List<GetVideoImgResponse> getImgByPage(@Param("categoryid")Integer categoryid,@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);

    GetVideoResponse getVideoMessage(Integer videoid);

    List<RankingListResponse> getRankingList();

    int insertVideo(@Param("title")String title, @Param("username")String username, @Param("userid") Integer userid,@Param("categoryid")Integer categoryid, @Param("imgurlname")String imgurlname, @Param("videourlname")String videourlname, @Param("createTime") Date createTime, @Param("updateTime")Date updateTime);

    int videoCount(Integer categoryid);

    int checkVideoByVideoId(Integer videoid);

    int checkVideoByVideoIdUnPass(Integer videoid);

    List<GetVideoIsPassResponse> getVideoIsPass();

    int addBrowseNum(Integer videoid);
}
