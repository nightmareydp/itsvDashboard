package com.itsv.itsvdashboard.dao;

import com.itsv.itsvdashboard.domain.SystemProduct;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

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

    /**
     * 查询所有
     * @return list
     */
    List<SystemProduct> getAll();

    /**
     * 新增数据
     * @param systemClassificationLevel2 事件分类层二
     * @param systemClassificationLevel3 事件分类层三
     * @param productLine 产品线
     * @param productTag 产品标签
     */
    void setNewData(String systemClassificationLevel2,String systemClassificationLevel3,String productLine,String productTag);

    /**
     * 更新数据
     * @param systemClassificationLevel2 事件分类层二
     * @param systemClassificationLevel3 事件分类层三
     * @param productLine 产品线
     * @param productTag 产品标签
     * @param id id
     */
    void updateData(String systemClassificationLevel2,String systemClassificationLevel3,String productLine,String productTag,String id);

    /**
     * 删除数据
     * @param id id
     */
    void deleteData(String id);

}
