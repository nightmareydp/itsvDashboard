package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.Day;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 15:07
 */
@org.apache.ibatis.annotations.Mapper
public interface DayMapper extends Mapper<Day> {

    /**
     * 计算日期类型
     * @param date 日期
     * @return 日期类型
     */
    String getDateType(Date date);

    /**
     * 计算当日9点
     * @param date 日期
     * @return 当日9点
     */
    Date getTodayNine(Date date);

    /**
     * 计算下一个工作日(9点)
     * @param date 日期
     * @return 下一个工作日(9点)
     */
    Date getNextWorkDay(Date date);
}
