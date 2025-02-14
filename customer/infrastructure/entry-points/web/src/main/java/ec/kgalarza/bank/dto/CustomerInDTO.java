package ec.kgalarza.bank.dto;

import jakarta.validation.constraints.*;

public class CustomerInDTO {

    @NotBlank(message = "Password cannot be empty")
    private String password;

    private boolean status;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Gender cannot be empty")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
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

    public CustomerInDTO() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
