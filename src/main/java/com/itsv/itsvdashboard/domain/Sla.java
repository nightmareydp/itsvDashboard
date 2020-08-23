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
     * 分派级别
     */
    @Column(name = "l_level")
    private String lLevel;

    /**
     * 优先级别
     */
    @Column(name = "p_level")
    private String pLevel;

    /**
     * 响应标准时长
     */
    @Column(name = "m_sla")
    private String mSla;

    /**
     * 处理标准时长
     */
    @Column(name = "s_sla")
    private Integer sSla;
}
