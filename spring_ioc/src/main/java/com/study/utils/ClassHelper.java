package com.study.utils;

import com.study.annotation.Controller;
import com.study.annotation.Service;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 10:20
 */
public final class ClassHelper {


    /**
     * 定义类集合（存放基础包名下的所有类）
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取包名下所有类
     * @return
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /**
     * 获取基础包名下所有Service
     * @return
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> serviceClassSet = new HashSet<>();
        if(CollectionUtils.isNotEmpty(CLASS_SET)){
            serviceClassSet = CLASS_SET.stream().filter(clazz -> clazz.isAnnotationPresent(Service.class)).collect(Collectors.toSet());
        }
        return serviceClassSet;
    }

    /**
     * 获取基础包下所有Controller
     * @return
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> serviceClassSet = new HashSet<>();
        if(CollectionUtils.isNotEmpty(CLASS_SET)){
            serviceClassSet = CLASS_SET.stream().filter(clazz -> clazz.isAnnotationPresent(Controller.class)).collect(Collectors.toSet());
        }
        return serviceClassSet;
    }

    /**
     * 获取基础包名下所有 Bean 类（包括：Controller、Service）
     * @return
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> serviceClassSet = new HashSet<>();
        if(CollectionUtils.isNotEmpty(CLASS_SET)){
            serviceClassSet.addAll(getControllerClassSet());
            serviceClassSet.addAll(getServiceClassSet());
        }
        return serviceClassSet;
    }

    /**
     *  获取基础包名下某父类的所有子类 或某接口的所有实现类
     * @return
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass){
        Set<Class<?>> serviceClassSet = new HashSet<>();
        if(CollectionUtils.isNotEmpty(CLASS_SET)){
            Set<Class<?>> collect = CLASS_SET.stream().filter(clazz -> superClass.isAssignableFrom(clazz) && !superClass.equals(clazz)).collect(Collectors.toSet());
            serviceClassSet.addAll(collect);
        }
        return serviceClassSet;
    }
}
