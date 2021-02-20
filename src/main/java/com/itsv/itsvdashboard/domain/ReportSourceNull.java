package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author yuduopeng
 * @date 2021/2/10
 * @time 14:51
 */
@Data
@Table(name = "t_report_source_null")
public class ReportSourceNull {

    /**
     * id
     */
    @Column(name = "id")
    private String id;

    /**
     * 报告来源
     */
    @Column(name = "report_source")
    private String reportSource;


    public ReportSourceNull(String id, String reportSource) {
        this.id = id;
        this.reportSource = reportSource;
    }
}
