package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.Intermediate;
import com.itsv.itsvdashboard.dto.CleanDataDto;
import com.itsv.itsvdashboard.dto.TwoNumDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 17:52
 */
@org.apache.ibatis.annotations.Mapper
public interface IntermediateMapper extends Mapper<Intermediate> {

    /**
     * 将清洗后数据插入中间表
     * @param cleanDataDto 清洗后cleanDataDto列表
     */
    void setIntermediate(List<CleanDataDto> cleanDataDto);

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

    /**
     * 获取各产品线SLA(全部)
     * @return List<TwoNumDto>
     */
    List<TwoNumDto> getEveryPSla();

    /**
     * 获取各产品线SLA(未超时)
     * @return List<TwoNumDto>
     */
    List<TwoNumDto> getEveryPOkSla();

    /**
     * 获取指定产品线top3标签
     * @param productLine 产品线
     * @return TOP3产品标签
     */
    List<String> getTopProductTag(String productLine);

    /**
     * 获取指定产品标签的事件分类
     * @param productTag 产品标签
     * @return List<TwoNumDto>
     */
    List<TwoNumDto> getEventType(String productTag);

}
