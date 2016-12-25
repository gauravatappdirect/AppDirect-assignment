package com.appdirect.assignment.repository;

import com.appdirect.assignment.persist.entity.Account;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gaurav on 24/12/16.
 */
@Configurable
public interface AccountRepository extends JpaRepository<Account, String> {
}
