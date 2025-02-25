package ec.kgalarza.bank.dto;

import lombok.Data;

@Data
public class TransactionInDTO {

    private double initialBalance;
    private double transactionAmount;
    private double availableBalance;
    private String transactionDescription;
    private Long accountId;
}
