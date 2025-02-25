package ec.kgalarza.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReportOutDTO {

    private LocalDateTime transactionDate;
    private String customerName;
    private String accountNumber;
    private String accountType;
    private double initialBalance;
    private double transactionAmount;
    private double availableBalance;
    private String transactionDescription;
    private Boolean accountStatus;

}
