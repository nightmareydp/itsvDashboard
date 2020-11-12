package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.Sla;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 22:17
 */
@org.apache.ibatis.annotations.Mapper
public interface SlaMapper extends Mapper<Sla> {

    /**
     * 计算标准处理时长
     * @param level 分派级别（清洗后）
     * @param priorityLevel 优先级别
     * @return 处理标准时长
     */
    String getSonSla(String level,String priorityLevel);

    /**
     * 查询所有
     * @return list
     */
    List<Sla> getAll();

    /**
     * 新增数据
     * @param level 分派级别（清洗后）
     * @param priorityLevel 优先级别
     * @param masterSla 响应标准时长
     * @param sonSla 处理标准时长
     */
    void setNewData(String level,String priorityLevel,String masterSla,String sonSla);

    /**
     * 更新数据
     * @param level 分派级别（清洗后）
     * @param priorityLevel 优先级别
     * @param masterSla 响应标准时长
     * @param sonSla 处理标准时长
     * @param id id
     */
    void updateData(String level,String priorityLevel,String masterSla,String sonSla,String id);

    /**
     * 删除数据
     * @param id id
     */
    void deleteData(String id);
}
