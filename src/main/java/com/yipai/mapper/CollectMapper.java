package com.yipai.mapper;

import com.yipai.pojo.Collect;
import com.yipai.pojo.CollectExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CollectMapper {
    int countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    int addCollect(@Param("userid") Integer userid,@Param("videoid") Integer videoid,@Param("createtime") Date createtime,@Param("updatetime") Date updatetime);

    int deleteCollect(@Param("userid") Integer userid,@Param("videoid") Integer videoid);
}