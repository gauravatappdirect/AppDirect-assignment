package com.appdirect.assignment.dto;

/**
 * Created by gaurav on 24/12/16.
 */
public class OrderDTO {
    private String editionCode;
    private String pricingDuration;
    private ItemsDTO items;

    public String getEditionCode() {
        return editionCode;
    }

    public void setEditionCode(String editionCode) {
        this.editionCode = editionCode;
    }

    public String getPricingDuration() {
        return pricingDuration;
    }

    public void setPricingDuration(String pricingDuration) {
        this.pricingDuration = pricingDuration;
    }

    public ItemsDTO getItems() {
        return items;
    }

    public void setItems(ItemsDTO items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "editionCode='" + editionCode + '\'' +
                ", pricingDuration='" + pricingDuration + '\'' +
                ", items=" + items +
                '}';
    }
}
