package com.itheima.dao;


import com.itheima.bean.Route;

import java.util.List;

public interface RouteDao {

    /**
     * 查询所有旅游线路
     * @return
     */
    List<Route> findAll();

    /**
     * 根据用户输入的字符串,模糊查询线路
     * @param rname
     * @return
     */
    List<Route> findLikeName(String rname);

    /**
     * 根据分类id查询线路信息
     * @param cid
     * @return
     */
    List<Route> findByCid(Integer cid);

    /**
     * 根据线路id查询线路详情
     * @param rid
     * @return
     */
    Route findByRid(Integer rid);

    /**
     * 查询数据库中的所有线路数量
     * @return
     */
    Integer findTotalCount();

    /**
     * 查询数据库中,线路名称包含rname的线路数量
     * @return
     */
    Integer findTotalCount2(String rname);


    /**
     * 查询数据库中,查询某一个分类下的线路数量
     * @return
     */
    Integer findTotalCount3(Integer cid);

}
