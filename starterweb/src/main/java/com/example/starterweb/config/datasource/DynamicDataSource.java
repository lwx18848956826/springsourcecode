package com.example.starterweb.config.datasource;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/15 10:41
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {


    @Override
    protected Object determineCurrentLookupKey() {
        log.info("数据源为---" + DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
