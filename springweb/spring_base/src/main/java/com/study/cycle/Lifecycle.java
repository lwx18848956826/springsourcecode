package com.study.cycle;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 17:12
 */
public interface Lifecycle {
    void start();

    void stop();

    boolean isRunning();
}
