package com.itheima.factory;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author 王磊
 * @Date 2019/6/3/003
 */
public class MyDataSourceFactory implements DataSourceFactory {

    private Properties properties;

    /**
     * mybatis在运行的过程中,如果发现datasource 的type属性 指向的是一个用户自定义的DataSourceFactory实现类
     * 在执行的时候会将dataSource标签中配置的property标签中的数据解析,封装到一个Properties对象中
     * 在获取连接池 之前会自动调用 setProperties 方法,将上一步封装的 Properties对象 传入进来
     * @param properties
     */

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties ;
        //String driver = properties.getProperty("driver");
        //String url = properties.getProperty("url");
        //String username = properties.getProperty("username");
        //String password = properties.getProperty("password");
    }

    @Override
    public DataSource getDataSource() {
        //创建第三方连接池并返回
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getProperty("driver"));
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));

        return dataSource;
    }
}
