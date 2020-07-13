package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.ReportSource;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 3:31
 */
@org.apache.ibatis.annotations.Mapper
public interface ReportSourceMapper extends Mapper<ReportSource> {

    /**
     * 计算报告来源
     * @param reportSource 报告来源
     * @return 报告来源new
     */
    String getReportSource(String reportSource);
}
