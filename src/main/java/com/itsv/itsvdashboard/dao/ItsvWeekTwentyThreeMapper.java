package com.itsv.itsvdashboard.dao;


import com.itsv.itsvdashboard.domain.ItsvWeekTwentyThree;
import com.itsv.itsvdashboard.dto.CleanDataDto;
import com.itsv.itsvdashboard.dto.ThreeNumDto;
import com.itsv.itsvdashboard.dto.SlaDto;
import com.itsv.itsvdashboard.dto.TwoNumDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @Author yuduopeng
 * @date 2020/6/6
 * @time 22:27
 */
@org.apache.ibatis.annotations.Mapper
public interface ItsvWeekTwentyThreeMapper extends Mapper<ItsvWeekTwentyThree> {

    /**
     * 查询每人处理单量
     * @return list
     */
    List<TwoNumDto> getWorkload();

    /**
     * 查询系统单量TOP10
     * @return list
     */
    List<TwoNumDto> getSystemNum();

    /**
     * 本周产品线事件单周占比
     * @return list
     */
    List<ThreeNumDto> getProductLine();

    /**
     * 查询满意度
     * @return list
     */
    List<TwoNumDto> getSatisfaction();

    /**
     * 判断日期类型
     * @param date 提交日期
     * @return 日期类型
     */
    String isWorkDay(Date date);

    /**
     * 获取下一个工作日(9点)
     * @param date 提交日期
     * @return 日期
     */
    Date getNextWorkDay(Date date);

    /**
     * 获取SLA相关数据
     * @return list
     */
    List<SlaDto> getSlaData();

    /**
     * 获取标准处理时长
     * @param id 工单号
     * @return 时长
     */
    Integer getStandard(String id);

    /**
     * 获取SLA相关数据
     * @return list
     */
    List<CleanDataDto> getNeedCol();


}
