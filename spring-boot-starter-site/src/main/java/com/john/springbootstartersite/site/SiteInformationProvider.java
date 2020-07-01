package com.john.springbootstartersite.site;

import lombok.Getter;

/**
 * @author John Lee
 * @Version
 * @Description
 * @date 2020/6/12 11:35
 */
@Getter
public class SiteInformationProvider {

    SiteInformation siteInformation;

    public SiteInformationProvider(SiteInformation siteInformation) {
        this.siteInformation = siteInformation;
    }

}
