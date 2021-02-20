package com.itsv.itsvdashboard.controller;

import com.itsv.itsvdashboard.service.IntermediateService;
import lombok.extern.slf4j.Slf4j;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 21:24
 */
@RestController
@RequestMapping("/clean")
public class IntermediateController {

    @Resource
    private IntermediateService intermediateService;


    /**
     * 清洗全量数据
     */
    @GetMapping(value="/cleanAllData")
    public Map<String, List> cleanAllData() throws NoSuchAlgorithmException {
        return intermediateService.CleanAllData();
    }

    /**
     * 手动洗数
     * 清洗当前时间至上一次洗数的数据
     */
    @GetMapping(value="/cleanToLastTimeData")
    public Map<String, List> cleanToLastTimeData() throws NoSuchAlgorithmException {
        return intermediateService.CleanToLastTimeData();
    }

    /**
     * 清洗自定义时间的数据
     */
    @GetMapping(value="/cleanSetupTimeData")
    public Map<String, List> cleanSetupTimeData(@RequestParam() String start, String end) throws ParseException, NoSuchAlgorithmException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date stateTime = null;
        Date endTime = null;
        try {
            stateTime = simpleDateFormat.parse(start);
            endTime = simpleDateFormat.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return intermediateService.CleanSetupTimeData(stateTime,endTime);
    }
}
