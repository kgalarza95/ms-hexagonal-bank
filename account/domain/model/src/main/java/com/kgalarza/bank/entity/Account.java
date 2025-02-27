package com.kgalarza.bank.entity;

import java.math.BigDecimal;
import java.util.List;

public class Account {

    private Long id;
    private String accountNumber;
    private String accountType;
    private BigDecimal onlineBalance;
    private boolean status;
    private Long customerId;
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(Long id, String accountNumber, String accountType, BigDecimal onlineBalance, boolean status, Long customerId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.onlineBalance = onlineBalance;
        this.status = status;
        this.customerId = customerId;
    }

    public Account(Long id, String accountNumber, String accountType, BigDecimal onlineBalance, boolean status, Long customerId, List<Transaction> transactions) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.onlineBalance = onlineBalance;
        this.status = status;
        this.customerId = customerId;
        this.transactions = transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getOnlineBalance() {
        return onlineBalance;
    }

    public void setOnlineBalance(BigDecimal onlineBalance) {
        this.onlineBalance = onlineBalance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
