package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author yuduopeng
 * @date 2021/2/1
 * @time 16:36
 */
@Data
@Table(name = "t_system_product_null")
public class SystemProductNull {

    /**
     * 防重id(两个字符串合并MD5加密)
     */
    @Column(name = "id")
    private String id;

    /**
     * 事件分类层二
     */
    @Column(name = "system_classification_level_2")
    private String systemClassificationLevel2;

    /**
     * 事件分类层三
     */
    @Column(name = "system_classification_level_3")
    private String systemClassificationLevel3;

    public SystemProductNull(String id, String systemClassificationLevel2, String systemClassificationLevel3) {
        this.id = id;
        this.systemClassificationLevel2 = systemClassificationLevel2;
        this.systemClassificationLevel3 = systemClassificationLevel3;
    }
}
