package com.itsv.itsvdashboard.controller;

import com.itsv.itsvdashboard.dao.DspatchLevelMapper;
import com.itsv.itsvdashboard.dao.EventTypeMapper;
import com.itsv.itsvdashboard.dao.SystemProductMapper;
import com.itsv.itsvdashboard.domain.DspatchLevel;
import com.itsv.itsvdashboard.domain.EventType;
import com.itsv.itsvdashboard.domain.SystemProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yuduopeng
 * @date 2020/7/22
 * @time 11:14
 */
@RestController
@RequestMapping("/cleanRelation")
@Slf4j
public class CleanRelationController {

    @Resource
    private SystemProductMapper systemProductMapper;
    @Resource
    private EventTypeMapper eventTypeMapper;
    @Resource
    private DspatchLevelMapper dspatchLevelMapper;



    /**
     * 查询所有(产品线关系)
     */
    @GetMapping(value="/getSystemProductAllData")
    public List<SystemProduct> getSystemProductAllData() {
        return systemProductMapper.getAll();
    }
    /**
     * 新增数据(产品线关系)
     */
    @GetMapping(value="/setSystemProductNewData")
    public void setSystemProductNewData(@RequestParam() String systemClassificationLevel2,String systemClassificationLevel3,String productLine,String productTag) {
        systemProductMapper.setNewData(systemClassificationLevel2, systemClassificationLevel3, productLine, productTag);
    }
    /**
     * 更新数据(产品线关系)
     */
    @GetMapping(value="/updateSystemProductData")
    public void updateSystemProductData(@RequestParam() String systemClassificationLevel2,String systemClassificationLevel3,String productLine,String productTag,String id) {
        systemProductMapper.updateData(systemClassificationLevel2, systemClassificationLevel3, productLine, productTag, id);
    }
    /**
     * 删除数据(产品线关系)
     */
    @GetMapping(value="/deleteSystemProductData")
    public void deleteSystemProductData(@RequestParam() String id) {
        systemProductMapper.deleteData(id);
    }

    /**
     * 查询所有(事件分类关系)
     */
    @GetMapping(value="/getEventTypeAllData")
    public List<EventType> getEventTypeAllData() {
        return eventTypeMapper.getAll();
    }
    /**
     * 新增数据(事件分类关系)
     */
    @GetMapping(value="/setEventTypeNewData")
    public void setEventTypeNewData(@RequestParam() String eventClassificationLevel2,String eventClassificationLevel3,String masterEventType,String sonEventType) {
        eventTypeMapper.setNewData(eventClassificationLevel2, eventClassificationLevel3, masterEventType, sonEventType);
    }
    /**
     * 更新数据(事件分类关系)
     */
    @GetMapping(value="/updateEventTypeData")
    public void updateEventTypeData(@RequestParam() String eventClassificationLevel2,String eventClassificationLevel3,String masterEventType,String sonEventType,String id) {
        eventTypeMapper.updateData(eventClassificationLevel2, eventClassificationLevel3, masterEventType, sonEventType, id);
    }
    /**
     * 删除数据(事件分类关系)
     */
    @GetMapping(value="/deleteEventTypeData")
    public void deleteEventTypeData(@RequestParam() String id) {
        eventTypeMapper.deleteData(id);
    }

    /**
     * 查询所有(处理级别)
     */
    @GetMapping(value="/getDspatchLevelAllData")
    public List<DspatchLevel> getDspatchLevelAllData() {
        return dspatchLevelMapper.getAll();
    }
    /**
     * 新增数据(处理级别)
     */
    @GetMapping(value="/setDspatchLevelNewData")
    public void setDspatchLevelNewData(@RequestParam() String assignedLevel3Department,String assignedPerson,String level) {
        dspatchLevelMapper.setNewData(assignedLevel3Department, assignedPerson, level);
    }
    /**
     * 更新数据(处理级别)
     */
    @GetMapping(value="/updateDspatchLevelData")
    public void updateDspatchLevelData(@RequestParam() String assignedLevel3Department,String assignedPerson,String level,String id) {
        dspatchLevelMapper.updateData(assignedLevel3Department, assignedPerson, level, id);
    }
    /**
     * 删除数据(处理级别)
     */
    @GetMapping(value="/deleteDspatchLevelData")
    public void deleteDspatchLevelData(@RequestParam() String id) {
        dspatchLevelMapper.deleteData(id);
    }



}
