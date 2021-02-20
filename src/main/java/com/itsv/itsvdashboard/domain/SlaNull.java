package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author yuduopeng
 * @date 2021/2/10
 * @time 17:07
 */
@Data
@Table(name = "t_sla_null")
public class SlaNull {

    /**
     * id
     */
    @Column(name = "id")
    private String id;

    /**
     * 分派级别（清洗后）
     */
    @Column(name = "l_level")
    private String level;

    /**
     * 优先级别
     */
    @Column(name = "p_level")
    private String priorityLevel;

    public SlaNull(String id, String level, String priorityLevel) {
        this.id = id;
        this.level = level;
        this.priorityLevel = priorityLevel;
    }
}
