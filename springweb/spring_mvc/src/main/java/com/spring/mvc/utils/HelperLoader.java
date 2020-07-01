package com.spring.mvc.utils;

import com.study.utils.BeanHelper;
import com.study.utils.ClassHelper;
import com.study.utils.ClassUtil;
import com.study.utils.IocHelper;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 14:47
 */
public class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> clazz : classList){
            ClassUtil.loadClass(clazz.getName());
        }
    }
}
