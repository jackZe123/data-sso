package com.yipai.controller;

import com.yipai.common.Const;
import com.yipai.common.ResponseCode;
import com.yipai.facade.response.GetCategoryResponse;
import com.yipai.mapper.CategoryMapper;
import com.yipai.service.CategoryService;
import com.yipai.utils.HaoCangResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 8:35
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
@Autowired
private CategoryService categoryService;

@Autowired
private CategoryMapper categoryMapper;

    @RequestMapping(value = "/addCategory")
    @ResponseBody
    public HaoCangResult addCategory(@RequestParam String categoryname, @RequestParam String categorysynopsis, HttpSession session){
       Object admin= session.getAttribute(Const.ADMIN);
       if(admin==null){
           return HaoCangResult.build(ResponseCode.NO_PRIVILEGES.getCode(),"没有权限");
       }
        categoryService.addCategory(categoryname,categorysynopsis);
        GetCategoryResponse getCategoryResponse = categoryMapper.selectCategoryByName(categoryname);
        return HaoCangResult.ok(getCategoryResponse);
    }

    @RequestMapping(value = "/deleteCategory")
    @ResponseBody
    public HaoCangResult deleteCategory(@RequestParam Integer categoryid){
        int result = categoryMapper.deleteCategory(categoryid);
        if (result<1){
            return HaoCangResult.build(ResponseCode.INSERT_ERROR.getCode(),"删除失败");
        }
        return HaoCangResult.ok();
    }

    @RequestMapping(value = "/selectCategory")
    @ResponseBody
    public HaoCangResult selectCategory(@RequestParam Integer pageIndex, @RequestParam Integer pageSize){
        return categoryService.selectCategory(pageIndex,pageSize);
    }


}
