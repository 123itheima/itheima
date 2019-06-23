package com.itheima.dao;

import com.itheima.bean.Category;

import java.util.List;

public interface CategoryDao {

    /**
     * 查询所有分类数据
     * @return
     */
    public List<Category> findAll();

    /**
     * 添加一条分类数据
     * @param category
     * @return
     */
    public Integer add(Category category);

    /**
     * 根据分类ID,更新分类数据
     * @param category
     */
    public void update(Category category);

    /**
     * 根据id删除分类
     * @param cid
     */
    public void delete(Integer cid);
}
