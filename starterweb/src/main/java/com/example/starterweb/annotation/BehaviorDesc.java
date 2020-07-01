package com.example.starterweb.annotation;

import java.lang.annotation.*;

/**
 * @author John Lee
 * @Version
 * @Description
 * @date 2020/6/12 20:12
 */
@Documented //说明该注解将被包含在javadoc中
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target(ElementType.METHOD)//
public @interface BehaviorDesc {

    /**
     * 行为描述，数据类型为String类型
     * @return
     */
    String value() default "未知操作";
}
