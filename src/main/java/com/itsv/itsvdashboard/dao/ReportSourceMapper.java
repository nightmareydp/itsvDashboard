package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.ReportSource;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

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

    /**
     * 查询所有
     * @return list
     */
    List<ReportSource> getAll();

    /**
     * 新增数据
     * @param reportSource 报告来源
     * @param newSource 报告来源new
     */
    void setNewData(String reportSource,String newSource);

    /**
     * 更新数据
     * @param reportSource 报告来源
     * @param newSource 报告来源new
     * @param id id
     */
    void updateData(String reportSource,String newSource,String id);

    /**
     * 删除数据
     * @param id id
     */
    void deleteData(String id);
}
