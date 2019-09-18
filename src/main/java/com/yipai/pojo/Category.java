package com.yipai.pojo;

import java.util.Date;

public class Category {
    private Integer id;

    private String categoryName;

    private String categorySynopsis;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategorySynopsis() {
        return categorySynopsis;
    }

    public void setCategorySynopsis(String categorySynopsis) {
        this.categorySynopsis = categorySynopsis == null ? null : categorySynopsis.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}