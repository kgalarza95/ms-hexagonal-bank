package ec.kgalarza.bank.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransactionInDTO(
        @NotNull(message = "Transaction amount cannot be null")
        BigDecimal transactionAmount,

        @NotNull(message = "Account ID cannot be null")
        @Positive(message = "Account ID must be a positive number")
        Long accountId) {
}
