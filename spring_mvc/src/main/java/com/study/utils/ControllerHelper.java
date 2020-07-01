package com.study.utils;



import com.study.handler.Handler;
import com.study.request.Request;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 11:39
 */
public class ControllerHelper {

    /**
     * 请求-处理器映射REQUEST_MAP
     */
    private static final Map<Request, Handler> REQUEST_HANDLER_MAP = new HashMap<>();

    static {

        // 遍历所有Controller
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();

    }
}
