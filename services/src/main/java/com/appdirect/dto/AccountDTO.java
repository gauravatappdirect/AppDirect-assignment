package com.appdirect.dto;

import com.appdirect.enums.AccountStatus;

/**
 * Created by gaurav on 24/12/16.
 */
public class AccountDTO {
    String accountIdentifier;
    AccountStatus accountStatus;

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
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
