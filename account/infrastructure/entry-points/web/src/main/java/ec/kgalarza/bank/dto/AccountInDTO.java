package ec.kgalarza.bank.dto;

import lombok.Data;

@Data
public class AccountInDTO {

    private String accountNumber;
    private String accountType;
    private double onlineBalance;
    private boolean status;
    private Long customerId;

}
