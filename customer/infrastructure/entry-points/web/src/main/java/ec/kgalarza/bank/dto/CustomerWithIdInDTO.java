package ec.kgalarza.bank.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerWithIdInDTO {

    @NotNull(message = "Customer ID must not be null")
    @Min(value = 1, message = "Customer ID must be a positive number")
    private Long customerId;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    private boolean status;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Gender cannot be empty")
    @Pattern(regexp = "M|F|O", message = "Gender must be M, F or O")
    private String gender;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    private Integer age;

    @NotBlank(message = "Identification cannot be empty")
    @Size(min = 6, max = 20, message = "Identification must be between 6 and 20 characters")
    private String identification;

    @NotBlank(message = "Address cannot be empty")
    private String address;

    @NotBlank(message = "Phone cannot be empty")
    @Pattern(regexp = "\\d{10,15}", message = "Phone must be between 10 and 15 digits")
    private String phone;


}
