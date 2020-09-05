package com.itsv.itsvdashboard.service.Impl;

import com.itsv.itsvdashboard.dao.CleanTaskHistoryMapper;
import com.itsv.itsvdashboard.dao.IntermediateMapper;
import com.itsv.itsvdashboard.dao.ItsvWeekTwentyThreeMapper;
import com.itsv.itsvdashboard.domain.CleanTaskHistory;
import com.itsv.itsvdashboard.dto.CleanDataDto;
import com.itsv.itsvdashboard.dto.TwoNumDto;
import com.itsv.itsvdashboard.service.CleanDataService;
import com.itsv.itsvdashboard.service.IntermediateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 18:25
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
@Slf4j
public class IntermediateServiceImpl implements IntermediateService {

    private final ItsvWeekTwentyThreeMapper itsvWeekTwentyThreeMapper;

    private final IntermediateMapper intermediateMapper;

    private final CleanTaskHistoryMapper cleanTaskHistoryMapper;

    private final CleanDataService cleanDataService;



    /**
     * 获取全量数据
     * @return CleanDataDto
     */
    @Override
    public List<CleanDataDto> getAllData() {
        return itsvWeekTwentyThreeMapper.getNeedCol();
    }
    /**
     * 清洗全量数据
     * @return Map<String,List>
     */
    @Override
    public Map<String,List> CleanAllData() {

        //创建临时map接收入参
        Map<String,List> tempMap = new HashMap<>(16);
        tempMap = cleanDataService.cleanAllData(this.getAllData());
        //插入数据（清洗后数据数据.中间表list）
        intermediateMapper.setIntermediate(tempMap.get("intermediate"));
        //记录操作记录
        CleanTaskHistory cleanTaskHistory = new CleanTaskHistory();
//        cleanTaskHistory.setId(UUID.randomUUID().toString());
        cleanTaskHistory.setCleanType("全量清洗数据");
        cleanTaskHistory.setDate(new Date());
        cleanTaskHistory.setOperator("于铎朋");
        cleanTaskHistory.setOperatorErp("yuduopeng");
        cleanTaskHistoryMapper.setCleanTask(cleanTaskHistory);
        //移除中间表数据，留下无对应关系list
        tempMap.remove("intermediate");
        return tempMap;
    }

    /**
     * 获取当前时间至上一次洗数的数据
     * @return CleanDataDto
     */
    @Override
    public List<CleanDataDto> getNeedColToLastTime() {
        return itsvWeekTwentyThreeMapper.getNeedColToLastTime(cleanTaskHistoryMapper.getLastCleanTime(),new Date());
    }
    /**
     * 清洗当前时间至上一次洗数的数据
     * @return CleanDataDto
     */
    @Override
    public Map<String,List> CleanToLastTimeData() {

        //创建临时map接收入参
        Map<String,List> tempMap = new HashMap<>(16);
        tempMap = cleanDataService.cleanAllData(this.getNeedColToLastTime());
        //插入数据（清洗数据（获取当前时间至上一次洗数的数据））
        intermediateMapper.setIntermediate(tempMap.get("intermediate"));
        //记录操作记录
        CleanTaskHistory cleanTaskHistory = new CleanTaskHistory();
//        cleanTaskHistory.setId(UUID.randomUUID().toString());
        cleanTaskHistory.setCleanType("手动清洗数据");
        cleanTaskHistory.setDate(new Date());
        cleanTaskHistory.setOperator("于铎朋");
        cleanTaskHistory.setOperatorErp("yuduopeng");
        cleanTaskHistoryMapper.setCleanTask(cleanTaskHistory);
        //移除中间表数据，留下无对应关系list
        tempMap.remove("intermediate");
        return tempMap;
    }

    /**
     * 获取自定义时间的数据
     * @return CleanDataDto
     */
    @Override
    public List<CleanDataDto> getNeedColSetupTime(Date stateTime,Date endTime) {
        return itsvWeekTwentyThreeMapper.getNeedColSetupTime(stateTime,endTime);
    }
    /**
     * 清洗自定义时间的数据
     * @return CleanDataDto
     */
    @Override
    public Map<String,List> CleanSetupTimeData(Date stateTime,Date endTime) {

        //创建临时map接收入参
        Map<String,List> tempMap = new HashMap<>(16);
        tempMap = cleanDataService.cleanAllData(this.getNeedColSetupTime(stateTime,endTime));
        //插入数据（清洗数据（获取自定义时间的数据））
        intermediateMapper.setIntermediate(tempMap.get("intermediate"));
        //记录操作记录
        CleanTaskHistory cleanTaskHistory = new CleanTaskHistory();
//        cleanTaskHistory.setId(UUID.randomUUID().toString());
        cleanTaskHistory.setCleanType("自定义清洗数据");
        cleanTaskHistory.setDate(new Date());
        cleanTaskHistory.setOperator("于铎朋");
        cleanTaskHistory.setOperatorErp("yuduopeng");
        cleanTaskHistoryMapper.setCleanTask(cleanTaskHistory);
        //移除中间表数据，留下无对应关系list
        tempMap.remove("intermediate");
        return tempMap;
    }

    /**
     * 查询总量趋势
     * @return List<TwoNumDto>
     */
    @Override
    public List<TwoNumDto> getTotalTrend() {
        return intermediateMapper.getTotalTrend();
    }

    /**
     * 查询满意度
     * @return List<TwoNumDto>
     */
    @Override
    public List<TwoNumDto> getSatisfaction() {
        return intermediateMapper.getSatisfaction();
    }

    /**
     * 获取SLA
     * @return List<TwoNumDto>
     */
    @Override
    public List<TwoNumDto> getSla() {
        return intermediateMapper.getSla();
    }


}
