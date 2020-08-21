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






}
