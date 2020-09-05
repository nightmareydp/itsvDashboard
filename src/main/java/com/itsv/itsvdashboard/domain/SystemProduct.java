package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 22:39
 */
@Data
@Table(name = "t_system_product")
public class SystemProduct {

    /**
     * id
     */
    @Column(name = "id")
    private Integer id;

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

    /**
     * 产品线
     */
    @Column(name = "product_line")
    private String productLine;

    /**
     * 产品标签
     */
    @Column(name = "product_tag")
    private String productTag;

    public SystemProduct(Integer id, String systemClassificationLevel2, String systemClassificationLevel3, String productLine, String productTag) {
        this.id = id;
        this.systemClassificationLevel2 = systemClassificationLevel2;
        this.systemClassificationLevel3 = systemClassificationLevel3;
        this.productLine = productLine;
        this.productTag = productTag;
    }
}
