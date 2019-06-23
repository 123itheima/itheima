package com.itheima.dao;

import com.itheima.bean.Route;
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

public class RouteDaoTest {

    private InputStream is;
    private SqlSession sqlSession;
    private RouteDao routeDao;

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
        sqlSession = factory.openSession();
        //4. 获取接口的实现类对象
        routeDao = sqlSession.getMapper(RouteDao.class);//实现类对象
    }

    @After
    public void destroy() throws IOException {
        //6. 释放资源
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void findAll() {
        List<Route> routes = routeDao.findAll();
        for (Route route : routes) {
            System.out.println(route);
        }
    }

    @Test
    public void findLikeName() {
        List<Route> routes = routeDao.findLikeName("%春节%");
        for (Route route : routes) {
            System.out.println(route);
        }
    }

    @Test
    public void findByCid() {
        List<Route> routes = routeDao.findByCid(5);
        for (Route route : routes) {
            System.out.println(route);
        }
    }

    @Test
    public void findByRid() {
        Route route = routeDao.findByRid(10);
        System.out.println(route);
    }

    @Test
    public void findTotalCount() {
        Integer count = routeDao.findTotalCount();
        System.out.println(count);
    }

    @Test
    public void findTotalCount2() {
        Integer count = routeDao.findTotalCount2("%云南%");
        System.out.println(count);
    }

    @Test
    public void findTotalCount3() {
        Integer count = routeDao.findTotalCount3(5);
        System.out.println(count);
    }
}