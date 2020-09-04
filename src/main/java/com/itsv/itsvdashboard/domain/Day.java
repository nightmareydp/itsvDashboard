package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 15:00
 */
@Data
@Table(name = "t_day")
public class Day {

    /**
     * id
     */
    @Column(name = "id")
    private Integer id;

    /**
     * 日期
     */
    @Column(name = "date")
    private Date date;

    /**
     * 日期类型
     */
    @Column(name = "date_type")
    private String dateType;

    /**
     * 星期
     */
    @Column(name = "week")
    private String week;

    /**
     * 正常周
     */
    @Column(name = "default_week")
    private String defaultWeek;

    /**
     * 运维周
     */
    @Column(name = "operation_week")
    private String operationWeek;
}
