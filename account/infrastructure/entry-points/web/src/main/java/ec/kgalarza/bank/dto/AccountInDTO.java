package ec.kgalarza.bank.dto;


import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record AccountInDTO(
        @NotBlank(message = "Account number cannot be empty")
        @Size(min = 5, max = 20, message = "Account number must be between 5 and 20 characters")
        String accountNumber,

        @NotBlank(message = "Account type cannot be empty")
        @Pattern(regexp = "^(Ahorro|Corriente)$", message = "Account type must be 'Ahorro' or 'Corriente'")
        String accountType,

        @NotNull(message = "Online balance cannot be null")
        @PositiveOrZero(message = "Online balance must be zero or positive")
        BigDecimal onlineBalance,

        boolean status,

        @NotNull(message = "Customer ID cannot be null")
        @Positive(message = "Customer ID must be a positive number")
        Long customerId
) {
}
