package com.itsv.itsvdashboard.service.Impl;

import com.itsv.itsvdashboard.dao.ItsvWeekTwentyThreeMapper;
import com.itsv.itsvdashboard.dto.ThreeNumDto;
import com.itsv.itsvdashboard.dto.SlaDto;
import com.itsv.itsvdashboard.dto.TwoNumDto;
import com.itsv.itsvdashboard.service.ItsvWeekTwentyThreeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author yuduopeng
 * @date 2020/6/6
 * @time 23:34
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
@Slf4j
public class ItsvWeekTwentyThreeServiceImpl implements ItsvWeekTwentyThreeService {

    private final ItsvWeekTwentyThreeMapper itsvWeekTwentyThreeMapper;




}
