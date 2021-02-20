package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.SystemProductNull;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author yuduopeng
 * @date 2021/2/1
 * @time 16:49
 */
@org.apache.ibatis.annotations.Mapper
public interface SystemProductNullMapper extends Mapper<SystemProductNull> {

    /**
     * 查询所有
     * @return list
     */
    List<SystemProductNull> getAll();

    /**
     * 新增数据
     * @param systemClassificationLevel2 事件分类层二
     * @param systemClassificationLevel3 事件分类层三
     * @param id id
     */
    void setNewData(String id, String systemClassificationLevel2,String systemClassificationLevel3);


    /**
     * 删除数据
     * @param id id
     */
    void deleteData(String id);
}
