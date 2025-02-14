package com.kgalarza.bank.gateway;

import com.kgalarza.bank.entity.Account;

import java.util.List;

public interface AccountRepositoryGateway {

    Account save(Account account);
    Account findById(Long id);
    List<Account> findAll();
}
