package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.dto.CleanDataDto;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 21:11
 */
@org.apache.ibatis.annotations.Mapper
public interface CleanDataMapper extends Mapper<CleanDataDto> {

    /**
     * 查询满意度
     * @param attitudeScore 态度得分
     * @param timelinessScore 时效得分
     * @return
     */
    String getSatisfaction(Integer attitudeScore,Integer timelinessScore);
}
