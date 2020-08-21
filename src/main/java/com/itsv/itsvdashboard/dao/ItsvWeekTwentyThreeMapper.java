package com.itsv.itsvdashboard.dao;


import com.itsv.itsvdashboard.domain.ItsvWeekTwentyThree;
import com.itsv.itsvdashboard.dto.CleanDataDto;
import com.itsv.itsvdashboard.dto.ThreeNumDto;
import com.itsv.itsvdashboard.dto.SlaDto;
import com.itsv.itsvdashboard.dto.TwoNumDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @Author yuduopeng
 * @date 2020/6/6
 * @time 22:27
 */
@org.apache.ibatis.annotations.Mapper
public interface ItsvWeekTwentyThreeMapper extends Mapper<ItsvWeekTwentyThree> {

    /**
     * 获取全量数据
     * @return list
     */
    List<CleanDataDto> getNeedCol();

    /**
     * 获取当前时间至上一次洗数的数据
     * @return list
     */
    List<CleanDataDto> getNeedColToLastTime(Date stateTime,Date endTime);

    /**
     * 获取自定义时间的数据
     * @return list
     */
    List<CleanDataDto> getNeedColSetupTime(Date stateTime,Date endTime);


}
