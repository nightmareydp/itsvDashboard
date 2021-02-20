package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.DspatchLevelNull;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author yuduopeng
 * @date 2021/2/8
 * @time 15:47
 */
@org.apache.ibatis.annotations.Mapper
public interface DspatchLevelNullMapper extends Mapper<DspatchLevelNull> {

    /**
     * 查询所有
     * @return list
     */
    List<DspatchLevelNull> getAll();

    /**
     * 新增数据
     * @param assignedLevel3Department 受派三级部门
     * @param assignedPerson 受派人
     * @param id id
     */
    void setNewData(String id, String assignedLevel3Department,String assignedPerson);

    /**
     * 删除数据
     * @param id id
     */
    void deleteData(String id);

}
