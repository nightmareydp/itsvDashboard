package com.itsv.itsvdashboard.service.Impl;

import com.itsv.itsvdashboard.dao.CleanTaskHistoryMapper;
import com.itsv.itsvdashboard.dao.IntermediateMapper;
import com.itsv.itsvdashboard.dao.ItsvWeekTwentyThreeMapper;
import com.itsv.itsvdashboard.domain.CleanTaskHistory;
import com.itsv.itsvdashboard.dto.CleanDataDto;
import com.itsv.itsvdashboard.dto.TwoNumDto;
import com.itsv.itsvdashboard.service.CleanDataService;
import com.itsv.itsvdashboard.service.IntermediateService;
import com.itsv.itsvdashboard.service.NullTableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 18:25
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class IntermediateServiceImpl implements IntermediateService {

    private Logger log = Logger.getLogger(this.getClass());

    private final ItsvWeekTwentyThreeMapper itsvWeekTwentyThreeMapper;

    private final IntermediateMapper intermediateMapper;

    private final CleanTaskHistoryMapper cleanTaskHistoryMapper;

    private final CleanDataService cleanDataService;

    private final NullTableService nullTableService;



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
    public Map<String,List> CleanAllData() throws NoSuchAlgorithmException {

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
        //将无对应关系数据入表
        nullTableService.setNullData(tempMap);
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
    public Map<String,List> CleanToLastTimeData() throws NoSuchAlgorithmException {

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
        //将无对应关系数据入表
        nullTableService.setNullData(tempMap);
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
    public Map<String,List> CleanSetupTimeData(Date stateTime,Date endTime) throws NoSuchAlgorithmException {

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
        //将无对应关系数据入表
        nullTableService.setNullData(tempMap);
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

    /**
     * 获取各产品线SLA
     * @return
     */
    @Override
    public List<TwoNumDto> getEveSla() {
        List<TwoNumDto> allList = intermediateMapper.getEveryPSla();
        List<TwoNumDto> okList = intermediateMapper.getEveryPOkSla();
        ArrayList resultList = new ArrayList();
        for (int i =0;i<okList.size();i++){
            TwoNumDto t = new TwoNumDto();
            int all = allList.get(i).getNum();
            int ok = okList.get(i).getNum();
            int n = (ok*1000/all);
            t.setName(okList.get(i).getName());
            t.setNum(n);
            resultList.add(t);
        }
        return resultList;
    }

    @Override
    public Map<String, List> getProductEventType(String productLine) {
        //创建最终结果map与List
        List<String> nameList = new ArrayList<>();
        //咨询、建议
        List<Integer> askList = new ArrayList<>();
        //日常维护
        List<Integer> sosoList = new ArrayList<>();
        //系统问题
        List<Integer> problemList = new ArrayList<>();
        Map resultMap = new HashMap<String, List>();
        //获取TOP3产品标签
        List<String> lineList = intermediateMapper.getTopProductTag(productLine);
        //遍历list，过去事件分类
        for (String s:lineList) {
            nameList.add(s);
            //获取指定产品标签的事件分类
            List<TwoNumDto> tempList = intermediateMapper.getEventType(s);
            switch (tempList.size()){
                case 3 :
                    problemList.add(tempList.get(0).getNum());
                    sosoList.add(tempList.get(1).getNum());
                    askList.add(tempList.get(2).getNum());
                    break;
                case 2 :
                    if("日常维护".equals(tempList.get(0).getName())){
                        problemList.add(0);
                        sosoList.add(tempList.get(0).getNum());
                        askList.add(tempList.get(1).getNum());
                        break;
                    }else if("日常维护".equals(tempList.get(1).getName())){
                        problemList.add(tempList.get(0).getNum());
                        sosoList.add(tempList.get(1).getNum());
                        askList.add(0);
                        break;
                    }else {
                        problemList.add(tempList.get(0).getNum());
                        sosoList.add(0);
                        askList.add(tempList.get(1).getNum());
                        break;
                    }
                case 1 :
                    switch (tempList.get(0).getName()){
                        case "系统问题" :
                            problemList.add(tempList.get(0).getNum());
                            sosoList.add(0);
                            askList.add(0);
                            break;
                        case "日常维护" :
                            problemList.add(0);
                            sosoList.add(tempList.get(0).getNum());
                            askList.add(0);
                            break;
                        case "咨询、建议" :
                            problemList.add(0);
                            sosoList.add(0);
                            askList.add(tempList.get(0).getNum());
                            break;
                    }
                    break;
            }
        }

        //合并数据
        resultMap.put("nameList",nameList);
        resultMap.put("problemList",problemList);
        resultMap.put("sosoList",sosoList);
        resultMap.put("askList",askList);

        return resultMap;
    }
}


