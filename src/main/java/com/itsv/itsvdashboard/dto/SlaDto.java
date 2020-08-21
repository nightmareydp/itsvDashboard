package com.itsv.itsvdashboard.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author yuduopeng
 * @date 2020/6/19
 * @time 15:39
 */
@Data
public class SlaDto {

    /**
     * 工单号（id）
     */
    private String id;

    /**
     * 提交时间
     */
    private Date submissionTime;

    /**
     * 提交时间(小时)
     */
    private Integer submissionHours;

    /**
     * 解决时间
     */
    private Date resolutionTime;

    /**
     * 提交日期
     */
    private Date submissionDate;

    /**
     * 当日9点
     */
    private Date todayNine;

    /**
     * 提交时间new
     */
    private Date submissionTimeNew;

    /**
     * 处理时长
     */
    private Double processingTime;

    /**
     * 日期类型
     */
    private String dateType;

}
