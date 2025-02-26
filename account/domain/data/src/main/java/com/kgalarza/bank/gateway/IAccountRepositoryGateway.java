package com.kgalarza.bank.gateway;

import com.kgalarza.bank.entity.Account;

import java.util.List;

public interface IAccountRepositoryGateway {

    Account save(Account account);
    Account findById(Long id);
    Account findByAccountNumber(String accountNumber);
    List<Account> findAll();
}
