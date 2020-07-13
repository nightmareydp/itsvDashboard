package com.itsv.itsvdashboard.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 18:07
 */
@Data
public class CleanDataDto {

    /**
     * 工单号（id）
     */
    private String id;

    /**
     * 服务台
     */
    private String reception;

    /**
     * 受派人
     */
    private String assignedPerson;

    /**
     * 受派三级部门
     */
    private String assignedLevel3Department;

    /**
     * 优先级
     */
    private String priority;

    /**
     * 系统分类二层
     */
    private String systemClassificationLevel2;

    /**
     * 系统分类三层
     */
    private String systemClassificationLevel3;

    /**
     * 报告来源
     */
    private String reportSource;

    /**
     * 态度得分
     */
    private Integer attitudeScore;

    /**
     * 时效得分
     */
    private Integer timelinessScore;

    /**
     * 事件分类层二
     */
    private String eventClassificationLevel2;

    /**
     * 事件分类层三
     */
    private String eventClassificationLevel3;

    /**
     * 提交时间
     */
    private Date submissionTime;

    /**
     * 解决时间
     */
    private Date resolutionTime;

    /**
     * 提交日期
     */
    private Date submissionDate;

    /**
     * 提交时间(小时h)
     */
    private Integer submissionHours;

    /**
     * 当日9点
     */
    private Date todayNine;

    /**
     * 下一个工作日(9点)
     */
    private Date nextWorkDay;

    /**
     * 提交时间new
     */
    private Date submissionTimeNew;

    /**
     * 处理时长
     */
    private Long processingTime;

    /**
     * 日期类型
     */
    private String dateType;

    /**
     * 标准处理时长
     */
    private Integer sSla;

    /**
     * 是否超时
     */
    private String isOk;

    /**
     * 满意度
     */
    private String satisfied;

    /**
     * 分派级别
     */
    private String level;

    /**
     * 产品线
     */
    private String productLine;

    /**
     * 产品标签
     */
    private String productTag;

    /**
     * 报告来源new
     */
    private String newSource;

    /**
     * 主事件类型
     */
    private String mEventType;

    /**
     * 子事件类型
     */
    private String sEventType;
}
