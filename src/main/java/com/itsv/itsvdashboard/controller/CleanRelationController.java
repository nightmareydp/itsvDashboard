package com.itsv.itsvdashboard.controller;

import com.itsv.itsvdashboard.dao.DspatchLevelMapper;
import com.itsv.itsvdashboard.dao.SystemProductMapper;
import com.itsv.itsvdashboard.domain.DspatchLevel;
import com.itsv.itsvdashboard.domain.SystemProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yuduopeng
 * @date 2020/7/22
 * @time 11:14
 */
@RestController
@RequestMapping("/cleanRelation")
@Slf4j
public class CleanRelationController {

    @Resource
    private SystemProductMapper systemProductMapper;
    @Resource
    private DspatchLevelMapper dspatchLevelMapper;


    /**
     * 查询所有(产品线关系)
     */
    @GetMapping(value="/getSystemProductAllData")
    public List<SystemProduct> getSystemProductAllData() {
        return systemProductMapper.getAll();
    }

    /**
     * 查询所有(产品线关系)
     */
    @GetMapping(value="/getDspatchLevelAllData")
    public List<DspatchLevel> getDspatchLevelAllData() {
        return dspatchLevelMapper.getAll();
    }

}
