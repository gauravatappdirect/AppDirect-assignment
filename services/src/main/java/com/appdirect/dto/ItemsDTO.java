package com.appdirect.dto;

/**
 * Created by gaurav on 24/12/16.
 */
public class ItemsDTO {
    private int quantity;
    private String unit;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Items{" +
                "quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
