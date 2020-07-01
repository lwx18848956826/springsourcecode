package com.study.utils;

import com.study.annotation.Autowired;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 11:15
 */
public final class IocHelper {

    /**
     * 遍历所有的bean及其bean属性，为所有的@Autowired注解属性注入实例
     */
    static {
        // 遍历Map中所有的bean
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if(MapUtils.isNotEmpty(beanMap)){
            beanMap.forEach((k,v)->{
                // bean的Class
                Class<?> beanClass = k;
                // bean的实例
                Object beanInstance =  v;
                // 反射获取属性
                Field[] fields = beanClass.getDeclaredFields();
                List<Field> beanFields = Arrays.asList(fields);
                if(CollectionUtils.isNotEmpty(beanFields)){
                    beanFields.stream().filter(field -> field.isAnnotationPresent(Autowired.class)).forEach(field -> {
                        // 属性类型
                        Class<?>  beanFieldClass = field.getType();
                        // 如果beanFieldClass 是接口，就获取实现类
                        beanFieldClass = findImplementClass(beanFieldClass);
                        // 获取Class对应的实例
                        Object o = beanMap.get(beanFieldClass);
                        if(o != null){
                            ReflectionUtil.setField(beanInstance,field,o);
                        }
                    });
                }
            });
        }
    }

    /**
     * 获取接口对应的实现类
     * @param interfaceClass
     * @return
     */
    public static Class<?> findImplementClass(Class<?> interfaceClass) {
        Class<?> implementClass = interfaceClass;
        // 接口对应所有的实现类
        Set<Class<?>> classSuperClass = ClassHelper.getClassSetBySuper(implementClass);
        if(CollectionUtils.isNotEmpty(classSuperClass)){
            implementClass = classSuperClass.iterator().next();
        }
        return implementClass;
    }
}
