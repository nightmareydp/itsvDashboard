package com.itsv.itsvdashboard.controller;

import com.itsv.itsvdashboard.service.IntermediateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 21:24
 */
@RestController
@RequestMapping("/clean")
@Slf4j
public class IntermediateController {

    @Resource
    private IntermediateService intermediateService;


    /**
     * 清洗全量数据
     */
    @GetMapping(value="/cleanAllData")
    public void cleanAllData() {
        intermediateService.CleanAllData();
    }

    /**
     * 手动洗数
     * 清洗当前时间至上一次洗数的数据
     */
    @GetMapping(value="/cleanToLastTimeData")
    public void cleanToLastTimeData() {
        intermediateService.CleanToLastTimeData();
    }

    /**
     * 清洗自定义时间的数据
     */
    @GetMapping(value="/cleanSetupTimeData")
    public void cleanSetupTimeData(@RequestParam() String start, String end) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date stateTime = null;
        Date endTime = null;
        try {
            stateTime = simpleDateFormat.parse(start);
            endTime = simpleDateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        intermediateService.CleanSetupTimeData(stateTime,endTime);
    }
}
