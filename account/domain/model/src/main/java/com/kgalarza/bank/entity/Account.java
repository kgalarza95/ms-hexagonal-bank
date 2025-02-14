package com.kgalarza.bank.entity;

public class Account {

    private Long id;
    private String accountNumber;
    private String accountType;
    private double onlineBalance;
    private boolean status;
    private Long customerId;


    public Account() {
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

    public double getOnlineBalance() {
        return onlineBalance;
    }

    public void setOnlineBalance(double onlineBalance) {
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
}
