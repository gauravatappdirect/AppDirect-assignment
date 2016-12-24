package com.appdirect.assignment.persist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by gaurav on 24/12/16.
 */
@Entity
public class Account {
    @Id
    private String id;
    private String accountStatus;

    public String getAccountIdentifier() {
        return id;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.id = accountIdentifier;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
