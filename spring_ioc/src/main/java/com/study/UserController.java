package com.study;

import com.study.utils.ClassHelper;

import java.util.Set;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 16:15
 */
public class UserController {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(ClassHelper.class.getName());
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        System.out.println(aClass);
    }
}
