package com.itsv.itsvdashboard.service;

import com.itsv.itsvdashboard.dto.CleanDataDto;

import java.util.List;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 18:13
 */
public interface CleanDataService {


    /**
     * 清洗数据
     * @return CleanDataDto
     */
    List<CleanDataDto> cleanAllData(List<CleanDataDto> getNeedColList);

}
