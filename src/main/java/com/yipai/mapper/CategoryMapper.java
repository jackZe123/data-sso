package com.yipai.mapper;

import com.yipai.facade.response.GetCategoryMainResponse;
import com.yipai.facade.response.GetCategoryResponse;
import com.yipai.pojo.Category;
import com.yipai.pojo.CategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CategoryMapper {
    int countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    int addCategory(@Param("categoryname")String categoryname, @Param("categorysynopsis")String categorysynopsis, @Param("createtime")Date createtime,@Param("updatetime")Date updatetime);

    int deleteCategory(Integer categoryid);

     List<GetCategoryResponse> selectCategory();

     List<GetCategoryMainResponse> categorys();

     int getCategoryId(String categoryname);

     GetCategoryResponse selectCategoryByName(String categoryname);
}