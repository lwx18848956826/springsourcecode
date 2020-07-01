package com.john.springbootstartersite.site;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/12 11:27
 */
@Component
@Data
@ConfigurationProperties(prefix = "site")
public class SiteInformation {

    private final static String NAME = "UNKOWN";
    private final static String DOMAIN = "UNKOWN";
    private final static String COPYRIGHT = "UNKOWN";
    private final static String KEYWORDS = "UNKOWN";
    private final static String DESCRIPTION = "UNKOWN";

    private String name = NAME;
    private String domain = DOMAIN;
    private String copyRight = COPYRIGHT;
    private String keyWords = KEYWORDS;
    private String description = DESCRIPTION;
}
