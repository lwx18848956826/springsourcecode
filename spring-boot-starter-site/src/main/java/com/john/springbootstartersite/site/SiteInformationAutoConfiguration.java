package com.john.springbootstartersite.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/12 11:40
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(SiteInformation.class)
public class SiteInformationAutoConfiguration {

    @Autowired
    private SiteInformation siteInformation;

    @Bean
    @ConditionalOnMissingBean(SiteInformationProvider.class)
    public SiteInformationProvider provider(){
        SiteInformationProvider provider = new SiteInformationProvider(siteInformation);
        return provider;
    }
}
