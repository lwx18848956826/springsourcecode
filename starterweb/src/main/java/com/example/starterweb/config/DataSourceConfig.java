package com.example.starterweb.config;

/*import com.alibaba.druid.pool.DruidDataSource;
import com.example.starterweb.config.datasource.DynamicDataSource;
import com.google.common.collect.Maps;*/

import com.example.starterweb.config.datasource.DataSourceProperties;
import com.example.starterweb.config.datasource.DynamicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/15 10:24
 */
@Configuration
public class DataSourceConfig {


    @Resource
    private DataSourceProperties dataSourceProperties;

    /**
     * 配置动态数据源，通过aop切换数据源
     *
     * @return
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> dbMap = new HashMap<>(16);
        dbMap.put("datasourceMaster", dataSourceProperties.getMaster());
        dbMap.put("datasourceSlave", dataSourceProperties.getSlave());
        dynamicDataSource.setDefaultTargetDataSource(dataSourceProperties.getMaster());
        dynamicDataSource.setTargetDataSources(dbMap);
        return dynamicDataSource;
    }

    /**
     * 配置Transaction，统一管理
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}
