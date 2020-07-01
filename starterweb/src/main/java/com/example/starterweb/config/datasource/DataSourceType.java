package com.example.starterweb.config.datasource;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/16 10:51
 */
@AllArgsConstructor
@Getter
public enum DataSourceType {
    /**
     * 配置数据源
     */
    MASTER("datasourceMaster", "测试主数据源"),
    SLAVE("datasourceSlave", "测试从数据源");

    private String name;
    private String description;

}
