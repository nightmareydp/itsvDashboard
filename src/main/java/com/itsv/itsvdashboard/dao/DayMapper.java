package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.Day;
import com.itsv.itsvdashboard.dto.DayDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

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

    /**
     * 计算两个日期之间非工作日天数
     * @param beginDate 开始时间
     * @param endDate 结束时间
     * @return 非工作日天数
     */
    Integer getNotWorkDays(Date beginDate, Date endDate);

    /**
     * 查询所有
     * @return list
     */
    List<DayDto> getAll();

    /**
     * 新增数据
     * @param date 日期
     * @param dateType 日期类型
     * @param week 星期
     * @param defaultWeek 正常周
     * @param operationWeek 运维周
     */
    void setNewData(Date date,String dateType,String week,String defaultWeek,String operationWeek);

    /**
     * 更新数据
     * @param date 日期
     * @param dateType 日期类型
     * @param week 星期
     * @param defaultWeek 正常周
     * @param operationWeek 运维周
     * @param id id
     */
    void updateData(Date date,String dateType,String week,String defaultWeek,String operationWeek,String id);

    /**
     * 删除数据
     * @param id id
     */
    void deleteData(String id);
}
