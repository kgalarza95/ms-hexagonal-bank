package ec.kgalarza.bank.dto;

import lombok.Data;

@Data
public class CustomerOutDTO {

    private Long customerId;
    private String password;
    private boolean status;
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;

}
