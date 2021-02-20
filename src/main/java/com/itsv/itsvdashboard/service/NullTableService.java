package com.itsv.itsvdashboard.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * @Author yuduopeng
 * @date 2021/2/1
 * @time 18:09
 */
public interface NullTableService {

    /**
     * 向无对应关系表插入数据
     * @param map 无对应关系
     * @throws NoSuchAlgorithmException
     */
    void setNullData(Map<String, List> map) throws NoSuchAlgorithmException;
}
