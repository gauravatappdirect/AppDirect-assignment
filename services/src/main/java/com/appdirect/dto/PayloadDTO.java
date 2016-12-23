package com.appdirect.dto;

/**
 * Created by gaurav on 24/12/16.
 */
public class PayloadDTO {
    private CompanyDTO company;
    private OrderDTO order;

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "company=" + company +
                ", order=" + order +
                '}';
    }
}
