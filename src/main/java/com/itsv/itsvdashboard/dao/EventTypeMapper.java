package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.EventType;
import tk.mybatis.mapper.common.Mapper;

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
    String getMEventType(String eventClassificationLevel2,String eventClassificationLevel3);

    /**
     * 计算子事件类型
     * @param eventClassificationLevel2 事件分类层二
     * @param eventClassificationLevel3 事件分类层三
     * @return 子事件类型
     */
    String getSEventType(String eventClassificationLevel2,String eventClassificationLevel3);
}
