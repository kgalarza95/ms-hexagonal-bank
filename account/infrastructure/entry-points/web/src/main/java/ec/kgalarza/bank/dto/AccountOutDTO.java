package ec.kgalarza.bank.dto;

import lombok.Data;

@Data
public class AccountOutDTO {
    private Long id;
    private String accountNumber;
    private String accountType;
    private double onlineBalance;
    private boolean status;
    private Long customerId;

}
