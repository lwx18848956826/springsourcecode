package com.study.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 11:02
 */
public final class BeanHelper {

    /**
     * BEAN_MAP相当于一个Spring容器, 拥有应用所有bean的实例
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        // 获取应用中所有的Bean
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        // 将Bean实例化放入容器之中
        if(CollectionUtils.isNotEmpty(beanClassSet)){
            beanClassSet.forEach(clazz ->{
                Object o = ReflectionUtil.newInstance(clazz);
                BEAN_MAP.put(clazz,o);
            });
        }
    }

    /**
     * 获取bean容器
     * @return
     */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    /**
     * 获取bean实例
     */
    public static  <T> T getBean(Class<?> clazz){
        if(!BEAN_MAP.containsKey(clazz)){
            throw new RuntimeException("can not get bean by class:" + clazz);
        }
        return (T) BEAN_MAP.get(clazz);
    }

    /**
     * 设置bean实例
     */
    public static void setBean(Class<?> clazz,Object object){
        BEAN_MAP.put(clazz,object);
    }
}
