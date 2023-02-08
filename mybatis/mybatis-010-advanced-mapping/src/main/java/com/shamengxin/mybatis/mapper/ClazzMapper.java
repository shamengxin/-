package com.shamengxin.mybatis.mapper;

import com.shamengxin.mybatis.pojo.Clazz;

public interface ClazzMapper {

    /**
     * 分步查询，第一步：根据班级编号获取班级信息
     * @param cid
     * @return
     */
    Clazz selectByStep1(Integer cid);

    /**
     * 根据班级编号，查询班级信息
     * @param cid
     * @return
     */
    Clazz selectByCollection(Integer cid);

    /**
     * 分步查询第二步：根据cid获取班级信息。
     * @param cid
     * @return
     */
    Clazz selectByIdStep2(Integer cid);

}
