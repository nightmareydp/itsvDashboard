package com.itsv.itsvdashboard.service;

import com.itsv.itsvdashboard.dto.ThreeNumDto;
import com.itsv.itsvdashboard.dto.TwoNumDto;

import java.util.List;

/**
 * @Author yuduopeng
 * @date 2020/6/6
 * @time 23:33
 */
public interface ItsvWeekTwentyThreeService {

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
     * 查询SLA达标率
     * @return list
     */
    List<TwoNumDto> getSLA();


}
