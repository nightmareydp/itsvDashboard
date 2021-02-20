package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.SlaNull;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author yuduopeng
 * @date 2021/2/10
 * @time 17:11
 */
@org.apache.ibatis.annotations.Mapper
public interface SlaNullMapper extends Mapper<SlaNull> {

    /**
     * 查询所有
     * @return list
     */
    List<SlaNull> getAll();

    /**
     * 新增数据
     * @param level 分派级别（清洗后）
     * @param priorityLevel 优先级别
     * @param id id
     */
    void setNewData(String id,String level,String priorityLevel);

    /**
     * 删除数据
     * @param id id
     */
    void deleteData(String id);
}
