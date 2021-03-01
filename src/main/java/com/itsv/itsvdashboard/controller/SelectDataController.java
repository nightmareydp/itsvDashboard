package com.itsv.itsvdashboard.controller;

import com.itsv.itsvdashboard.dto.TwoNumDto;
import com.itsv.itsvdashboard.service.IntermediateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author yuduopeng
 * @date 2020/7/13
 * @time 0:39
 */
@RestController
@RequestMapping("/get")
@Slf4j
public class SelectDataController {


    @Resource
    private IntermediateService intermediateService;


    /**
     * 查询总量趋势
     * @return List<TwoNumDto>
     */
    @GetMapping(value="/getTotalTrend")
    public List<TwoNumDto> getTotalTrend() {
        return intermediateService.getTotalTrend();
    }

    /**
     * 查询满意度
     * @return List<TwoNumDto>
     */
    @GetMapping(value="/getSatisfaction")
    public List<TwoNumDto> getSatisfaction() {
        return intermediateService.getSatisfaction();
    }

    /**
     * 获取SLA
     * @return List<TwoNumDto>
     */
    @GetMapping(value="/getSla")
    public List<TwoNumDto> getSla() {
        return intermediateService.getSla();
    }

    /**
     * 获取各产品线SLA
     * @return List<TwoNumDto>
     */
    @GetMapping(value="/getEveSla")
    public List<TwoNumDto> getEveSla() {
        return intermediateService.getEveSla();
    }


    /**
     * 获取指定产品线top3标签的事件分类
     * @param productLine  产品线
     * @return Map<String,List>
     */
    @GetMapping(value="/getProductEventType")
    public Map<String,List> getProductEventType(String productLine) {
        return intermediateService.getProductEventType(productLine);
    }

}
