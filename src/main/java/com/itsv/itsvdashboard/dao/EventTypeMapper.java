package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.EventType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 4:10
 */
@org.apache.ibatis.annotations.Mapper
public interface EventTypeMapper extends Mapper<EventType> {

    /**
     * 计算主事件类型
     * @param eventClassificationLevel2 事件分类层二
     * @param eventClassificationLevel3 事件分类层三
     * @return 主事件类型
     */
    String getMasterEventType(String eventClassificationLevel2,String eventClassificationLevel3);

    /**
     * 计算子事件类型
     * @param eventClassificationLevel2 事件分类层二
     * @param eventClassificationLevel3 事件分类层三
     * @return 子事件类型
     */
    String getSonEventType(String eventClassificationLevel2,String eventClassificationLevel3);

    /**
     * 查询所有
     * @return list
     */
    List<EventType> getAll();

    /**
     * 新增数据
     * @param eventClassificationLevel2 事件分类层二
     * @param eventClassificationLevel3 事件分类层三
     * @param masterEventType 主事件类型
     * @param sonEventType 子事件类型
     */
    void setNewData(String eventClassificationLevel2,String eventClassificationLevel3,String masterEventType,String sonEventType);

    /**
     * 更新数据
     * @param eventClassificationLevel2 事件分类层二
     * @param eventClassificationLevel3 事件分类层三
     * @param masterEventType 主事件类型
     * @param sonEventType 子事件类型
     * @param id id
     */
    void updateData(String eventClassificationLevel2,String eventClassificationLevel3,String masterEventType,String sonEventType,String id);

    /**
     * 删除数据
     * @param id id
     */
    void deleteData(String id);
}
