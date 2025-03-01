package ec.kgalarza.bank.dto;

import java.math.BigDecimal;

public record AccountOutDTO(
        Long id,
        String accountNumber,
        String accountType,
        BigDecimal onlineBalance,
        boolean status,
        Long customerId
) {}

