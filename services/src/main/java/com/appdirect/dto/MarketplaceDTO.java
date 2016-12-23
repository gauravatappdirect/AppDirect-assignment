package com.appdirect.dto;

/**
 * Created by gaurav on 24/12/16.
 */
public class MarketplaceDTO {
    private String baseUrl;
    private String partner;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    @Override
    public String toString() {
        return "Marketplace{" +
                "baseUrl='" + baseUrl + '\'' +
                ", partner='" + partner + '\'' +
                '}';
    }
}
