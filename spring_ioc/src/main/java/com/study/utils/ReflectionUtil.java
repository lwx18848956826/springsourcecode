package com.study.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 10:51
 */
@Slf4j
public class ReflectionUtil {

    /**
     * 创建实例
     *
     * @param clazz
     * @return
     */
    public static Object newInstance(Class<?> clazz) {
        Object instance;
        try {
            instance = clazz.newInstance();
        } catch (Exception e) {
            log.error("new Instance failed", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 创建实例（根据类名）
     *
     * @param className
     * @return
     */
    public static Object newInstance(String className) {
        Class<?> aClass = ClassUtil.loadClass(className);
        return newInstance(aClass);
    }

    /**
     * 调用方法
     * @param obj
     * @param method
     * @param args
     * @return
     */
    public static Object invokeMethod(Object obj, Method method, Object... args) {

        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (Exception e) {
            log.error("invoke method failure",e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void setField(Object obj, Field field,Object value){
        try{
            field.setAccessible(true);
            field.set(obj,value);
        }catch (Exception e){
            log.error("set Field failure",e);
            throw new RuntimeException(e);
        }
    }

}
