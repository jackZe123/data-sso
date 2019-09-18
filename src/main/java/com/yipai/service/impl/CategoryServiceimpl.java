package com.yipai.service.impl;

import com.yipai.common.ResponseCode;
import com.yipai.facade.response.GetCategoryResponse;
import com.yipai.mapper.CategoryMapper;
import com.yipai.service.CategoryService;
import com.yipai.utils.HaoCangResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 9:06
 */
@Service
public class CategoryServiceimpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public HaoCangResult addCategory(String categoryname, String categorysynopsis) {
        Date createTime = new Date();
        Date updateTime = new Date();
        if(categoryname==null||categoryname==""||categorysynopsis==null||categorysynopsis==""){
            return  HaoCangResult.build(ResponseCode.PARAM_IS_ERROR.getCode(),"参数错误");
        }
        int result = categoryMapper.addCategory(categoryname,categorysynopsis,createTime,updateTime);
        if(result<=0){
            return  HaoCangResult.build(ResponseCode.INSERT_ERROR.getCode(),"插入失败");
        }
        return HaoCangResult.ok();
    }


    @Override
    public HaoCangResult selectCategory(Integer pageIndex, Integer pageSize) {
        List<GetCategoryResponse> categories= new ArrayList<>();
        categories = categoryMapper.selectCategory();

        return HaoCangResult.ok(categories);
    }
}
