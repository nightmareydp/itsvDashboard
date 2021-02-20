package com.itsv.itsvdashboard.service.Impl;

import com.itsv.itsvdashboard.dao.*;
import com.itsv.itsvdashboard.domain.*;
import com.itsv.itsvdashboard.service.NullTableService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * @Author yuduopeng
 * @date 2021/2/1
 * @time 18:09
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class NullTableServiceImpl implements NullTableService {

    private final SystemProductNullMapper systemProductNullMapper;
    private final DspatchLevelNullMapper dspatchLevelNullMapper;
    private final EventTypeNullMapper eventTypeNullMapper;
    private final ReportSourceNullMapper reportSourceNullMapper;
    private final SlaNullMapper slaNullMapper;


    /**
     *  向无对应关系表插入数据
     * @param map 数据来源
     * @throws NoSuchAlgorithmException
     */
    @Override
    public void setNullData(Map<String, List> map) throws NoSuchAlgorithmException {

        //产品线list
        List<SystemProduct> systemProductList = map.get("systemProductList");
        //处理级别list
        List<DspatchLevel> dspatchLeveltList = map.get("dspatchLevelList");
        //事件类型list
        List<EventType> eventTypeList = map.get("eventTypeList");
        //报告来源list
        List<ReportSource> reportSourceList = map.get("reportSourceList");
        //处理时长list
        List<Sla> slaList = map.get("slaList");

        //处理--产品线
        for (SystemProduct systemProduct: systemProductList) {
            String id = md5(systemProduct.getSystemClassificationLevel2() + systemProduct.getSystemClassificationLevel3());
            systemProductNullMapper.setNewData(id,systemProduct.getSystemClassificationLevel2(),systemProduct.getSystemClassificationLevel3());
        }
        //处理--处理级别
        for(DspatchLevel dspatchLevel:dspatchLeveltList){
            String id = md5(dspatchLevel.getAssignedLevel3Department() + dspatchLevel.getAssignedPerson());
            dspatchLevelNullMapper.setNewData(id,dspatchLevel.getAssignedLevel3Department(),dspatchLevel.getAssignedPerson());
        }
        //处理--事件类型
        for(EventType eventType:eventTypeList){
            String id = md5(eventType.getEventClassificationLevel2() + eventType.getEventClassificationLevel3());
            eventTypeNullMapper.setNewData(id,eventType.getEventClassificationLevel2(),eventType.getEventClassificationLevel3());
        }
        //处理--报告来源
        for(ReportSource reportSource:reportSourceList){
            String id = md5(reportSource.getReportSource());
            reportSourceNullMapper.setNewData(id, reportSource.getReportSource());
        }
        //处理--处理时长
        for(Sla sla:slaList){
            String id = md5(sla.getLevel() + sla.getPriorityLevel());
            slaNullMapper.setNewData(id, sla.getLevel(), sla.getPriorityLevel());
        }

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
