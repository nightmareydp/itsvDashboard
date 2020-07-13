package com.itsv.itsvdashboard.controller;

import com.itsv.itsvdashboard.service.IntermediateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
        intermediateService.getCleanAllData();
    }
}
