package ec.kgalarza.bank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionInDTO {

    private BigDecimal initialBalance;
    private BigDecimal transactionAmount;
    private BigDecimal availableBalance;
    private String transactionDescription;
    private Long accountId;
}
