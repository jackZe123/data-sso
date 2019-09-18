package com.yipai.service;

import com.yipai.utils.HaoCangResult;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/6 9:05
 */
public interface CategoryService {
    HaoCangResult addCategory(String categoryname, String categorysynopsis);



    HaoCangResult selectCategory(Integer pageIndex,Integer pageSize);
}

