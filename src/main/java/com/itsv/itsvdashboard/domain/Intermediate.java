package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 17:28
 */
@Data
@Table(name = "t_intermediate")
public class Intermediate {

    /**
     * 工单号（id）
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 服务台
     */
    @Column(name = "reception")
    private String reception;

    /**
     * 受派人
     */
    @Column(name = "assigned_person")
    private String assignedPerson;

    /**
     * 受派三级部门
     */
    @Column(name = "assigned_level_3_department")
    private String assignedLevel3Department;

    /**
     * 优先级
     */
    @Column(name = "priority")
    private String priority;

    /**
     * 系统分类二层
     */
    @Column(name = "system_classification_level_2")
    private String systemClassificationLevel2;

    /**
     * 系统分类三层
     */
    @Column(name = "system_classification_level_3")
    private String systemClassificationLevel3;

    /**
     * 报告来源
     */
    @Column(name = "report_source")
    private String reportSource;

    /**
     * 态度得分
     */
    @Column(name = "attitude_score")
    private Integer attitudeScore;

    /**
     * 时效得分
     */
    @Column(name = "timeliness_score")
    private Integer timelinessScore;

    /**
     * 事件分类层二
     */
    @Column(name = "event_classification_level_2")
    private String eventClassificationLevel2;

    /**
     * 事件分类层三
     */
    @Column(name = "event_classification_level_3")
    private String eventClassificationLevel3;

    /**
     * 提交时间
     */
    @Column(name = "submission_time")
    private Date submissionTime;

    /**
     * 解决时间
     */
    @Column(name = "resolution_time")
    private Date resolutionTime;

    /**
     * 提交日期
     */
    @Column(name = "submission_date")
    private Date submissionDate;

    /**
     * 提交时间(小时h)
     */
    @Column(name = "submission_hours")
    private Integer submissionHours;

    /**
     * 当日9点
     */
    @Column(name = "today_nine")
    private Date todayNine;

    /**
     * 下一个工作日(9点)
     */
    @Column(name = "next_work_day")
    private Date nextWorkDay;

    /**
     * 提交时间new
     */
    @Column(name = "submission_time_new")
    private Date submissionTimeNew;

    /**
     * 处理时长
     */
    @Column(name = "processing_time")
    private Double processingTime;

    /**
     * 日期类型
     */
    @Column(name = "day_type")
    private String dateType;

    /**
     * 标准处理时长
     */
    @Column(name = "s_sla")
    private Integer sSla;

    /**
     * 是否超时
     */
    @Column(name = "is_ok")
    private String isOk;

    /**
     * 满意度
     */
    @Column(name = "is_satisfied")
    private String satisfied;

    /**
     * 分派级别
     */
    @Column(name = "level")
    private String level;

    /**
     * 产品线
     */
    @Column(name = "product_line")
    private String productLine;

    /**
     * 产品标签
     */
    @Column(name = "product_tag")
    private String productTag;

    /**
     * 报告来源new
     */
    @Column(name = "report_source_new")
    private String newSource;

    /**
     * 主事件类型
     */
    @Column(name = "m_event_type")
    private String masterEventType;

    /**
     * 子事件类型
     */
    @Column(name = "s_event_type")
    private String sonEventType;
}
