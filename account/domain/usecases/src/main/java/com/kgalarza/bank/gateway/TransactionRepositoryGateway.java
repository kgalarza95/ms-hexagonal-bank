package com.kgalarza.bank.gateway;

import com.kgalarza.bank.entity.Account;
import com.kgalarza.bank.entity.Transaction;

import java.util.List;

public interface TransactionRepositoryGateway {
    Transaction save(Transaction transaction);
    Transaction findById(Long id);
    List<Transaction> findAll();
}
