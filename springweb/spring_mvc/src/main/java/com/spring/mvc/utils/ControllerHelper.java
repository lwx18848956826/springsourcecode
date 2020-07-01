package com.spring.mvc.utils;

import com.spring.mvc.handler.Handler;
import com.spring.mvc.request.Request;
import com.study.annotation.RequestMapping;
import com.study.utils.ClassHelper;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Method;
import java.util.*;

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
        if(CollectionUtils.isNotEmpty(controllerClassSet)){
            controllerClassSet.stream().forEach(clazz ->{
                // 通过反射获取方法
                Method[] methods = clazz.getDeclaredMethods();
                List<Method> methodList = Arrays.asList(methods);
                if(CollectionUtils.isNotEmpty(methodList)){
                    methodList.stream().filter(method -> method.isAnnotationPresent(RequestMapping.class)).forEach(method -> {
                        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                        // 获取URL信息
                        String requestPath = requestMapping.value();
                        // 获取方法名称
                        String requestMethod = requestMapping.method().name();
                        // 封装请求和处理器
                        Request request = new Request(requestMethod,requestPath);
                        Handler handler = new Handler(clazz,method);
                        REQUEST_HANDLER_MAP.put(request,handler);
                    });
                }
            });
        }
    }

    /**
     * 获取Handler
     */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return REQUEST_HANDLER_MAP.get(request);
    }

   /* public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(ClassHelper.class.getName());
        System.out.println(clazz);

    }*/
}
