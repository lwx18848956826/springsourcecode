package com.spring.constants;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/17 13:41
 */
public interface ConfigConstant {

    /**
     * 配置文件的名称
     */
    String CONFIG_FILE = "application.properties";

    /**
     * 数据源
     */
    String JDBC_DRIVER = "com.spring.framework.jdbc.driver";
    String JDBC_URL = "com.spring.framework.jdbc.url";
    String JDBC_USERNAME = "com.spring.framework.jdbc.username";
    String JDBC_PASSWORD = "com.spring.framework.jdbc.password";

    /**
     * java源码地址
     */
    String APP_BASE_PACKAGE = "com.spring.framework.app.base_package";
    /**
     * jsp页面路径
     */
    String APP_JSP_PATH = "com.spring.framework.app.jsp_path";
    /**
     * 静态资源路径
     */
    String APP_ASSET_PATH = "com.spring.framework.app.asset_path";
}
