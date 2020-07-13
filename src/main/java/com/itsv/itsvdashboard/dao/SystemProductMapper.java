package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.SystemProduct;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 22:39
 */
@org.apache.ibatis.annotations.Mapper
public interface SystemProductMapper extends Mapper<SystemProduct> {

    /**
     * 计算产品线
     * @param systemClassificationLevel2 事件分类层二
     * @param systemClassificationLevel3 事件分类层三
     * @return 产品线
     */
    String getProductLine(String systemClassificationLevel2,String systemClassificationLevel3);

    /**
     * 计算产品标签
     * @param systemClassificationLevel2 事件分类层二
     * @param systemClassificationLevel3 事件分类层三
     * @return 产品标签
     */
    String getProductTag(String systemClassificationLevel2,String systemClassificationLevel3);
}
