package ec.kgalarza.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer", uniqueConstraints = @UniqueConstraint(columnNames = "customer_id"))
public class CustomerEntity extends PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String password;
    private boolean status;

    public CustomerEntity() {
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
