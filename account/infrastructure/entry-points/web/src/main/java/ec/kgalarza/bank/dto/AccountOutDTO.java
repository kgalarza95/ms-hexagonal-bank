package ec.kgalarza.bank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountOutDTO {
    private Long id;
    private String accountNumber;
    private String accountType;
    private BigDecimal onlineBalance;
    private boolean status;
    private Long customerId;

}
