package ec.kgalarza.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReportOutDTO {

    private LocalDateTime transactionDate;
    private String customerName;
    private String accountNumber;
    private String accountType;
    private BigDecimal initialBalance;
    private BigDecimal transactionAmount;
    private BigDecimal availableBalance;
    private String transactionDescription;
    private Boolean accountStatus;

}
