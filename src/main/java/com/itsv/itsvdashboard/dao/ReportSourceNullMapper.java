package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.ReportSourceNull;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author yuduopeng
 * @date 2021/2/10
 * @time 14:53
 */
@org.apache.ibatis.annotations.Mapper
public interface ReportSourceNullMapper extends Mapper<ReportSourceNull> {

    /**
     * 查询所有
     * @return list
     */
    List<ReportSourceNull> getAll();

    /**
     * 新增数据
     * @param reportSource 报告来源
     * @param id id
     */
    void setNewData(String id,String reportSource);

    /**
     * 删除数据
     * @param id id
     */
    void deleteData(String id);
}
