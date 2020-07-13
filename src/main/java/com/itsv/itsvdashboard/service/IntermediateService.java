package com.itsv.itsvdashboard.service;

import com.itsv.itsvdashboard.dto.CleanDataDto;
import com.itsv.itsvdashboard.dto.TwoNumDto;

import java.util.List;

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
     * @return CleanDataDto
     */
    void getCleanAllData();

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
