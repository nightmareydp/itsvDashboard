package com.itsv.itsvdashboard.controller;

import com.itsv.itsvdashboard.dao.*;
import com.itsv.itsvdashboard.domain.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @Author yuduopeng
 * @date 2021/2/4
 * @time 18:31
 */
@RestController
@RequestMapping("/no")
public class NullTableController {

    @Resource
    private SystemProductNullMapper systemProductNullMapper;
    @Resource
    private DspatchLevelNullMapper dspatchLevelNullMapper;
    @Resource
    private SystemProductMapper systemProductMapper;
    @Resource
    private EventTypeMapper eventTypeMapper;
    @Resource
    private EventTypeNullMapper eventTypeNullMapper;
    @Resource
    private DspatchLevelMapper dspatchLevelMapper;
    @Resource
    private ReportSourceMapper reportSourceMapper;
    @Resource
    private ReportSourceNullMapper reportSourceNullMapper;
    @Resource
    private SlaMapper slaMapper;
    @Resource
    private SlaNullMapper slaNullMapper;


    //---------产品线关系---------
    /**
     * 查询所有无对应关系(产品线关系)
     * @return
     */
    @GetMapping(value="/getSystemProductAllData")
    public List<SystemProductNull> getAll(){
        return systemProductNullMapper.getAll();
    }
    /**
     * 新增数据无对应关系(产品线关系)
     */
    @GetMapping(value="/setSystemProductNewData")
    public void setSystemProductNewData(@RequestParam() String systemClassificationLevel2, String systemClassificationLevel3, String productLine, String productTag) throws NoSuchAlgorithmException {
        //新增数据
        systemProductMapper.setNewData(systemClassificationLevel2, systemClassificationLevel3, productLine, productTag);
        //计算id，删除无对应关系表数据
        String id = md5(systemClassificationLevel2 + systemClassificationLevel3);
        systemProductNullMapper.deleteData(id);
    }
    //---------处理级别---------
    /**
     * 查询所有无对应关系(处理级别)
     */
    @GetMapping(value="/getDspatchLevelAllData")
    public List<DspatchLevelNull> getDspatchLevelAllData() {
        return dspatchLevelNullMapper.getAll();
    }
    /**
     * 新增数据无对应关系(处理级别)
     */
    @GetMapping(value="/setDspatchLevelNewData")
    public void setDspatchLevelNewData(@RequestParam() String assignedLevel3Department,String assignedPerson,String level) throws NoSuchAlgorithmException {
        //新增数据
        dspatchLevelMapper.setNewData(assignedLevel3Department, assignedPerson, level);
        //计算id，删除无对应关系表数据
        String id = md5(assignedLevel3Department + assignedPerson);
        dspatchLevelNullMapper.deleteData(id);
    }
    //---------事件分类关系---------
    /**
     * 查询所有无对应关系(事件分类关系)
     */
    @GetMapping(value="/getEventTypeAllData")
    public List<EventTypeNull> getEventTypeAllData() {
        return eventTypeNullMapper.getAll();
    }
    /**
     * 新增数据无对应关系(事件分类关系)
     */
    @GetMapping(value="/setEventTypeNewData")
    public void setEventTypeNewData(@RequestParam() String eventClassificationLevel2,String eventClassificationLevel3,String masterEventType,String sonEventType) throws NoSuchAlgorithmException {
        //新增数据
        eventTypeMapper.setNewData(eventClassificationLevel2, eventClassificationLevel3, masterEventType, sonEventType);
        //计算id，删除无对应关系表数据
        String id = md5(eventClassificationLevel2 + eventClassificationLevel3);
        eventTypeNullMapper.deleteData(id);
    }
    //---------报告来源---------
    /**
     * 查询所有无对应关系(报告来源)
     */
    @GetMapping(value="/getReportSourceAllData")
    public List<ReportSourceNull> getReportSourceAllData() {
        return reportSourceNullMapper.getAll();
    }
    /**
     * 新增数据无对应关系(报告来源)
     */
    @GetMapping(value="/setReportSourceNewData")
    public void setReportSourceNewData(@RequestParam() String reportSource,String newSource) throws NoSuchAlgorithmException {
        //新增数据
        reportSourceMapper.setNewData(reportSource, newSource);
        //计算id，删除无对应关系表数据
        String id = md5(reportSource);
        reportSourceNullMapper.deleteData(id);
    }
    //---------处理时长---------
    /**
     * 查询所有无对应关系(处理标准时长)
     */
    @GetMapping(value="/getSlaAllData")
    public List<SlaNull> getSlaAllData() {
        return slaNullMapper.getAll();
    }
    /**
     * 新增数据无对应关系(处理标准时长)
     */
    @GetMapping(value="/setSlaNewData")
    public void setSlaNewData(@RequestParam() String level,String priorityLevel,String masterSla,String sonSla) throws NoSuchAlgorithmException {
        //新增数据
        slaMapper.setNewData(level, priorityLevel, masterSla ,sonSla);
        //计算id，删除无对应关系表数据
        String id = md5(level + priorityLevel);
        slaNullMapper.deleteData(id);
    }




    /**
     *
     * @param src
     * @return MD5加密
     * @throws NoSuchAlgorithmException
     */
    public static String md5(String src) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] output = md.digest(src.getBytes());
        //将加密结果output利用duBase64转换成字符串输zhi出
        String ret = Base64.encodeBase64String(output);
        return ret;
    }
}
