package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 21:54
 */
@Data
@Table(name = "t_dspatch_level")
public class DspatchLevel {

    /**
     * id
     */
    @Column(name = "id")
    private Integer id;

    /**
     * 受派三级部门
     */
    @Column(name = "ASSIGNED_LEVEL_3_DEPARTMENT")
    private String assignedLevel3Department;

    /**
     * 受派人
     */
    @Column(name = "ASSIGNED_PERSON")
    private String assignedPerson;

    /**
     * 分派级别
     */
    @Column(name = "LEVEL")
    private String level;
}
