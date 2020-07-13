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
    private String id;

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
}
