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


    /**
     * 查询每人处理单量
     * @return list
     */
    @Override
    public List<TwoNumDto> getWorkload() {
        return itsvWeekTwentyThreeMapper.getWorkload();
    }

    /**
     * 查询系统单量TOP10
     * @return list
     */
    @Override
    public List<TwoNumDto> getSystemNum() {
        return itsvWeekTwentyThreeMapper.getSystemNum();
    }

    /**
     * 本周产品线事件单周占比
     * @return list
     */
    @Override
    public List<ThreeNumDto> getProductLine() {
        return itsvWeekTwentyThreeMapper.getProductLine();
    }

    /**
     * 查询满意度
     * @return list
     */
    @Override
    public List<TwoNumDto> getSatisfaction() {
        return itsvWeekTwentyThreeMapper.getSatisfaction();
    }

    /**
     * 查询SLA达标率
     * @return list
     */
    @Override
    public List<TwoNumDto> getSLA() {
        //创建返回值list
        List<TwoNumDto> SLAlist = new ArrayList<>();
        //创建返回值对象：1达标，2未达标
        TwoNumDto w1 = new TwoNumDto();
        w1.setName("达标");
        TwoNumDto w2 = new TwoNumDto();
        w2.setName("未达标");
        //创建计数变量
        int ok = 0;
        int notOk = 0;
        //遍历list
        for (SlaDto sladto:itsvWeekTwentyThreeMapper.getSlaData()) {

            /*判断提交日期是否在工作时间
             * 1、判断是否在工作日
             * 2、判断是否在9-18点
             * 3、不是工作时间取下一个工作日9点
             */
            Date dd = sladto.getSubmissionDate();
            String ii = itsvWeekTwentyThreeMapper.isWorkDay(dd);
            int uu = sladto.getSubmissionHours();
            if ( ii != "工作日" || (ii == "工作日" && uu > 18)){
                //获取下一个工作日9点

                Date ddd = itsvWeekTwentyThreeMapper.getNextWorkDay(dd);
                sladto.setSubmissionTimeNew(ddd);
            }else {
                if (uu < 9){
                    //当日9点
                    sladto.setSubmissionTimeNew(sladto.getTodayNine());
                }else {
                    //9-18点
                    sladto.setSubmissionTimeNew(sladto.getSubmissionTime());
                }
            }

            //计算处理时长(小时)
            long diff = (sladto.getResolutionTime().getTime() - sladto.getSubmissionTimeNew().getTime())  / (1000 * 60 * 60);

            //获取此单的标准处理时长
            int standard = itsvWeekTwentyThreeMapper.getStandard(sladto.getId());

            //判断是否超时
            if (diff > standard){
                notOk++;
            }else {
                ok++;
            }
        }

        w1.setNum(ok);
        w2.setNum(notOk);
        SLAlist.add(w1);
        SLAlist.add(w2);
        return SLAlist;
    }

}
