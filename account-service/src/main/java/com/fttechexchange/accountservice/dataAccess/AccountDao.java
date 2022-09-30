package com.fttechexchange.accountservice.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fttechexchange.accountservice.entity.Account;

public interface AccountDao extends JpaRepository<Account,Integer> {

}
