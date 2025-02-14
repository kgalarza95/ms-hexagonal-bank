package com.kgalarza.bank.gateway;

import java.util.List;

public interface AccountRepositoryGateway {

    Account save(Account account);
    Account findById(Long id);
    List<Account> findAll();
}
