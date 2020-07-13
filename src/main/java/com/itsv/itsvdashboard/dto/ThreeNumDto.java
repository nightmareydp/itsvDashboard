package com.itsv.itsvdashboard.dto;

import lombok.Data;

/**
 * @Author yuduopeng
 * @date 2020/6/14
 * @time 17:37
 */
@Data
public class ThreeNumDto {
    /**
     * 产品线名称
     */
    private String name;

    /**
     * 工单数
     */
    private int num;

    /**
     * 工单占比
     */
    private Float bili;
}
