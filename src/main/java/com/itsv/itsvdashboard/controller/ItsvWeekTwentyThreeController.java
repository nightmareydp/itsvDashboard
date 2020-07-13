package com.itsv.itsvdashboard.controller;

import com.itsv.itsvdashboard.dto.ThreeNumDto;
import com.itsv.itsvdashboard.dto.TwoNumDto;

import com.itsv.itsvdashboard.service.ItsvWeekTwentyThreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yuduopeng
 * @date 2020/6/6
 * @time 23:20
 */

@RestController
@RequestMapping("/itsv")
@Slf4j
public class ItsvWeekTwentyThreeController {

    @Resource
    private ItsvWeekTwentyThreeService itsvWeekTwentyThreeService;



    /**
     * 查询每人处理单量
     * @return list
     */
    @GetMapping(value="/getWorkload")
    public List<TwoNumDto> getWorkload() {
        return itsvWeekTwentyThreeService.getWorkload();
    }

    /**
     * 查询系统单量TOP10
     * @return list
     */
    @GetMapping(value="/getSystemNum")
    public List<TwoNumDto> getSystemNum() {
        return itsvWeekTwentyThreeService.getSystemNum();
    }

    /**
     * 本周产品线事件单周占比
     * @return list
     */
    @GetMapping(value="/getProductLine")
    public List<ThreeNumDto> getProductLine() {
        return itsvWeekTwentyThreeService.getProductLine();
    }

    /**
     * 查询满意度
     * @return list
     */
    @GetMapping(value="/getSatisfaction")
    public List<TwoNumDto> getSatisfaction() {
        return itsvWeekTwentyThreeService.getSatisfaction();
    }


    /**
     * 查询SLA达标率
     * @return list
     */
    @GetMapping(value="/getSLA")
    public List<TwoNumDto> getSLA() {
        return itsvWeekTwentyThreeService.getSLA();
    }



}
