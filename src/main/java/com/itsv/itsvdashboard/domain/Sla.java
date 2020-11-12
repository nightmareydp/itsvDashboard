package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 22:12
 */
@Data
@Table(name = "t_sla")
public class Sla {

    /**
     * id
     */
    @Column(name = "id")
    private Integer id;

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

    /**
     * 响应标准时长
     */
    @Column(name = "m_sla")
    private String masterSla;

    /**
     * 处理标准时长
     */
    @Column(name = "s_sla")
    private String sonSla;

    public Sla(Integer id, String level, String priorityLevel, String masterSla, String sonSla) {
        this.id = id;
        this.level = level;
        this.priorityLevel = priorityLevel;
        this.masterSla = masterSla;
        this.sonSla = sonSla;
    }
}
