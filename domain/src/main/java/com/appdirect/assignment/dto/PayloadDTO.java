package com.appdirect.assignment.dto;

/**
 * Created by gaurav on 24/12/16.
 */
public class PayloadDTO {
    private CompanyDTO company;
    private OrderDTO order;
    private AccountDTO account;

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

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
        return "PayloadDTO{" +
                "company=" + company +
                ", order=" + order +
                ", account=" + account +
                '}';
    }
}
