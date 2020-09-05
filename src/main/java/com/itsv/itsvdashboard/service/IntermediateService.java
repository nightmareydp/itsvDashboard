package com.itsv.itsvdashboard.service;

import com.itsv.itsvdashboard.dto.CleanDataDto;
import com.itsv.itsvdashboard.dto.TwoNumDto;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 18:25
 */
public interface IntermediateService {

    /**
     * 获取全量数据
     * @return CleanDataDto
     */
    List<CleanDataDto> getAllData();
    /**
     * 清洗全量数据
     * @return Map<String,List>
     */
    Map<String,List> CleanAllData();

    /**
     * 获取当前时间至上一次洗数的数据
     * @return list
     */
    List<CleanDataDto> getNeedColToLastTime();
    /**
     * 清洗当前时间至上一次洗数的数据
     * @return Map<String,List>
     */
    Map<String,List> CleanToLastTimeData();

    /**
     * 获取自定义时间的数据
     * @return list
     */
    List<CleanDataDto> getNeedColSetupTime(Date stateTime,Date endTime);
    /**
     * 清洗自定义时间的数据
     * @return Map<String,List>
     */
    Map<String,List> CleanSetupTimeData(Date stateTime,Date endTime);


    /**
     * 查询总量趋势
     * @return List<TwoNumDto>
     */
    List<TwoNumDto> getTotalTrend();

    /**
     * 查询满意度
     * @return List<TwoNumDto>
     */
    List<TwoNumDto> getSatisfaction();

    /**
     * 获取SLA
     * @return List<TwoNumDto>
     */
    List<TwoNumDto> getSla();

}
