package com.itheima.dao;

import com.itheima.bean.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryDaoTest {

    private InputStream is;
    private SqlSession sqlSession;
    private CategoryDao categoryDao;

    @Before
    public void init() throws IOException {
        //1. 加载核心配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory对象
        //2.1 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //2.2 构建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(is);
        //3. 创建SqlSession对象
        sqlSession = factory.openSession(true); //setAutoCommit(true)
        //4. 获取接口的实现类对象
        categoryDao = sqlSession.getMapper(CategoryDao.class);//实现类对象
    }

    @After
    public void destroy() throws IOException {
        //6. 释放资源
        //sqlSession.commit();
        sqlSession.close();
        is.close();
    }


    @Test
    public void findAll() throws IOException {
        //5. 执行操作
        List<Category> categories = categoryDao.findAll();
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    @Test
    public void add() {
        Category category = new Category();
        category.setCname("古墓一日游");
        categoryDao.add(category);

        //获取返回的主键
        int cid = category.getCid();
        System.out.println(cid);
    }

    @Test
    public void update() {
        Category category = new Category();
        category.setCid(10);
        category.setCname("古墓一日游");

        categoryDao.update(category);
    }

    @Test
    public void delete() {
        categoryDao.delete(10);
    }
}