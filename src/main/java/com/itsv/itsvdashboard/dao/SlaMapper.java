package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.Sla;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 22:17
 */
@org.apache.ibatis.annotations.Mapper
public interface SlaMapper extends Mapper<Sla> {

    /**
     * 计算标准处理时长
     * @param lLevel 分派级别
     * @param pLevel 优先级别
     * @return 处理标准时长
     */
    Integer getSSla(String lLevel,String pLevel);
}
