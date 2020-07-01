package com.example.starterweb.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/16 10:58
 */
@Component
@Data
@ConfigurationProperties("spring.datasource")
public class DataSourceProperties {

    private DruidDataSource master;
    private DruidDataSource slave;
}
