package com.example.starterweb.config.datasource;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/15 10:42
 */
public class DataSourceContextHolder {

    /**
     * 默认的数据源
     */
    public static final String DEFAULT_DB = "datasource1";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param dbType
     */
    public static void setDB(String dbType) {
        System.out.println("切换到---" + dbType + "---数据源");
        contextHolder.set(dbType);
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static String getDB() {
        return (contextHolder.get());
    }

    /**
     * 清除数据源
     */
    public static void clearDB() {
        contextHolder.remove();
    }

}
