package com.spring.mvc.data;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/23 14:36
 */
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
