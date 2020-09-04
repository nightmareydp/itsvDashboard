package com.itsv.itsvdashboard.dto;

import lombok.Data;

/**
 * @Author yuduopeng
 * @date 2020/9/5
 * @time 2:59
 */
@Data
public class DayDto {

    /**
     * id
     */
    private Integer id;

    /**
     * 日期
     */
    private String date;

    /**
     * 日期类型
     */
    private String dateType;

    /**
     * 星期
     */
    private String week;

    /**
     * 正常周
     */
    private String defaultWeek;

    /**
     * 运维周
     */
    private String operationWeek;

}
