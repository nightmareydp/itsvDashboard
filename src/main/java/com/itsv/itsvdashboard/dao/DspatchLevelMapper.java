package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.DspatchLevel;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 22:01
 */
@org.apache.ibatis.annotations.Mapper
public interface DspatchLevelMapper extends Mapper<DspatchLevel> {

    /**
     * 查询分派级别
     * @param assignedLevel3Department 受派三级部门
     * @param assignedPerson 受派人
     * @return 分派级别
     */
    String getLevel(String assignedLevel3Department,String assignedPerson);
}
