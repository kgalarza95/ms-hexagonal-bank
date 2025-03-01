package ec.kgalarza.bank.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionOutDTO(
        Long id,
        LocalDateTime transactionDate,
        BigDecimal initialBalance,
        BigDecimal transactionAmount,
        BigDecimal availableBalance,
        String transactionDescription
) {
}

