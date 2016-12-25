package com.appdirect.assignment.persist.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by gaurav on 24/12/16.
 */
@Entity
public class Account  {
    @Id
    private String uuid;
    private String accountStatus;

    @OneToOne
    @Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE, CascadeType.MERGE})
    private User creator;

    @OneToMany
    @Cascade({CascadeType.PERSIST, CascadeType.SAVE_UPDATE, CascadeType.MERGE})
    private List<User> users;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
