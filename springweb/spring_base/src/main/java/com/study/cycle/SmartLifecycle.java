package com.study.cycle;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 17:14
 */
public interface SmartLifecycle extends Lifecycle, Phased {

    boolean isAutoStartup();

    void stop(Runnable callback);
}
