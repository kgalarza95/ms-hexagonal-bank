package ec.kgalarza.bank.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatementReportDto {

    private LocalDateTime transactionDate;
    private String customerName;
    private String accountNumber;
    private String accountType;
    private BigDecimal initialBalance;
    private BigDecimal transactionAmount;
    private BigDecimal availableBalance;
    private String transactionDescription;
    private Boolean accountStatus;

//    public AccountStatementReportDto(LocalDateTime transactionDate, String customerName, String accountNumber,
//                                     String accountType, BigDecimal initialBalance, BigDecimal transactionAmount,
//                                     BigDecimal availableBalance, String transactionDescription, Boolean accountStatus) {
//        this.transactionDate = transactionDate;
//        this.customerName = customerName;
//        this.accountNumber = accountNumber;
//        this.accountType = accountType;
//        this.initialBalance = initialBalance;
//        this.transactionAmount = transactionAmount;
//        this.availableBalance = availableBalance;
//        this.transactionDescription = transactionDescription;
//        this.accountStatus = accountStatus;
//    }

}
