package ec.kgalarza.bank.entity;

public class Customer extends Person{
    private Long customerId;
    private String password;
    private boolean status;

    public Customer() {
    }

    public Customer(Long customerId, String password, boolean status) {
        this.customerId = customerId;
        this.password = password;
        this.status = status;
    }

    public Customer(String name, String gender, Integer age, String identification, String address, String phone, Long customerId, String password, boolean status) {
        super(name, gender, age, identification, address, phone);
        this.customerId = customerId;
        this.password = password;
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

}
