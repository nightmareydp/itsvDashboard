package com.itsv.itsvdashboard.service;

import com.itsv.itsvdashboard.dto.CleanDataDto;

import java.util.List;
import java.util.Map;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 18:13
 */
public interface CleanDataService {


    /**
     * 清洗数据
     * @return Map<String,List>
     */
    Map<String,List> cleanAllData(List<CleanDataDto> getNeedColList);

}
