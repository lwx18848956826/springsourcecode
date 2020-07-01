package com.spring.mvc.param;

import org.apache.commons.collections4.MapUtils;

import java.util.Map;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 14:34
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public boolean isEmpty(){
        return MapUtils.isEmpty(paramMap);
    }
}
