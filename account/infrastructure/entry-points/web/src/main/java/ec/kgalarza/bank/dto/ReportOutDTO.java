package ec.kgalarza.bank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReportOutDTO(
        LocalDateTime transactionDate,
        String customerName,
        String accountNumber,
        String accountType,
        BigDecimal initialBalance,
        BigDecimal transactionAmount,
        BigDecimal availableBalance,
        String transactionDescription,
        Boolean accountStatus
) {}

