package com.itheima.dao;

import com.itheima.bean.User;

import java.util.List;

/**
 * @Author 王磊
 * @Date 2019/6/3/003
 */
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 添加用户
     * @param user
     */
    public void add(User user);

    /**
     * 更新用户
     * @param user
     */
    public void update(User user);
}
