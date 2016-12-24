package com.appdirect.assignment.dto;

/**
 * Created by gaurav on 24/12/16.
 */
public class AccountDTO {
    private  String accountIdentifier;
    private String accountStatus;

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountIdentifier='" + accountIdentifier + '\'' +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
