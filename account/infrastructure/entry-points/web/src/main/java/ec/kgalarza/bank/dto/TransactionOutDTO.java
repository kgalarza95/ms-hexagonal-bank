package ec.kgalarza.bank.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionOutDTO {

    private Long id;
    private LocalDateTime transactionDate;
    private double initialBalance;
    private double transactionAmount;
    private double availableBalance;
    private String transactionDescription;

}
