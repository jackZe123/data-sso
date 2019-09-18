package com.yipai.mapper;

import com.yipai.pojo.Sitename;
import com.yipai.pojo.SitenameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SitenameMapper {
    int countByExample(SitenameExample example);

    int deleteByExample(SitenameExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sitename record);

    int insertSelective(Sitename record);

    List<Sitename> selectByExample(SitenameExample example);

    Sitename selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sitename record, @Param("example") SitenameExample example);

    int updateByExample(@Param("record") Sitename record, @Param("example") SitenameExample example);

    int updateByPrimaryKeySelective(Sitename record);

    int updateByPrimaryKey(Sitename record);
}