package com.spring.mvc.utils;

import com.spring.mvc.param.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 14:40
 */
public class RequestHelper {

    /**
     * 获取请求参数
     */
    public static Param createParam(HttpServletRequest request){
        Map<String,Object> paramMap = new HashMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        if(! paramNames.hasMoreElements()){
            return null;
        }
        // get和Post 参数都能获取到
        while (paramNames.hasMoreElements()){
            String fieldName = paramNames.nextElement();
            String fieldValue = request.getParameter(fieldName);
            paramMap.put(fieldName,fieldValue);
        }
        return new Param(paramMap);
    }
}
