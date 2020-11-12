package com.itsv.itsvdashboard.service.Impl;

import com.itsv.itsvdashboard.dao.*;
import com.itsv.itsvdashboard.domain.*;
import com.itsv.itsvdashboard.dto.CleanDataDto;
import com.itsv.itsvdashboard.service.CleanDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author yuduopeng
 * @date 2020/7/11
 * @time 18:13
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
@Slf4j
public class CleanDataServiceImpl implements CleanDataService {

    private final DspatchLevelMapper dspatchLevelMapper;

    private final SlaMapper slaMapper;

    private final SystemProductMapper systemProductMapper;

    private final ReportSourceMapper reportSourceMapper;

    private final EventTypeMapper eventTypeMapper;

    private final DayMapper dayMapper;



    /**
     * 核心程序
     * 清洗数据
     * @return List<CleanDataDto>
     */
    @Override
    public Map<String,List> cleanAllData(List<CleanDataDto> getNeedColList) {

        //-----创建各个对应关系list，无对应关系加入列表，返回前端提示-----
        //创建总map
        Map<String,List> intermediateMap = new HashMap<>(16);
        //产品线list
        List<SystemProduct> systemProductList = new ArrayList<>();
        //分派级别list
        List<DspatchLevel> dspatchLevelList = new ArrayList<>();
        //标准处理时长list
        List<Sla> slaList = new ArrayList<>();
        //报告来源list
        List<ReportSource> reportSourceList = new ArrayList<>();
        //事件类型list
        List<EventType> eventTypeList = new ArrayList<>();


        //遍历列表，执行系数逻辑
        for (CleanDataDto cleanDataDto:getNeedColList) {

            //计算满意度
            Integer attitudeScoreTemp = cleanDataDto.getAttitudeScore() == null ? 0 : cleanDataDto.getAttitudeScore();
            Integer timelinessScoreTemp = cleanDataDto.getTimelinessScore() == null ? 0 : cleanDataDto.getTimelinessScore();
            if (attitudeScoreTemp * timelinessScoreTemp == 25){
                cleanDataDto.setSatisfied("满意");
            }else if(attitudeScoreTemp * timelinessScoreTemp < 16){
                cleanDataDto.setSatisfied("不满意");
            }else{
                cleanDataDto.setSatisfied("一般");
            }

            //---------计算分派级别(默认L3)---------
            String levelTemp = dspatchLevelMapper.getLevel(cleanDataDto.getAssignedLevel3Department(),cleanDataDto.getAssignedPerson());
            String level = levelTemp == null ? "L3" : levelTemp;
            //如果没有对应关系则加入列表
            if (levelTemp == null) {
                dspatchLevelList.add(new DspatchLevel(null,cleanDataDto.getAssignedLevel3Department(),cleanDataDto.getAssignedPerson(),null));
            }
            //赋值分派级别
            cleanDataDto.setLevel(level);

            //---------计算产品线、产品标签(默认其他)---------
            String productLineTemp = systemProductMapper.getProductLine(cleanDataDto.getSystemClassificationLevel2(),cleanDataDto.getSystemClassificationLevel3());
            String productTagTemp  = systemProductMapper.getProductTag(cleanDataDto.getSystemClassificationLevel2(),cleanDataDto.getSystemClassificationLevel3());
            String productLine = productLineTemp == null ? "其他" : productLineTemp;
            String productTag = productTagTemp == null ? "其他" : productTagTemp;
            //如果没有对应关系则加入列表
            if (productLineTemp == null){
                systemProductList.add(new SystemProduct(null,cleanDataDto.getSystemClassificationLevel2(),cleanDataDto.getSystemClassificationLevel3(),null,null));
            }
            //赋值产品线、产品标签
            cleanDataDto.setProductLine(productLine);
            cleanDataDto.setProductTag(productTag);

            //---------计算标准处理时长(默认72)---------
            Integer sonSlaTemp = Integer.valueOf(slaMapper.getSonSla(level,cleanDataDto.getPriority()));
            Integer sonSla = sonSlaTemp == null ? 72 : sonSlaTemp;
            //如果没有对应关系则加入列表
            if (sonSlaTemp == null){
                slaList.add(new Sla(null,level,cleanDataDto.getPriority(),null,null));
            }
            //赋值标准处理时长
            cleanDataDto.setSSla(sonSla);

            //---------计算报告来源(默认自助)---------
            String newSourceTemp = reportSourceMapper.getReportSource(cleanDataDto.getReportSource());
            String newSource = newSourceTemp == null ? "自助" : newSourceTemp;
            //如果没有对应关系则加入列表
            if (newSourceTemp == null){
                reportSourceList.add(new ReportSource(null,cleanDataDto.getReportSource(),null));
            }
            //赋值报告来源
            cleanDataDto.setNewSource(newSource);

            //---------计算主事件类型、子事件类型(默认其他)---------
            String masterEventTypeTemp = eventTypeMapper.getMasterEventType(cleanDataDto.getEventClassificationLevel2(),cleanDataDto.getEventClassificationLevel3());
            String sonEventTypeTemp  = eventTypeMapper.getSonEventType(cleanDataDto.getEventClassificationLevel2(),cleanDataDto.getEventClassificationLevel3());
            String masterEventType = masterEventTypeTemp == null ? "咨询、建议" : masterEventTypeTemp;
            String sonEventType = sonEventTypeTemp == null ? "咨询" : sonEventTypeTemp;
            //如果没有对应关系则加入列表
            if (masterEventTypeTemp == null){
                eventTypeList.add(new EventType(null,cleanDataDto.getEventClassificationLevel2(),cleanDataDto.getEventClassificationLevel3(),null,null));
            }
            //赋值主事件类型、子事件类型
            cleanDataDto.setMasterEventType(masterEventType);
            cleanDataDto.setSonEventType(sonEventType);

            /*计算日期类型
             *计算当日9点
             *计算下一个工作日(9点)
             */
            String dateType = dayMapper.getDateType(cleanDataDto.getSubmissionDate());
            Date todayNine = dayMapper.getTodayNine(cleanDataDto.getSubmissionDate());
            Date nextWorkDay = dayMapper.getNextWorkDay(cleanDataDto.getSubmissionDate());
            //赋值日期类型、当日9点、下一个工作日(9点)
            cleanDataDto.setDateType(dateType);
            cleanDataDto.setTodayNine(todayNine);
            cleanDataDto.setNextWorkDay(nextWorkDay);

            //---------计算提交时间new---------
            if ( "工作日".equals(dateType)){
                if (cleanDataDto.getSubmissionHours() >= 9 && cleanDataDto.getSubmissionHours() < 18){
                    //默认提交时间
                    cleanDataDto.setSubmissionTimeNew(cleanDataDto.getSubmissionTime());
                }else if (cleanDataDto.getSubmissionHours() < 9){
                    //当日9点
                    cleanDataDto.setSubmissionTimeNew(todayNine);
                }else {
                    //获取下一个工作日9点
                    cleanDataDto.setSubmissionTimeNew(nextWorkDay);
                }
            }else {
                //获取下一个工作日9点
                cleanDataDto.setSubmissionTimeNew(nextWorkDay);
            }

            //---------计算是否超时---------
            //---------获取提交时间new---------
            Date submissionTimeNew = cleanDataDto.getSubmissionTimeNew();
            //获取解决时间(默认当前时间)
            Date resolutionTime = cleanDataDto.getResolutionTime() == null ? new Date() : cleanDataDto.getResolutionTime();
            //计算非工作日天数
            Integer notWorkDays = dayMapper.getNotWorkDays(submissionTimeNew,resolutionTime);
            //结算解决时长(转化为小时计算(处理时长-节假日时间)
            Double processingTimeTemp = Double.valueOf((resolutionTime.getTime() - submissionTimeNew.getTime())) / (1000 * 60 * 60);
            Double processingTime = processingTimeTemp - notWorkDays*24;
            cleanDataDto.setProcessingTime(processingTime);
            if (processingTime <= sonSla ){
                cleanDataDto.setIsOk("未超时");
            }else {
                cleanDataDto.setIsOk("超时");
            }

        }

        //将各个list放入map中
        intermediateMap.put("intermediate",getNeedColList);
        intermediateMap.put("systemProductList",systemProductList);
        intermediateMap.put("dspatchLevelList",dspatchLevelList);
        intermediateMap.put("slaList",slaList);
        intermediateMap.put("reportSourceList",reportSourceList);
        intermediateMap.put("eventTypeList",eventTypeList);
        return intermediateMap;
    }
}
