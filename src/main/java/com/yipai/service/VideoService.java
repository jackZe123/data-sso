package com.yipai.service;

import com.yipai.utils.HaoCangResult;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 10:28
 */
public interface VideoService {
    HaoCangResult commitZan(Integer videoid);

    HaoCangResult cancelZan(Integer videoid);

    @Transactional
    HaoCangResult commitLike(String userAccount,Integer videoid);

    @Transactional
    HaoCangResult cancelLike(String userAccount,Integer videoid);

    int insertVideo(String title,String username,Integer userid,Integer categoryid,String imgname,String videlname);
}
