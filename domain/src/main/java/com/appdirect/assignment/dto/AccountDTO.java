package com.appdirect.assignment.dto;

/**
 * Created by gaurav on 24/12/16.
 */
public class AccountDTO {
    private  String accountIdentifier;
    private String status;

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountIdentifier='" + accountIdentifier + '\'' +
                ", status=" + status +
                '}';
    }
}
