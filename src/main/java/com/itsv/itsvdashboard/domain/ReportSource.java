package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 3:32
 */
@Data
@Table(name = "t_report_source")
public class ReportSource {

    /**
     * id
     */
    @Column(name = "id")
    private Integer id;

    /**
     * 报告来源
     */
    @Column(name = "report_source")
    private String reportSource;

    /**
     * 报告来源new
     */
    @Column(name = "new_source")
    private String newSource;

    public ReportSource(Integer id, String reportSource, String newSource) {
        this.id = id;
        this.reportSource = reportSource;
        this.newSource = newSource;
    }
}
