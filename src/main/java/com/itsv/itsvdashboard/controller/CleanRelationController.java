package com.itsv.itsvdashboard.controller;

import com.itsv.itsvdashboard.dao.*;
import com.itsv.itsvdashboard.domain.*;
import com.itsv.itsvdashboard.dto.DayDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Resource
    private ReportSourceMapper reportSourceMapper;
    @Resource
    private SlaMapper slaMapper;
    @Resource
    private DayMapper dayMapper;


    //---------产品线关系---------
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

    //---------事件分类关系---------
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

    //---------处理级别---------
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

    //---------处理标准时长---------
     /**
     * 查询所有(处理标准时长)
     */
    @GetMapping(value="/getSlaAllData")
    public List<Sla> getSlaAllData() {
        return slaMapper.getAll();
    }
    /**
     * 新增数据(处理标准时长)
     */
    @GetMapping(value="/setSlaNewData")
    public void setSlaNewData(@RequestParam() String level,String priorityLevel,String masterSla,String sonSla) {
        slaMapper.setNewData(level, priorityLevel, masterSla ,sonSla);
    }
    /**
     * 更新数据(处理标准时长)
     */
    @GetMapping(value="/updateSlaData")
    public void updateSlaData(@RequestParam() String level,String priorityLevel,String masterSla,String sonSla,String id) {
        slaMapper.updateData(level, priorityLevel, masterSla ,sonSla, id);
    }
    /**
     * 删除数据(处理标准时长)
     */
    @GetMapping(value="/deleteSlaData")
    public void deleteSlaData(@RequestParam() String id) {
        slaMapper.deleteData(id);
    }

    //---------报告来源---------
    /**
     * 查询所有(报告来源)
     */
    @GetMapping(value="/getReportSourceAllData")
    public List<ReportSource> getReportSourceAllData() {
        return reportSourceMapper.getAll();
    }
    /**
     * 新增数据(报告来源)
     */
    @GetMapping(value="/setReportSourceNewData")
    public void setReportSourceNewData(@RequestParam() String reportSource,String newSource) {
        reportSourceMapper.setNewData(reportSource, newSource);
    }
    /**
     * 更新数据(报告来源)
     */
    @GetMapping(value="/updateReportSourceData")
    public void updateReportSourceData(@RequestParam() String reportSource,String newSource,String id) {
        reportSourceMapper.updateData(reportSource, newSource, id);
    }
    /**
     * 删除数据(报告来源)
     */
    @GetMapping(value="/deleteReportSourceData")
    public void deleteReportSourceData(@RequestParam() String id) {
        reportSourceMapper.deleteData(id);
    }

    //---------日历---------
    /**
     * 查询所有(日历)
     */
    @GetMapping(value="/getDayAllData")
    public List<DayDto> getDayAllData() {
        return dayMapper.getAll();
    }
    /**
     * 新增数据(日历)
     */
    @GetMapping(value="/setDayNewData")
    public void setDayNewData(@RequestParam() String date,String dateType,String week,String defaultWeek,String operationWeek) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTemp = null;
        try {
            dateTemp = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dayMapper.setNewData(dateTemp, dateType, week, defaultWeek, operationWeek);
    }
    /**
     * 更新数据(日历)
     */
    @GetMapping(value="/updateDayData")
    public void updateDayData(@RequestParam() String date, String dateType, String week, String defaultWeek, String operationWeek, String id) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTemp = null;
        try {
            dateTemp = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dayMapper.updateData(dateTemp, dateType, week, defaultWeek, operationWeek, id);
    }
    /**
     * 删除数据(日历)
     */
    @GetMapping(value="/deleteDayData")
    public void deleteDayData(@RequestParam() String id) {
        dayMapper.deleteData(id);
    }


}
