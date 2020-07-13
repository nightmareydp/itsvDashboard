package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.CleanTaskHistory;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 21:41
 */
@org.apache.ibatis.annotations.Mapper
public interface CleanTaskHistoryMapper extends Mapper<CleanTaskHistory> {

    /**
     * 记录系数操作记录
     * @param
     */
    void setCleanTask(CleanTaskHistory cleanTaskHistory);

    /**
     * 查询上一次清洗数据时间
     * @param
     */
    Date getLastCleanTime();
}
