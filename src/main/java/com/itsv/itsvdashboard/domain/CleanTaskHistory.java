package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 21:37
 */
@Data
@Table(name = "t_clean_task_history")
public class CleanTaskHistory {

    /**
     * id
     */
    @Column(name = "id")
    private String id;

    /**
     * 操作性质
     */
    @Column(name = "clean_type")
    private String cleanType;

    /**
     * 操作人时间
     */
    @Column(name = "date")
    private Date date;

    /**
     * 操作人
     */
    @Column(name = "operator")
    private String operator;


    /**
     * 操作人erp
     */
    @Column(name = "operator_erp")
    private String operatorErp;


}
