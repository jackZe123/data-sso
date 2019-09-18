package com.yipai.facade.response;

/**
 * @author zhengze
 * @version 1.0
 * @date :2019/9/7 18:51
 */
public class GetCategoryResponse {
    private Integer id;

    private String categoryName;

    private String categorySynopsis;

    private String createTime;

    @Override
    public String toString() {
        return "GetCategoryResponse{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categorySynopsis='" + categorySynopsis + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    private String updateTime;

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
        this.categoryName = categoryName;
    }

    public String getCategorySynopsis() {
        return categorySynopsis;
    }

    public void setCategorySynopsis(String categorySynopsis) {
        this.categorySynopsis = categorySynopsis;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
