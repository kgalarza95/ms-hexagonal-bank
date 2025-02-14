package ec.kgalarza.bank.model.dto;

import java.time.LocalDateTime;

public class AccountStatementReportDto {

    private LocalDateTime transactionDate;
    private String customerName;
    private String accountNumber;
    private String accountType;
    private double initialBalance;
    private double transactionAmount;
    private double availableBalance;
    private String transactionDescription;
    private Boolean accountStatus;

    public AccountStatementReportDto(LocalDateTime transactionDate, String customerName, String accountNumber,
                                     String accountType, double initialBalance, double transactionAmount,
                                     double availableBalance, String transactionDescription, Boolean accountStatus) {
        this.transactionDate = transactionDate;
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
        this.transactionAmount = transactionAmount;
        this.availableBalance = availableBalance;
        this.transactionDescription = transactionDescription;
        this.accountStatus = accountStatus;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public Boolean getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
}
