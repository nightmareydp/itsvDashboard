package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.EventTypeNull;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author yuduopeng
 * @date 2021/2/9
 * @time 10:03
 */
@org.apache.ibatis.annotations.Mapper
public interface EventTypeNullMapper extends Mapper<EventTypeNull> {

    /**
     * 查询所有
     * @return list
     */
    List<EventTypeNull> getAll();

    /**
     * 新增数据
     * @param id id
     * @param eventClassificationLevel2 事件分类层二
     * @param eventClassificationLevel3 事件分类层三
     */
    void setNewData(String id, String eventClassificationLevel2,String eventClassificationLevel3);


    /**
     * 删除数据
     * @param id id
     */
    void deleteData(String id);
}
