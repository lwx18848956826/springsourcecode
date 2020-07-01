package com.study.handler;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/22 11:53
 */
public interface HandlerAdapter {
    boolean supports(Object handler);
    void handle(Object handler);
}
