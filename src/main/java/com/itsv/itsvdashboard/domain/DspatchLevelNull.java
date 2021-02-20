package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author yuduopeng
 * @date 2021/2/8
 * @time 15:42
 */
@Data
@Table(name = "t_dspatch_level_null")
public class DspatchLevelNull {

    /**
     * id
     */
    @Column(name = "id")
    private String id;

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

    public DspatchLevelNull(String id, String assignedLevel3Department, String assignedPerson) {
        this.id = id;
        this.assignedLevel3Department = assignedLevel3Department;
        this.assignedPerson = assignedPerson;
    }
}
